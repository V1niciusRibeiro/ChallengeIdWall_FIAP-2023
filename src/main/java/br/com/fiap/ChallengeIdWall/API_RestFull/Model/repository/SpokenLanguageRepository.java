package br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.SpokenLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpokenLanguageRepository extends JpaRepository<SpokenLanguage, Integer> {
    List<SpokenLanguage> findByLanguageId(int languageId);
    List<SpokenLanguage> findByWantedId(int wantedId);
}
