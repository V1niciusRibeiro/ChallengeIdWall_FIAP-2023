package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.Identidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.List;

@Repository
public interface IdentidadeRepository extends JpaRepository<Identidade, Integer> {
    List<Identidade> findByNome(String nome);
    List<Identidade> findBySobrenome(String sobrenome);
    List<Identidade> findByDtNasc(Calendar dtNasc);
    List<Identidade> findBySexo(String sexo);
}