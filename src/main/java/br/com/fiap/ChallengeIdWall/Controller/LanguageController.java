package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Language;
import br.com.fiap.ChallengeIdWall.Model.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("/list")
    public List<Language> getByAll() {
        return languageRepository.findAll();
    }
    @GetMapping("{id}")
    public Language getById(@PathVariable int id) {
        return languageRepository.findById(id).get();
    }
    @GetMapping("/search")
    public List<Language> getByPartialName(@RequestParam String partialName) {
        return languageRepository.findByPartialNome(partialName);
    }
    @GetMapping("/name")
    public List<Language> getByName(@RequestParam String name) {
        return languageRepository.findByName(name);
    }
    @GetMapping("/spoken-language")
    public List<Language> getBySpokenLanguageId(@RequestParam int spokenLanguageId) {
        return  languageRepository.findBySpokenLanguageId(spokenLanguageId);
    }
}
