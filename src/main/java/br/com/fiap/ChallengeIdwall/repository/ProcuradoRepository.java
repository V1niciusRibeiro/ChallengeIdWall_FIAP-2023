package br.com.fiap.ChallengeIdwall.repository;

import br.com.fiap.ChallengeIdwall.model.Procurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.List;
@Repository
public interface ProcuradoRepository  extends JpaRepository<Procurado, Integer> {
  //  List<Procurado> findByIdProcurado(Integer id);

     List<Procurado> findByAltura(Double altura);
     List<Procurado> findByLocalNascimento(String nasclocal);

}
