package br.com.fiap.ChallengeIdWall;

import br.com.fiap.ChallengeIdWall.Model.DataSource.Interpol.InterpolAPI;
import br.com.fiap.ChallengeIdWall.Model.DataSource.LoadDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeIdWallApplication {

	public static void main(String[] args) {

		System.out.println(InterpolAPI.getInstance().execute());
		//LoadDB.populateDB(InterpolAPI.getInstance().execute());

		//SpringApplication.run(ChallengeIdWallApplication.class, args);
	}

}
