package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.ChallengeIdWall.Model.repository.ProcuradoRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("procurado")
public class ProcuradoController {

    @Autowired
    private ProcuradoRepository procuradoRepository;

    @GetMapping
    public List<Procurado> getAll(){
        return procuradoRepository.findAll();
    }
    @GetMapping("{id}")
    public Procurado getById(@PathVariable Integer id){

        return procuradoRepository.findById(id).get();
    }
    @GetMapping("/race")
    public List<Procurado> getByRaca(@RequestParam String race) {

        return procuradoRepository.findByRace(race);
    }
    @GetMapping("/weight")
    public List<Procurado> getByWeight(@RequestParam String weight) {

        return procuradoRepository.findByWeight(weight);
    }
    @GetMapping("/eye")
    public List<Procurado> getByEye(@RequestParam String eye) {
        return procuradoRepository.findByEye(eye);
    }
    @GetMapping("/height")
    public List<Procurado> getByHeight(@RequestParam String height) {

        return procuradoRepository.findByHeight(height);
    }
    @GetMapping("/hair")
    public List<Procurado> getByHair(@RequestParam String hair) {

        return procuradoRepository.findByHair(hair);
    }
    @GetMapping("/sex")
    public List<Procurado> getBySex(@RequestParam String sex) {

        return procuradoRepository.findBySex(sex);
    }
    @GetMapping("/birthPlace")
    public List<Procurado> getByLocalNascimento(@RequestParam String birthPlace) {
        return procuradoRepository.findByBirthPlace(birthPlace);
    }
    @GetMapping("/careful")
    public List<Procurado> getByCautela(@RequestParam String careful) {
        return procuradoRepository.findByCareful(careful);
    }

    @GetMapping("/spokenLanguage")
    public List<Procurado> getByLanguage(@RequestParam int spokenLanguage) {
        return procuradoRepository.findByLanguageIdIn(spokenLanguage);
    }

    @GetMapping("/warrant")
    public List<Procurado> getByWarrant(@RequestParam int warrantId) {
        return procuradoRepository.findByWarrantIdIn(warrantId);
    }
    @GetMapping("/nickName")
    public List<Procurado> getByNickName(@RequestParam int nickName) {
        return procuradoRepository.findByNickNameIdIn(nickName);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Procurado procurado = getById(id);
        procuradoRepository.delete(procurado);
    }

}