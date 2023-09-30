package br.com.fiap.ChallengeIdWall;

import br.com.fiap.ChallengeIdWall.DataBase.LoadDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ChallengeIdWallApplication {

	public static void main(String[] args) {

		try {

			ApplicationContext context = SpringApplication.run(ChallengeIdWallApplication.class, args);

			LoadDB loadDB = context.getBean(LoadDB.class);
			loadDB.loadDataBase();

		} catch (Exception e){
			System.err.println(e.getMessage());
		}
	}
}
