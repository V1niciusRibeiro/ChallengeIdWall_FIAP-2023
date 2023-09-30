package br.com.fiap.ChallengeIdWall.API_RestFull.Controller;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.Country;
import br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/list")
    public List<Country> getAll() {
       return countryRepository.findAll();
    }
    @GetMapping("{id}")
    public Country getById(@PathVariable int id) {
        return countryRepository.findById(id).get();
    }
    @GetMapping("/name")
    public List<Country> getByName(@RequestParam String name) {
        return countryRepository.findByName(name);
    }

}

