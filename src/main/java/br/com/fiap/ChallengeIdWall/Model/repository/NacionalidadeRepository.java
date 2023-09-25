package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Integer> {
    List<Nacionalidade> findByCountryId(int CountryId);
    List<Nacionalidade> findByWantedId(int wantedId);
}
