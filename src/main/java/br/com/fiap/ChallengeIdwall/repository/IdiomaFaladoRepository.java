package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaFaladoRepository extends JpaRepository<IdiomaFalado, Integer> {
    List<Identidade> findByIdioma(Idioma idioma);
    List<Identidade> findByProcuradoId(int id);
}
