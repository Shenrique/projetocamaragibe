package projetocriadouro.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projetocriadouro.model.Passaro;
import projetocriadouro.model.StatusReproducao;
import projetocriadouro.repository.PassaroRepository;
import projetocriadouro.service.JasperService;
import projetocriadouro.service.PassaroService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@Controller
public class PassaroController {

    @Autowired
    private Connection connection;

    @Autowired
    private JasperService service;

    @Autowired
    private PassaroService passaroService;

    @Autowired
    private PassaroRepository passaroRepository;

    @GetMapping("/cadastroplantel")
    public String paginaCadastroPassaro(){
        return "cadastro/cadastroplantel";
    }

    @GetMapping("/consultasCruzas")
    public String paginaConsultaMacho(){
        return "cadastro/consultasCruzas";
    }

    @GetMapping("/cadastrofilhote")
    public String paginaCadastroFilhote(){
        return "cadastro/cadastrofilhote";
    }

    @GetMapping("/exibirMachos")
    public String paginaExibirMachos(){
        return "cadastro/exibirMachos";
    }

    @GetMapping("/exibirFemeas")
    public String paginaExibirFemeas(){
        return "cadastro/exibirFemeas";
    }

    @ModelAttribute("todos")
    public List<Passaro> listarTodos(){
        return passaroRepository.findBySexo("Macho");
    }

    @ModelAttribute("todas")
    public List<Passaro> listarTodas(){
        return passaroRepository.findBySexo("Femea");
    }

    @PostMapping("/salvarpassaro")
    public String salvarPassaro(Passaro passaro){
        passaroRepository.save(passaro);
        return "cadastro/cadastroplantel";
    }

    @PostMapping("/salvarpassarofilhote")
    public ModelAndView salvarPassaroFilhote(Passaro passaro,@RequestParam("pesGalador") String pesGalador,
                                             @RequestParam("pesMatriz") String pesMatriz,@RequestParam("nome") String nome,
                                             HttpServletResponse response, HttpServletRequest request) throws Exception {

        ModelAndView passaroSalvo = passaroService.salvar(passaro, pesGalador, pesMatriz, nome);
        return passaroSalvo;
    }

    @PostMapping("/pesquisarpassaro")
    public ModelAndView retornoComboMacho(@RequestParam("pesGalador") String pesGalador, @RequestParam("pesMatriz") String pesMatriz) {
        ModelAndView andView = new ModelAndView("cadastro/consultasCruzas");
        Passaro passaroComboGalador = passaroRepository.findByName(pesGalador);
        Passaro passaroComboMatriz = passaroRepository.findByName(pesMatriz);
        andView.addObject("passaroComboGalador", passaroComboGalador);
        andView.addObject("passaroComboMatriz", passaroComboMatriz);
        return andView;
    }


}
