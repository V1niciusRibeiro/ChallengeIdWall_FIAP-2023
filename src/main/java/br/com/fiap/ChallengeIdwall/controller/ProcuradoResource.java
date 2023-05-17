package br.com.fiap.ChallengeIdWall.controller;

import br.com.fiap.ChallengeIdWall.model.Procurado;
import br.com.fiap.ChallengeIdWall.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Procurado post(@RequestBody Procurado procurado){
        return procuradoRepository.save(procurado);
    }

    @PutMapping("{id}")
    public Procurado put(@RequestBody Procurado procurado, @PathVariable Integer id){
        procurado.setId(id);
        return procuradoRepository.save(procurado);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Procurado procurado = getById(id);
        procuradoRepository.delete(procurado);
    }

}