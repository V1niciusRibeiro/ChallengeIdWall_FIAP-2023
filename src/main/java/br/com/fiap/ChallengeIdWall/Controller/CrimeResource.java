package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Crime;
import br.com.fiap.ChallengeIdWall.Model.repository.CrimeRepository;
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
    
    @GetMapping("type")
    public List<Crime> getByType(@RequestParam String type){
        return crimeRepository.findByTipo(type);
    }

    @GetMapping("description")
    public List<Crime> getByDescription(@RequestParam String description){
        return crimeRepository.findByDescricao(description);
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
