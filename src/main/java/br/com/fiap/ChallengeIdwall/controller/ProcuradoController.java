package br.com.fiap.ChallengeIdWall.controller;

import br.com.fiap.ChallengeIdWall.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("procurado")
public class ProcuradoController {

    @Autowired
    private ProcuradoRepository repository;

    @GetMapping("listar")
    public String listagemProcurados(Model model) {
        model.addAttribute("procurados",repository.findAll());
        return "procurado/ListagemProcurados";
    }
    @GetMapping("filtrar")
    public String filtragemProcurados(@RequestParam("stringDeBusca") String stringDeBusca, Model model) {
        model.addAttribute("procurados",repository.findByAll(stringDeBusca));
        return "procurado/ListagemProcurados";
    }

}
