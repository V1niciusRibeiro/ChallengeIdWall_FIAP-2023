package br.com.fiap.ChallengeIdWall.controller;

import br.com.fiap.ChallengeIdWall.model.Registro;
import br.com.fiap.ChallengeIdWall.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("registro")
public class RegistroResource {

    @Autowired
    private RegistroRepository registroRepository;

    @GetMapping
    public List<Registro> getAll(){
        return registroRepository.findAll();
    }

    @GetMapping("{id}")
    public Registro getById(@PathVariable Integer id){
        return registroRepository.findById(id).get();
    }

    @GetMapping("nome")
    public List<Registro> buscapornome(@RequestParam String nome){
        return registroRepository.findByNome(nome);
    }

    @GetMapping("sobrenome")
    public List<Registro> buscaporsobrenome(@RequestParam String sobrenome){
        return registroRepository.findBySobrenome(sobrenome);
    }

    @GetMapping("data")
    public List<Registro> buscapordata(@RequestParam Calendar data){
        return registroRepository.findByDtNasc(data);
    }

    @GetMapping("sexo")
    public List<Registro> buscaporsexo(@RequestParam String sexo){
        return registroRepository.findBySexo(sexo);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Registro cadastrar(@RequestBody Registro registro){
        return registroRepository.save(registro);
    }

    @PutMapping("{id}")
    public Registro atualiza(@RequestBody Registro registro, @PathVariable Integer id){
        registro.setId(id);
        return registroRepository.save(registro);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        Registro registro = getById(id);
        registroRepository.delete(registro);
    }

}



