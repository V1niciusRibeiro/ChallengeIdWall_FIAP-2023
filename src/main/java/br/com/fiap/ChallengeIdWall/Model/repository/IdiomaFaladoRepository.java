package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Identidade;
import br.com.fiap.ChallengeIdWall.Model.entity.Idioma;
import br.com.fiap.ChallengeIdWall.Model.entity.IdiomaFalado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaFaladoRepository extends JpaRepository<IdiomaFalado, Integer> {
    List<Identidade> findByLanguage(Idioma language);
    List<Identidade> findByWantedId(int wantedId);
}
