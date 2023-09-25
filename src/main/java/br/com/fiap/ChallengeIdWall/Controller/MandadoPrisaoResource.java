package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.MandadoPrisao;
import br.com.fiap.ChallengeIdWall.Model.repository.MandadoPrisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warrant")
public class MandadoPrisaoResource {

    @Autowired
    private MandadoPrisaoRepository mandadoPrisaoRepository;

    @GetMapping("/country/{countryId}")
    public List<MandadoPrisao> getByCountry(@PathVariable Integer countryId){
        return mandadoPrisaoRepository.findByCountryId(countryId);
    }

    @GetMapping("/wanted/{wantedId}")
    public List<MandadoPrisao> getByWanted(@RequestParam int wantedId){
        return mandadoPrisaoRepository.findByWantedId(wantedId);
    }

    @GetMapping("/wanted/{id}/warrant/{wantedId}")
    public MandadoPrisao getByWantedIdAndWarrantId(@RequestParam int id, @PathVariable int wantedId){
        return mandadoPrisaoRepository.findByIdAndWantedId(id, wantedId);
    }

}
