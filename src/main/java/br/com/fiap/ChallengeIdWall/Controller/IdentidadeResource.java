package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Identidade;
import br.com.fiap.ChallengeIdWall.Model.repository.IdentidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("registro")
public class IdentidadeResource {

    @Autowired
    private IdentidadeRepository identidadeRepository;

    @GetMapping
    public List<Identidade> getAll(){
        return identidadeRepository.findAll();
    }

    @GetMapping("{id}")
    public Identidade getById(@PathVariable Integer id){
        return identidadeRepository.findById(id).get();
    }

    @GetMapping("/nome")
    public List<Identidade> getByName(@RequestParam String name){
        return identidadeRepository.findByName(name);
    }

    @GetMapping("/lastName")
    public List<Identidade> getByNameAndLastName(@RequestParam String name, String lastName){
        return identidadeRepository.findByNameAndLastName(name, lastName);
    }

    @GetMapping("/date")
    public List<Identidade> getByDate(@RequestParam Calendar date){
        return identidadeRepository.findByBirthDate(date.getTime());
    }

    @GetMapping("/sex")
    public List<Identidade> getBySex(@RequestParam String sex){
        return identidadeRepository.findBySex(sex);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Identidade post(@RequestBody Identidade identity){
        return identidadeRepository.save(identity);
    }

    @PutMapping("{id}")
    public Identidade put(@RequestBody Identidade identity, @PathVariable Integer id){
        identity.setId(id);
        return identidadeRepository.save(identity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Identidade identidade = getById(id);
        identidadeRepository.delete(identidade);
    }

}



