package br.com.fiap.ChallengeIdwall.Controller;

import br.com.fiap.ChallengeIdwall.Model.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping("/listar")
    public String listagemPaises(Model model) {
        model.addAttribute("paises", paisRepository.findAll());
        return "pais/ListagemPaises";
    }

    @GetMapping("/filtrar")
    public String filtragemPaises(@RequestParam("stringDeBusca") String stringDeBusca, Model model) {
        model.addAttribute("paises", paisRepository.findByName(stringDeBusca));
        return "pais/ListagemPaises";
    }
}

