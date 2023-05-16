package br.com.fiap.ChallengeIdwall.repository;

import br.com.fiap.ChallengeIdwall.model.Crime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CrimeRepository extends JpaRepository<Crime, Integer> {
   // List<Crime> findByIdCrime(Integer id);
    List<Crime> findByTipo(String tipo);
    List<Crime> findByDescricao(String descricao);
}
