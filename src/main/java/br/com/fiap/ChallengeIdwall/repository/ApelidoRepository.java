package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.Apelido;
import br.com.fiap.ChallengeIdWall.model.Procurado;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApelidoRepository extends JpaRepository<Apelido, Integer> {
    List<Apelido> findByNome(String nome);
    List<Apelido> findByProcuradoId(int id);
    Apelido findById(int id_apelido, int id_procurado);
}
