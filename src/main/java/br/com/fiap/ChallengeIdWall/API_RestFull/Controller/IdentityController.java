package br.com.fiap.ChallengeIdWall.API_RestFull.Controller;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.Identity;
import br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    @Autowired
    private IdentityRepository identityRepository;

    @GetMapping("/list")
    public List<Identity> getAll(){
        return identityRepository.findAll();
    }

    @GetMapping("{id}")
    public Identity getById(@PathVariable Integer id){
        return identityRepository.findById(id).get();
    }

    @GetMapping("/name")
    public List<Identity> getByName(@RequestParam String name){
        return identityRepository.findByName(name);
    }

    @GetMapping("/lastName")
    public List<Identity> getByNameAndLastName(@RequestParam String name, String lastName){
        return identityRepository.findByNameAndLastName(name, lastName);
    }
    @GetMapping("/partialNameOrLastName")
    public List<Identity> getByPartialNameOrLastName(@RequestParam String partialNameOrLastName) {
        return identityRepository.findByPartialNameOrLastName(partialNameOrLastName);
    }
    @GetMapping("/date")
    public List<Identity> getByDate(@RequestParam Calendar date){
        return identityRepository.findByBirthDate(date.getTime());
    }

    @GetMapping("/sex")
    public List<Identity> getBySex(@RequestParam String sex){
        return identityRepository.findBySex(sex);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Identity identidade = getById(id);
        identityRepository.delete(identidade);
    }

}



