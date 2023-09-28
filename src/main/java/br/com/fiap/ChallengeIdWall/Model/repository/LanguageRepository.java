package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    @Query("SELECT i FROM Language i WHERE i.name LIKE %:partialName%")
    List<Language> findByPartialNome(String partialName);

    Language findByName(String name);

    List<Language> findBySpokenLanguageId(int spokenLanguageId);

}