package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Integer> {
    List<Crime> findByTipo(String tipo);
    List<Crime> findByDescricao(String descricao);
    List<Crime> findByPaisId(int id);
}