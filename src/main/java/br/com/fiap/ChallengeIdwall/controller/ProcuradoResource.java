package br.com.fiap.ChallengeIdwall.controller;

import br.com.fiap.ChallengeIdwall.model.Procurado;
import br.com.fiap.ChallengeIdwall.model.Registro;
import br.com.fiap.ChallengeIdwall.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
@RestController
@RequestMapping("procurado")
public class ProcuradoResource {

    @Autowired
    private ProcuradoRepository procuradoRepository;

    @GetMapping
    public List<Procurado> listar(){
        return procuradoRepository.findAll();
    }

    @GetMapping("{id}")
    public Procurado buscarporchave(@PathVariable Integer id){
        return procuradoRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Procurado cadastrar(@RequestBody Procurado procurado){
        return procuradoRepository.save(procurado);
    }


    @PutMapping("{id}")
    public Procurado atualiza(@RequestBody Procurado procurado, @PathVariable Integer id){
        procurado.setId(id);
        return procuradoRepository.save(procurado);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        Procurado procurado = buscarporchave(id);
        procuradoRepository.delete(procurado);
    }

    @GetMapping("altura")
    public List<Procurado> buscaporaltura(@RequestParam Double altura){
        return procuradoRepository.findByAltura(altura);
    }

    @GetMapping("nasclocal")
    public List<Procurado> buscaporaltura(@RequestParam String nasclocal){
        return procuradoRepository.findByNasclocal(nasclocal);
    }
}
