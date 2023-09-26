package br.com.fiap.ChallengeIdWall.Model.repository;

import br.com.fiap.ChallengeIdWall.Model.entity.NickName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NickNameRepository extends JpaRepository<NickName, Integer> {
    List<NickName> findByName(String name);
    List<NickName> findByWantedId(int wantedId);
    NickName findByIdAndWantedId(int id, int wantedId);
}
