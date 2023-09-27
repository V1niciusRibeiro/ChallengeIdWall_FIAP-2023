package br.com.fiap.ChallengeIdWall;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManeger.InterpolAPI;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChallengeIdWallApplication {

	public static void main(String[] args) throws IOException {

		System.out.println(InterpolAPI.getInstance().setAgeMax(18).setAgeMax(18).execute());

	}

}
