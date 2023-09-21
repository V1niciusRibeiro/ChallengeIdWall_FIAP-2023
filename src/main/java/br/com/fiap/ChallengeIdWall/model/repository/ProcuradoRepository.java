package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Procurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcuradoRepository  extends JpaRepository<Procurado, Integer> {

    @Query("SELECT p FROM Procurado p " +
            "WHERE LOWER(p.localNascimento) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.altura) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.corOlhos) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.peso) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.corCabelo) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.ocupacao) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.idiomas) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.nacionalidade) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.descricao) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.recompensa) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.raca) LIKE LOWER(CONCAT('%', :stringDeBusca, '%'))")
    List<Procurado> findByAll(@Param("stringDeBusca") String stringDeBusca);

    List<Procurado> findByAltura(Double altura);

    List<Procurado> findByLocalNascimento(String nasclocal);

}