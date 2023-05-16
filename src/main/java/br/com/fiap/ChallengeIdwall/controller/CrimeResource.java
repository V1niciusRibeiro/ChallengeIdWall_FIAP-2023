package br.com.fiap.ChallengeIdwall.controller;

import br.com.fiap.ChallengeIdwall.model.Crime;
import br.com.fiap.ChallengeIdwall.model.Procurado;
import br.com.fiap.ChallengeIdwall.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crime")
public class CrimeResource {

    @Autowired
    private CrimeRepository crimeRepository;

    @GetMapping
    public List<Crime> listar(){
        return crimeRepository.findAll();
    }

    @GetMapping("{id}")
    public Crime buscarporchave(@PathVariable Integer id){
        return crimeRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Crime cadastrar(@RequestBody Crime crime){
        return crimeRepository.save(crime);
    }


    @PutMapping("{id}")
    public Crime atualiza(@RequestBody Crime crime, @PathVariable Integer id){
        crime.setId(id);
        return crimeRepository.save(crime);
    }

    @GetMapping("tipo")
    public List<Crime> buscaportipo(@RequestParam String tipo){
        return crimeRepository.findByTipo(tipo);
    }

    @GetMapping("descricao")
    public List<Crime> buscapordescricao(@RequestParam String descricao){
        return crimeRepository.findByDescricao(descricao);
    }

}
