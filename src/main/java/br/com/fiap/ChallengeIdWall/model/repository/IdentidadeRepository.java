package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Identidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IdentidadeRepository extends JpaRepository<Identidade, Integer> {

    @Query("SELECT i FROM Identidade i " +
            "WHERE LOWER(i.nome) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(i.sobrenome) LIKE LOWER(CONCAT('%', :stringDeBusca, '%'))")
    List<Identidade> findByNomeOuSobrenomeContem(@Param("stringDeBusca") String stringDeBusca);

    List<Identidade> findByNome(String nome);

    List<Identidade> findBySexo(String sexo);

    List<Identidade> findByDataNascimento(Date dataNascimento);

    List<Identidade> findByNomeAndSobrenome(String nome, String sobrenome);

}