package br.com.fiap.ChallengeIdWall;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataMapper.FBInvestigationDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager.InterpolAPI;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ChallengeIdWallApplication {

	@Autowired
	private FBInvestigationDataMapper dataMapper;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeIdWallApplication.class, args);

		//System.out.println(InterpolAPI.getInstance().setAgeMax(18).setAgeMax(18).execute());
	}
	@PostConstruct
	public void executeAfterStartup() throws Exception {
		dataMapper.mapApiData();
	}
}
