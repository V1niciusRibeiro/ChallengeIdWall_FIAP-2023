package br.com.fiap.ChallengeIdWall;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager.InterpolAPI;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler.InterpolJson;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChallengeIdWallApplication {

	public static void main(String[] args) throws IOException {

		System.out.println(InterpolJson.generateEntities(
				"{\"date_of_birth\":\"2005/04/01\",\"distinguishing_marks\":null,\"weight\":null,\"nationalities\":[\"NL\"],\"entity_id\":\"2023/54608\",\"eyes_colors_id\":null,\"sex_id\":\"M\",\"place_of_birth\":null,\"forename\":\"DAMANICHIO\",\"arrest_warrants\":[{\"charge\":\"violation of the weapon legislation\\r\\nparticiaption in a criminal organisation\",\"issuing_country_id\":\"BE\",\"charge_translation\":null}],\"country_of_birth_id\":null,\"hairs_id\":null,\"name\":\"HALL\",\"languages_spoken_ids\":null,\"height\":null,\"_embedded\":{\"links\":[]},\"_links\":{\"self\":{\"href\":\"https://ws-public.interpol.int/notices/v1/red/2023-54608\"},\"images\":{\"href\":\"https://ws-public.interpol.int/notices/v1/red/2023-54608/images\"},\"thumbnail\":{\"href\":\"https://ws-public.interpol.int/notices/v1/red/2023-54608/images/62832956\"}}}"
		));

	}

}
