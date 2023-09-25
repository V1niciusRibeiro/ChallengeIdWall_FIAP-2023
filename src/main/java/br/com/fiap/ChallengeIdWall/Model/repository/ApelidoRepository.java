package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Apelido;
import br.com.fiap.ChallengeIdWall.Model.entity.Procurado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApelidoRepository extends JpaRepository<Apelido, Integer> {
    List<Apelido> findByName(String name);
    List<Apelido> findByWantedId(int wantedId);
    Apelido findByIdAndWantedId(int id, int wantedId);
}
