package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.MandadoPrisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MandadoPrisaoRepository extends JpaRepository<MandadoPrisao, Integer> {

    List<MandadoPrisao> findByCountryId(int countryId);
    List<MandadoPrisao> findByWantedId(int wantedId);
    MandadoPrisao findByIdAndWantedId(int id, int wantedId);
}