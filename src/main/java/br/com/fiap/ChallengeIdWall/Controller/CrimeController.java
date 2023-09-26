package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Crime;
import br.com.fiap.ChallengeIdWall.Model.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crime")
public class CrimeController {

    @Autowired
    private CrimeRepository crimeRepository;

    @GetMapping("/list")
    public List<Crime> getAll(){
        return crimeRepository.findAll();
    }

    @GetMapping("{id}")
    public Crime getById(@PathVariable Integer id){
        return crimeRepository.findById(id).get();
    }
    
    @GetMapping("/type")
    public List<Crime> getByType(@RequestParam String type){
        return crimeRepository.findByType(type);
    }

    @GetMapping("/description")
    public List<Crime> getByDescription(@RequestParam String description) {
        return crimeRepository.findByDescription(description);
    }
    @GetMapping("/country")
    public List<Crime> getByCountryId(@RequestParam int countryId) {
        return crimeRepository.findByCountryId(countryId);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Crime crime = getById(id);
        crimeRepository.delete(crime);
    }
}
