package br.com.fiap.ChallengeIdwall.repository;


import br.com.fiap.ChallengeIdwall.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
  //  List<Registro> findByIdRegistro(Integer id);
    List<Registro> findByNome(String nome);
    List<Registro> findBySobrenome(String sobrenome);
    List<Registro> findByDtNasc(Calendar dtNasc);
    List<Registro> findBySexo(String sexo);
}
