package br.com.fiap.ChallengeIdWall.API_RestFull.Controller;

import br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity.Image;
import br.com.fiap.ChallengeIdWall.API_RestFull.Model.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/list")
    public List<Image> getAll(){
        return imageRepository.findAll();
    }
    @GetMapping("{id}")
    public Image getById(@PathVariable int id) {
        return imageRepository.findById(id).get();
    }
    @GetMapping("/wanted")
    public List<Image> getByWantedId(@RequestParam int wantedId) {
        return imageRepository.findByWantedId(wantedId);
    }
    @GetMapping("/big")
    public List<Image> getByBig(@RequestParam String big) {
        return imageRepository.findByBig(big);
    }
    @GetMapping("/small")
    public List<Image> getBySmall(@RequestParam String small) {
        return imageRepository.findBySmall(small);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Image image = getById(id);
        imageRepository.delete(image);
    }
}
