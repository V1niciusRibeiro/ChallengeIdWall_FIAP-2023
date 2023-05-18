package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.Identidade;
import br.com.fiap.ChallengeIdWall.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
    List<Pais> findByNome(String nome);
}
