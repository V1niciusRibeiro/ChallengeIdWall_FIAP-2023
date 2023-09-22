package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.*;
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
            "   OR LOWER(p.olho) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.peso) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.cabelo) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.idioma) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.nacionalidade) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.descricao) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.raca) LIKE LOWER(CONCAT('%', :stringDeBusca, '%'))")
    List<Procurado> findByLike(@Param("stringDeBusca") String stringDeBusca);
    List<Procurado> findByAltura(Double altura);

    List<Procurado> findByLocalNascimento(String localNascimento);

    List<Procurado> findByRaca(String raca);

    List<Procurado> findByPeso(String peso);

    List<Procurado> findByOlho(String olho);

    List<Procurado> findByCabelo(String cabelo);

    List<Procurado> findBySexo(String sexo);

    List<Procurado> findByCautela(String cautela);

    List<Procurado> findByIdiomaNome(String nomeIdioma);

    List<Procurado> findByMandado(Crime tipoMandado);

    List<Procurado> findByIdentidade(Identidade identidade);

    List<Procurado> findByNacionalidade(List<Nacionalidade> nacionalidade);

    List<Procurado> findByApelido(String apelido);


}