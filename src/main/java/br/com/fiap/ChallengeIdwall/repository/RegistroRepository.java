package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    List<Registro> findByNome(String nome);
    List<Registro> findBySobrenome(String sobrenome);
    List<Registro> findByDtNasc(Calendar dtNasc);
    List<Registro> findBySexo(String sexo);
}