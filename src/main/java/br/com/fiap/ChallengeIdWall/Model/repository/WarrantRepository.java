package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Warrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarrantRepository extends JpaRepository<Warrant, Integer> {

    List<Warrant> findByCountryId(int countryId);
    List<Warrant> findByWantedId(int wantedId);
    Warrant findByIdAndWantedId(int id, int wantedId);
}