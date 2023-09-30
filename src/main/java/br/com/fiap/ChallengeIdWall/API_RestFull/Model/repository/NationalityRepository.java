package br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationalityRepository extends JpaRepository<Nationality, Integer> {
    List<Nationality> findByCountryId(int countryId);
    List<Nationality> findByWantedId(int wantedId);
}
