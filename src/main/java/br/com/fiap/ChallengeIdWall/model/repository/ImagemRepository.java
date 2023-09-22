package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Crime;
import br.com.fiap.ChallengeIdwall.Model.entity.Imagem;
import br.com.fiap.ChallengeIdwall.Model.entity.Procurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

    List<Imagem> findByProcurado(int idProcurado);
    List<Imagem> findByGrande(String grande);
    List<Imagem> findByMiniatura(String miniatura);

}
