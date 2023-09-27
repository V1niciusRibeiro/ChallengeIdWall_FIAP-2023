package br.com.fiap.ChallengeIdWall.Model.DataSource.FBI.DataMapper;
import br.com.fiap.ChallengeIdWall.Model.DataSource.FBI.DataModel.FBInvestigationDataModel;
import br.com.fiap.ChallengeIdWall.Model.entity.Wanted;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FBInvestigationDataMapper {
    public Wanted mapApiData(String apiResponse) throws Exception {
        //apiResponse é basicamente o Json recebido do FBI em formato de String.
        ObjectMapper objectMapper = new ObjectMapper();
        FBInvestigationDataModel externalData = objectMapper.readValue(apiResponse, FBInvestigationDataModel.class);

        Wanted WantedApiData = new Wanted();

        WantedApiData.setRace(externalData.getRace());

        return WantedApiData;
    }
}


