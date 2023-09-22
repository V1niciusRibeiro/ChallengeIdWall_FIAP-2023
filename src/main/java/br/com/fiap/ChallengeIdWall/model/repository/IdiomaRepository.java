package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Integer> {

    @Query("SELECT i FROM Idioma i WHERE i.nome LIKE %:partialName%")
    List<Idioma> findByPartialNome(String partialName);

    List<Idioma> findByNome(String nome);

    List<Idioma> findByIdiomaFalado(String idiomaFalado);

}