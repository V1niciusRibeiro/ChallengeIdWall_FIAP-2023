package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.ChallengeIdWall.Model.repository.WantedRepository;

import java.util.List;

@RestController
@RequestMapping("/wanted")
public class WantedController {

    @Autowired
    private WantedRepository wantedRepository;

    @GetMapping
    public List<Wanted> getAll(){
        return wantedRepository.findAll();
    }
    @GetMapping("{id}")
    public Wanted getById(@PathVariable Integer id){
        return wantedRepository.findById(id).get();
    }

    @GetMapping("/identity")
    public Wanted getByIndentityId(@RequestParam int identityId) {
        return wantedRepository.findByIdentityId(identityId);
    }
    @GetMapping("/nationality")
    public List<Wanted> getByNationalityId(@RequestParam int nationalityId) {
        return wantedRepository.findByNationalityId(nationalityId);
    }
    @GetMapping("/race")
    public List<Wanted> getByRaca(@RequestParam String race) {

        return wantedRepository.findByRace(race);
    }
    @GetMapping("/weight")
    public List<Wanted> getByWeight(@RequestParam String weight) {

        return wantedRepository.findByWeight(weight);
    }
    @GetMapping("/eye")
    public List<Wanted> getByEye(@RequestParam String eye) {
        return wantedRepository.findByEye(eye);
    }
    @GetMapping("/height")
    public List<Wanted> getByHeight(@RequestParam String height) {

        return wantedRepository.findByHeight(height);
    }
    @GetMapping("/hair")
    public List<Wanted> getByHair(@RequestParam String hair) {

        return wantedRepository.findByHair(hair);
    }
    @GetMapping("/sex")
    public List<Wanted> getBySex(@RequestParam String sex) {

        return wantedRepository.findBySex(sex);
    }
    @GetMapping("/birthPlace")
    public List<Wanted> getByLocalNascimento(@RequestParam String birthPlace) {
        return wantedRepository.findByBirthPlace(birthPlace);
    }
    @GetMapping("/careful")
    public List<Wanted> getByCautela(@RequestParam String careful) {
        return wantedRepository.findByCareful(careful);
    }

    @GetMapping("/spokenLanguage")
    public List<Wanted> getByLanguage(@RequestParam int spokenLanguage) {
        return wantedRepository.findByLanguageId(spokenLanguage);
    }

    @GetMapping("/warrant")
    public List<Wanted> getByWarrant(@RequestParam int warrantId) {
        return wantedRepository.findByWarrantId(warrantId);
    }
    @GetMapping("/nickName")
    public List<Wanted> getByNickName(@RequestParam int nickName) {
        return wantedRepository.findByNickNameId(nickName);
    }

    @GetMapping("/partialAttributes")
    public List<Wanted> getByPartialAttributes(@RequestParam String findByPartialAttributes) {
        return wantedRepository.findByPartialAttributes(findByPartialAttributes);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Wanted procurado = getById(id);
        wantedRepository.delete(procurado);
    }

}