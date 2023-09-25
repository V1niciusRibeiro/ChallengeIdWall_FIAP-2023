package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProcuradoRepository  extends JpaRepository<Procurado, Integer> {

    @Query("SELECT p FROM Procurado p " +
            "WHERE LOWER(p.birthPlace) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.height) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.eye) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.weight) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.hair) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.languageId) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.nationalityId) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.description) LIKE LOWER(CONCAT('%', :stringDeBusca, '%')) " +
            "   OR LOWER(p.race) LIKE LOWER(CONCAT('%', :stringDeBusca, '%'))")
    List<Procurado> findByLike(@Param("stringDeBusca") String stringDeBusca);
    List<Procurado> findByHeight(String height);

    List<Procurado> findByBirthPlace(String birthPlace);

    List<Procurado> findByRace(String race);

    List<Procurado> findByWeight(String weight);

    List<Procurado> findByEye(String eye);

    List<Procurado> findByHair(String hair);

    List<Procurado> findBySex(String sex);

    List<Procurado> findByCareful(String careful);
    List<Procurado> findByLanguageId(int languageId);

    List<Procurado> findByWarrantId(int warrantId);

    Procurado findByIdentityId(int identityId);

    List<Procurado> findByNationalityId(int nationalityId);

    List<Procurado> findByNickNameId(int nickNameId);

}