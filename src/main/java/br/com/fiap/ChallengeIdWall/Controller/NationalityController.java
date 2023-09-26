package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Nationality;
import br.com.fiap.ChallengeIdWall.Model.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nationality")
public class NationalityController {

    @Autowired
    private NationalityRepository nationalityRepository;

    @GetMapping("/list")
    public List<Nationality> getByAll() {
        return nationalityRepository.findAll();
    }
    @GetMapping("{id}")
    public Nationality getById(@PathVariable int id) {
        return nationalityRepository.findById(id).get();
    }
    @GetMapping("/country")
    public List<Nationality> getByCountryId(@RequestParam int countryId) {
        return nationalityRepository.findByCountryId(countryId);
    }
    @GetMapping("/wanted")
    public List<Nationality> getByWantedId(@RequestParam int wantedId) {
        return nationalityRepository.findByWantedId(wantedId);
    }
}
