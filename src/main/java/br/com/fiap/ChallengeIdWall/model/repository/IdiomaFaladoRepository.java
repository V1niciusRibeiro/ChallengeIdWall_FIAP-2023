package br.com.fiap.ChallengeIdwall.Model.repository;

import br.com.fiap.ChallengeIdwall.Model.entity.Identidade;
import br.com.fiap.ChallengeIdwall.Model.entity.Idioma;
import br.com.fiap.ChallengeIdwall.Model.entity.IdiomaFalado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomaFaladoRepository extends JpaRepository<IdiomaFalado, Integer> {
    List<Identidade> findByIdioma(Idioma idioma);
    List<Identidade> findByProcuradoId(int id);
}
