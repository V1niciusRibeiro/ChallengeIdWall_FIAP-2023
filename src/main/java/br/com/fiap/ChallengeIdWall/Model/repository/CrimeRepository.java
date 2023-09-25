package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Integer> {
    List<Crime> findByType(String type);
    List<Crime> findByDescription(String description);
    List<Crime> findByCountryId(int countryId);
}