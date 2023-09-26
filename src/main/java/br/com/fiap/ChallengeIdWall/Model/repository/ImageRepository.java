package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByWantedId(int wantedId);
    List<Image> findByBig(String big);
    List<Image> findBySmall(String small);

}
