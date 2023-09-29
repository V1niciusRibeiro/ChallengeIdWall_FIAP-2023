package br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataMapper;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.FBInvestigationDataModel;
import br.com.fiap.ChallengeIdWall.Model.entity.Wanted;
import br.com.fiap.ChallengeIdWall.Model.repository.WantedRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler.FBInvestigationJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FBInvestigationDataMapper {

    @Autowired
    private WantedRepository wantedRepository;
    public void mapApiData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = FBInvestigationJson.jsonToString();
        System.out.println(apiResponse+"-------------APIRESPONSE-----------------");
        FBInvestigationDataModel externalData = objectMapper.readValue(apiResponse, FBInvestigationDataModel.class);

        Wanted wantedApiData = new Wanted(0,null,null,null,null, null, null,null, null, null ,null);
        wantedApiData.setRace(externalData.getRace());
        wantedApiData.setWeight(String.valueOf(externalData.getWeight()));
        wantedApiData.setEye(externalData.getEyes());
        wantedApiData.setHeight(String.valueOf(externalData.getHeightMax()));
        wantedApiData.setHair(externalData.getHair());
        wantedApiData.setSex(externalData.getSex());
        wantedApiData.setBirthPlace(externalData.getPlaceOfBirth());
        wantedApiData.setObservation(externalData.getAdditionalInformation());
        wantedApiData.setDescription(externalData.getDescription());
        wantedApiData.setCareful(externalData.getCaution());

        wantedRepository.save(wantedApiData);
    }
}


