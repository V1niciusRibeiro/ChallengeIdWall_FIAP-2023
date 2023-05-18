package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.Identidade;
import br.com.fiap.ChallengeIdWall.model.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Integer> {
    List<Nacionalidade> findByPaisId(int id);
    List<Nacionalidade> findByProcuradoId(int id);
}
