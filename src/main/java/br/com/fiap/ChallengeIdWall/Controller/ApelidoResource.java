package br.com.fiap.ChallengeIdWall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.ChallengeIdWall.Model.repository.ApelidoRepository;
import br.com.fiap.ChallengeIdWall.Model.entity.Apelido;

import java.util.List;

@RestController
@RequestMapping("nickname")
public class ApelidoResource {

    @Autowired
    private ApelidoRepository apelidoRepository;

    @GetMapping("nome/{name}")
    public List<Apelido> getByName(@PathVariable String name) {
        return apelidoRepository.findByName(name);
    }

    @GetMapping("{id}")
    public Apelido getById(@PathVariable int id) { return apelidoRepository.findById(id).get(); }

    @GetMapping()
    public List<Apelido> getAll() { return apelidoRepository.findAll(); }
    @GetMapping("wanted/{wantedId}")
    public List<Apelido> getByWantedId(@PathVariable int wantedId) {
        return apelidoRepository.findByWantedId(wantedId);
    }

    @GetMapping("wanted/{wantedId}/nickeName/{id}")
    public Apelido getByIdWantedId(@PathVariable int wantedId, @PathVariable int id) {
        return apelidoRepository.findByIdAndWantedId(id,wantedId);
    }
}
