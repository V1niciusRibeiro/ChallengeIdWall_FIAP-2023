package br.com.fiap.ChallengeIdWall.Controller;

import br.com.fiap.ChallengeIdWall.Model.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Country")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping()
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

