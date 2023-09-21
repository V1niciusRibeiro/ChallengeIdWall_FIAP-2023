package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.entity.Procurado;
import br.com.fiap.ChallengeIdwall.Model.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("procurado")
public class ProcuradoResource {

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

    @GetMapping("altura")
    public List<Procurado> getByAltura(@RequestParam Double altura){
        return procuradoRepository.findByAltura(altura);
    }

    @GetMapping("nasclocal")
    public List<Procurado> getByLocalNascimento(@RequestParam String nasclocal){
        return procuradoRepository.findByLocalNascimento(nasclocal);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Procurado procurado = getById(id);
        procuradoRepository.delete(procurado);
    }

}