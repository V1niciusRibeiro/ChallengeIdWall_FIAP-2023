package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.entity.Identidade;
import br.com.fiap.ChallengeIdwall.Model.repository.IdentidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("registro")
public class IdentidadeResource {

    @Autowired
    private IdentidadeRepository identidadeRepository;

    @GetMapping
    public List<Identidade> getAll(){
        return identidadeRepository.findAll();
    }

    @GetMapping("{id}")
    public Identidade getById(@PathVariable Integer id){
        return identidadeRepository.findById(id).get();
    }

    @GetMapping("nome")
    public List<Identidade> buscapornome(@RequestParam String nome){
        return identidadeRepository.findByNome(nome);
    }

    @GetMapping("sobrenome")
    public List<Identidade> buscaporsobrenome(@RequestParam String sobrenome){
        return identidadeRepository.findBySobrenome(sobrenome);
    }

    @GetMapping("data")
    public List<Identidade> buscapordata(@RequestParam Calendar data){
        return identidadeRepository.findByDtNasc(data);
    }

    @GetMapping("sexo")
    public List<Identidade> buscaporsexo(@RequestParam String sexo){
        return identidadeRepository.findBySexo(sexo);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Identidade cadastrar(@RequestBody Identidade identidade){
        return identidadeRepository.save(identidade);
    }

    @PutMapping("{id}")
    public Identidade atualiza(@RequestBody Identidade identidade, @PathVariable Integer id){
        identidade.setId(id);
        return identidadeRepository.save(identidade);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        Identidade identidade = getById(id);
        identidadeRepository.delete(identidade);
    }

}



