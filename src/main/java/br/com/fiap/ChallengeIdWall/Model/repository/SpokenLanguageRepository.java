package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.SpokenLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpokenLanguageRepository extends JpaRepository<SpokenLanguage, Integer> {
    List<SpokenLanguage> findByLanguage(String language);
    List<SpokenLanguage> findByWantedId(int wantedId);
}
