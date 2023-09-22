package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.entity.Pais;
import br.com.fiap.ChallengeIdwall.Model.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pais")
public class PaisResource {

    @Autowired
    private PaisRepository paisRepository;


    @GetMapping
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    @GetMapping("nome/{nome}")
    public List<Pais> getPaisByNome(@PathVariable String nome) {
        return paisRepository.findByNome(nome);
    }

    @GetMapping("{id}")
    public Pais getPaisById(@PathVariable Integer id) {
        return paisRepository.findById(id).get();
    }

    @PostMapping
    public Pais createPais(@RequestBody Pais pais) {
        return paisRepository.save(pais);
    }

    @PutMapping("{id}")
    public Pais updatePais(@PathVariable Integer id, @RequestBody Pais pais) {
        pais.setId(id);
        return paisRepository.save(pais);
    }

    @DeleteMapping("{id}")
    public void deletePais(@PathVariable Integer id) {
        paisRepository.deleteById(id);
    }
}
