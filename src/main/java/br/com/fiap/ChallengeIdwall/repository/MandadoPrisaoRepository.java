package br.com.fiap.ChallengeIdWall.repository;

import br.com.fiap.ChallengeIdWall.model.MandadoPrisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MandadoPrisaoRepository extends JpaRepository<MandadoPrisaoRepository, Integer> {

    List<MandadoPrisao> findByPais(int idPais);
    List<MandadoPrisao> findByProcurado(int idProcurado);
    MandadoPrisao findById(int idMandado, int idProcurado);
}