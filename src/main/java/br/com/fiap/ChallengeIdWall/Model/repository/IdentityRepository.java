package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Integer> {

    @Query("SELECT i FROM Identity i " +
            "WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :partialNameOrLastName, '%')) " +
            "   OR LOWER(i.lastName) LIKE LOWER(CONCAT('%', :partialNameOrLastName, '%'))")
    List<Identity> findByPartialNameOrLastName(@Param("partialNameOrLastName") String partialNameOrLastName);

    List<Identity> findByName(String name);

    List<Identity> findBySex(String sex);

    List<Identity> findByBirthDate(Date birthDate);

    List<Identity> findByNameAndLastName(String name, String lastName);

}