package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.entity.Crime;
import br.com.fiap.ChallengeIdwall.Model.entity.IdiomaFalado;
import br.com.fiap.ChallengeIdwall.Model.entity.Procurado;
import br.com.fiap.ChallengeIdwall.Model.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("procurado")
public class ProcuradoController {

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
    @GetMapping("/raca")
    public List<Procurado> getByRaca(@RequestParam String raca) {
        return procuradoRepository.findByRaca(raca);
    }
    @GetMapping("/peso")
    public List<Procurado> getByPeso(@RequestParam String peso) {
        return procuradoRepository.findByPeso(peso);
    }
    @GetMapping("/olho")
    public List<Procurado> getByOlho(@RequestParam String olho) {
        return procuradoRepository.findByOlho(olho);
    }
    @GetMapping("/altura")
    public List<Procurado> getByAltura(@RequestParam Double altura) {
        return procuradoRepository.findByAltura(altura);
    }
    @GetMapping("/cabelo")
    public List<Procurado> getByCabelo(@RequestParam String cabelo) {
        return procuradoRepository.findByCabelo(cabelo);
    }
    @GetMapping("/sexo")
    public List<Procurado> getBySexo(@RequestParam String sexo) {
        return procuradoRepository.findBySexo(sexo);
    }
    @GetMapping("/localNasc")
    public List<Procurado> getByLocalNascimento(@RequestParam String nasclocal) {
        return procuradoRepository.findByLocalNascimento(nasclocal);
    }
    @GetMapping("/cautela")
    public List<Procurado> getByCautela(@RequestParam String cautela) {
        return procuradoRepository.findByCautela(cautela);
    }
    @GetMapping("/idioma")
    public List<Procurado> getByIdioma(@RequestParam String nomeIdioma) {
        return procuradoRepository.findByIdiomaNome(nomeIdioma);
    }
    @GetMapping("/mandado")
    public List<Procurado> getByMandado(@RequestParam Crime tipoMandado) {
        return procuradoRepository.findByMandado(tipoMandado);
    }
    @GetMapping("/apelido")
    public List<Procurado> getByApelido(@RequestParam String apelido) {
        return procuradoRepository. findByApelido(apelido);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Procurado procurado = getById(id);
        procuradoRepository.delete(procurado);
    }

}