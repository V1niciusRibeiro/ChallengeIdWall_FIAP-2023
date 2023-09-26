package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantedRepository extends JpaRepository<Wanted, Integer> {

    @Query("SELECT p FROM Wanted p " +
            "WHERE LOWER(p.birthPlace) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.height) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.eye) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.weight) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.hair) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.languageId) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.nationalityId) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.description) LIKE LOWER(CONCAT('%', :partialAttributes, '%')) " +
            "   OR LOWER(p.race) LIKE LOWER(CONCAT('%', :partialAttributes, '%'))")
    List<Wanted> findByPartialAttributes(@Param("partialAttributes") String partialAttributes);
    List<Wanted> findByHeight(String height);

    List<Wanted> findByBirthPlace(String birthPlace);

    List<Wanted> findByRace(String race);

    List<Wanted> findByWeight(String weight);

    List<Wanted> findByEye(String eye);

    List<Wanted> findByHair(String hair);

    List<Wanted> findBySex(String sex);

    List<Wanted> findByCareful(String careful);
    List<Wanted> findByLanguageId(int languageId);

    List<Wanted> findByWarrantId(int warrantId);

    Wanted findByIdentityId(int identityId);

    List<Wanted> findByNationalityId(int nationalityId);

    List<Wanted> findByNickNameId(int nickNameId);

}