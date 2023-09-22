package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Apelido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApelidoRepository extends JpaRepository<Apelido, Integer> {
    List<Apelido> findByNome(String nome);
    List<Apelido> findByProcuradoId(int id);
    Apelido findById(int id_apelido, int id_procurado);
}
