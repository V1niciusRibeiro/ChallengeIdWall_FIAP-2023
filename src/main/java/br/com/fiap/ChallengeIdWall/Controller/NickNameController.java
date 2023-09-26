package br.com.fiap.ChallengeIdWall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.ChallengeIdWall.Model.repository.NickNameRepository;
import br.com.fiap.ChallengeIdWall.Model.entity.NickName;

import java.util.List;

@RestController
@RequestMapping("/nickname")
public class NickNameController {

    @Autowired
    private NickNameRepository nickNameRepository;

    @GetMapping("/name/{name}")
    public List<NickName> getByName(@PathVariable String name) {
        return nickNameRepository.findByName(name);
    }

    @GetMapping("{id}")
    public NickName getById(@PathVariable int id) { return nickNameRepository.findById(id).get(); }

    @GetMapping()
    public List<NickName> getAll() { return nickNameRepository.findAll(); }
    @GetMapping("/wanted/{wantedId}")
    public List<NickName> getByWantedId(@PathVariable int wantedId) {
        return nickNameRepository.findByWantedId(wantedId);
    }
    @GetMapping("/wanted/{wantedId}/nickeName/{id}")
    public NickName getByIdWantedId(@PathVariable int wantedId, @PathVariable int id) {
        return nickNameRepository.findByIdAndWantedId(id,wantedId);
    }
}
