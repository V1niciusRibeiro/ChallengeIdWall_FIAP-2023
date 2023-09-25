package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Identidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IdentidadeRepository extends JpaRepository<Identidade, Integer> {

    @Query("SELECT i FROM Identidade i " +
            "WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(i.lastName) LIKE LOWER(CONCAT('%', :stringDeBusca, '%'))")
    List<Identidade> findByNomeOuSobrenomeContem(@Param("stringDeBusca") String stringDeBusca);

    List<Identidade> findByName(String name);

    List<Identidade> findBySex(String sex);

    List<Identidade> findByBirthDate(Date birthDate);

    List<Identidade> findByNameAndLastName(String name, String lastName);

}