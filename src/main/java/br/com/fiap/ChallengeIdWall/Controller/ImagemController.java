package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.entity.Imagem;
import br.com.fiap.ChallengeIdWall.Model.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Image")
public class ImagemController {

    @Autowired
    private ImagemRepository imagemRepository;

    @GetMapping
    public List<Imagem> getAll(){
        return imagemRepository.findAll();
    }
    @GetMapping("{id}")
    public Imagem getById(@PathVariable int id) {
        return imagemRepository.findById(id).get();
    }
    @GetMapping("/wanted")
    public List<Imagem> getByWantedId(@RequestParam int wantedId) {
        return imagemRepository.findByWantedId(wantedId);
    }
    @GetMapping("/big")
    public List<Imagem> getByBig(@RequestParam String big) {
        return imagemRepository.findByBig(big);
    }
    @GetMapping("/small")
    public List<Imagem> getBySmall(@RequestParam String small) {
        return imagemRepository.findBySmall(small);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Imagem image = getById(id);
        imagemRepository.delete(image);
    }
}
