package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Idioma;
import br.com.fiap.ChallengeIdWall.Model.entity.IdiomaFalado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Integer> {

    @Query("SELECT i FROM Idioma i WHERE i.name LIKE %:partialName%")
    List<Idioma> findByPartialNome(String partialName);

    List<Idioma> findByName(String name);

    List<Idioma> findBySpokenLanguageId(int spokenLanguageId);

}