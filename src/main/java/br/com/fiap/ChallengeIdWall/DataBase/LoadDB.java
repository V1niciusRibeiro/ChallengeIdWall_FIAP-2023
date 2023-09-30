package br.com.fiap.ChallengeIdWall.DataBase;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.Wanted;
import br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository.WantedRepository;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager.FBInvestigationAPI;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager.InterpolAPI;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.FBI.FBIWantedPerson;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol.InterpolJsons;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol.InterpolNotice;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler.FBInvestigationJsonHandler;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler.InterpolJsonHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadDB {

    private final WantedRepository wantedRepository;

    public LoadDB(WantedRepository wantedRepository) {
        this.wantedRepository = wantedRepository;
    }

    public void loadDataBase() throws Exception {

        System.out.println("Entrou LOAD");

        wantedRepository.deleteAll();

        List<InterpolJsons> interpolJsonsList = InterpolJsonHandler.generateJsonData(
                InterpolAPI.getInstance().execute());
        System.out.println("Passou JSON Inerpol");
        List<Wanted> interpolWantedList = interpolJsonsList.stream()
                .map(this::mapInterpolToWanted).toList();

        List<FBIWantedPerson> fbiWantedPersonList = FBInvestigationJsonHandler.generateJsonData(
                FBInvestigationAPI.getInstance().execute());
        System.out.println("Passou JSON FBI");
        List<Wanted> fbiWantedList = fbiWantedPersonList.stream()
                .map(this::mapFbiToWanted).toList();

        System.out.println("Salvando no Banco");

        wantedRepository.saveAll(interpolWantedList);
        wantedRepository.saveAll(fbiWantedList);
    }

    private Wanted mapInterpolToWanted(InterpolJsons interpolJson) {
        System.out.println("Criando Wanted Interpol");
        InterpolNotice interpolNotice = interpolJson.getInterpolNotice();
        String eye = String.join(", ", interpolNotice.getEyes_colors_id());
        String hair = String.join(", ", interpolNotice.getHairs_id());
        String birthPlace = interpolNotice.getPlace_of_birth() + " - " + interpolNotice.getCountry_of_birth_id();
        String observation = "Wanted by Interpol -  Entity ID: " + interpolNotice.getEntity_id();

        return new Wanted(
                0,
                "",
                String.valueOf(interpolNotice.getWeight()),
                eye,
                String.valueOf(interpolNotice.getHeight()),
                hair,
                interpolNotice.getSex_id(),
                birthPlace,
                observation,
                interpolNotice.getDistinguishing_marks(),
                ""
        );
    }

    private Wanted mapFbiToWanted(FBIWantedPerson fbiWantedPerson) {

        System.out.println("Criando Wanted FBI");
        String observation = "Wanted by FBI -  Entity ID: " + fbiWantedPerson.getId() + "\n" + fbiWantedPerson.getDetails();

        return new Wanted(
                0,
                fbiWantedPerson.getRace(),
                String.valueOf(fbiWantedPerson.getWeight_max()),
                fbiWantedPerson.getEyes(),
                String.valueOf(fbiWantedPerson.getHeight_max()),
                fbiWantedPerson.getHair(),
                fbiWantedPerson.getSex(),
                fbiWantedPerson.getPlace_of_birth(),
                observation,
                fbiWantedPerson.getDescription(),
                fbiWantedPerson.getCaution()
        );
    }

}
