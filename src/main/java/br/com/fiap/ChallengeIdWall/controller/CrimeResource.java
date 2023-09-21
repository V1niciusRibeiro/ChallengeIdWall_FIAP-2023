package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.entity.Crime;
import br.com.fiap.ChallengeIdwall.Model.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crime")
public class CrimeResource {

    @Autowired
    private CrimeRepository crimeRepository;

    @GetMapping
    public List<Crime> getAll(){
        return crimeRepository.findAll();
    }

    @GetMapping("{id}")
    public Crime getById(@PathVariable Integer id){
        return crimeRepository.findById(id).get();
    }
    
    @GetMapping("tipo")
    public List<Crime> getByTipo(@RequestParam String tipo){
        return crimeRepository.findByTipo(tipo);
    }

    @GetMapping("descricao")
    public List<Crime> getByDescricao(@RequestParam String descricao){
        return crimeRepository.findByDescricao(descricao);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Crime post(@RequestBody Crime crime){
        return crimeRepository.save(crime);
    }

    @PutMapping("{id}")
    public Crime put(@RequestBody Crime crime, @PathVariable Integer id){
        crime.setId(id);
        return crimeRepository.save(crime);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Crime crime = getById(id);
        crimeRepository.delete(crime);
    }
    
}
