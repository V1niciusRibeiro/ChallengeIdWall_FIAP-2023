package br.com.fiap.ChallengeIdWall.controller;

import br.com.fiap.ChallengeIdWall.model.MandadoPrisao;
import br.com.fiap.ChallengeIdWall.repository.MandadoPrisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mandadoPrisaoResource")
public class MandadoPrisaoResource {

    @Autowired
    private MandadoPrisaoRepository mandadoPrisaoRepository;

    @GetMapping("pais/{idPais}")
    public List<MandadoPrisao> getById(@PathVariable Integer idPais){
        return mandadoPrisaoRepository.findByPais(idPais);
    }

    @GetMapping("procurado/{idProcurado}")
    public List<MandadoPrisao> getByTipo(@RequestParam int idProcurado){
        return mandadoPrisaoRepository.findByProcurado(idProcurado);
    }

    @GetMapping("procurado/{idProcurado}/mandado/{idMandado}")
    public MandadoPrisao getByTipo(@RequestParam int idProcurado, @PathVariable int idMandado){
        return mandadoPrisaoRepository.findById(idMandado,idProcurado);
    }

}
