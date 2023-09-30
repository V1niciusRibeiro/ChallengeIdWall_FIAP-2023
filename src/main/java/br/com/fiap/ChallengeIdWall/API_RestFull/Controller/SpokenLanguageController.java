package br.com.fiap.ChallengeIdWall.API_RestFull.Controller;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.SpokenLanguage;
import br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository.SpokenLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spoken-language")
public class SpokenLanguageController {

    @Autowired
    private SpokenLanguageRepository spokenLanguageRepository;

    @GetMapping("/list")
    public List<SpokenLanguage> getByAll() {
        return spokenLanguageRepository.findAll();
    }
    @GetMapping("{id}")
    public SpokenLanguage getById(@RequestParam int id) {
        return spokenLanguageRepository.findById(id).get();
    }
    @GetMapping("/language")
    public List<SpokenLanguage> getByLanguage(@RequestParam int languageId) {
        return spokenLanguageRepository.findByLanguageId(languageId);
    }
    @GetMapping("/wanted")
    public List<SpokenLanguage> getByWanted(@RequestParam int wantedId) {
        return spokenLanguageRepository.findByWantedId(wantedId);
    }
}
