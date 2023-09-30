package br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByName(String name);
}
