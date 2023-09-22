package br.com.fiap.ChallengeIdWall.controller;

import br.com.fiap.ChallengeIdWall.model.Apelido;
import br.com.fiap.ChallengeIdWall.repository.ApelidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apelido")
public class ApelidoResource {

    @Autowired
    private ApelidoRepository apelidoRepository;

    @GetMapping("nome/{nome}")
    public List<Apelido> getByNome(@PathVariable String nome) {
        return apelidoRepository.findByNome(nome);
    }

    @GetMapping("procurado/{id}")
    public List<Apelido> getByProcuradoId(@PathVariable int id) {
        return apelidoRepository.findByProcuradoId(id);
    }

    @GetMapping("procurado/{idProcurado}/apelido/{idApelido]")
    public Apelido getById(@PathVariable int idProcurado, @PathVariable int idApelido) {
        return apelidoRepository.findById(idApelido,idProcurado);
    }

}
