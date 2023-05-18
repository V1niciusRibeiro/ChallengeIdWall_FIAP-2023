package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.Identidade;
import br.com.fiap.ChallengeIdWall.model.Idioma;
import br.com.fiap.ChallengeIdWall.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Integer> {
    List<Identidade> findByNome(String nome);
}
