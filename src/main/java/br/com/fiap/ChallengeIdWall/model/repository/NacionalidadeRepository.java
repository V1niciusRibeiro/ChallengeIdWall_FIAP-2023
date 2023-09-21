package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Integer> {
    List<Nacionalidade> findByPaisId(int id);
    List<Nacionalidade> findByProcuradoId(int id);
}
