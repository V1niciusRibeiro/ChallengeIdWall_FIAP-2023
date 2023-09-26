package br.com.fiap.ChallengeIdWall;

import br.com.fiap.ChallengeIdWall.Model.DataSource.FBI.FBInvestigationJson;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChallengeIdWallApplication {

	public static void main(String[] args) throws IOException {

		/*
		System.out.println(InterpolAPI.getInstance().execute());
		LoadDB.populateDB(InterpolAPI.getInstance().execute());
		SpringApplication.run(ChallengeIdWallApplication.class, args);
		 */
		FBInvestigationJson.getCleanJson();
	}

}
