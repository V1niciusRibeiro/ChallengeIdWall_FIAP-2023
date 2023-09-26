package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Warrant;
import br.com.fiap.ChallengeIdWall.Model.repository.WarrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warrant")
public class WarrantController {

    @Autowired
    private WarrantRepository warrantRepository;

    @GetMapping("/country/{countryId}")
    public List<Warrant> getByCountry(@PathVariable Integer countryId){
        return warrantRepository.findByCountryId(countryId);
    }

    @GetMapping("/wanted/{wantedId}")
    public List<Warrant> getByWanted(@RequestParam int wantedId){
        return warrantRepository.findByWantedId(wantedId);
    }

    @GetMapping("/wanted/{id}/warrant/{wantedId}")
    public Warrant getByWantedIdAndWarrantId(@RequestParam int id, @PathVariable int wantedId){
        return warrantRepository.findByIdAndWantedId(id, wantedId);
    }

}
