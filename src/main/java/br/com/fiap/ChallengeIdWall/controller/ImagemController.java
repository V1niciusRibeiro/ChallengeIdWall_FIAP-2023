package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.entity.Imagem;
import br.com.fiap.ChallengeIdwall.Model.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Imagem")
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
    @GetMapping("/procurado")
    public List<Imagem> getByProcurado(@RequestParam int idProcurado) {
        return imagemRepository.findByProcurado(idProcurado);
    }
    @GetMapping("/grande")
    public List<Imagem> getByGrande(@RequestParam String grande) {
        return imagemRepository.findByGrande(grande);
    }
    @GetMapping("/miniatura")
    public List<Imagem> getByMiniatura(@RequestParam String miniatura) {
        return imagemRepository.findByMiniatura(miniatura);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Imagem imagem = getById(id);
        imagemRepository.delete(imagem);
    }
}
