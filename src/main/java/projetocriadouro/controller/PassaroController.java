package projetocriadouro.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/administracao")
    public String paginaAdmin(){
        return "cadastro/administracao";
    }

    @GetMapping("/cadastroplantel")
    public String paginaCadastroPassaro(){
        return "cadastro/cadastroplantel";
    }

    @GetMapping("/consultasCruzas")
    public String paginaConsultaMacho(){
        return "cadastro/consultasCruzas";
    }

    @GetMapping("/consultasCruzasInicial")
    public String paginaConsultaMacho2(){
        return "cadastro/consultasCruzasInicial";
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

    @GetMapping("/exibirMachosInicial")
    public String paginaExibirMachos2(){
        return "cadastro/exibirMachosInicial";
    }

    @GetMapping("/exibirFemeasInicial")
    public String paginaExibirFemeas2(){
        return "cadastro/exibirFemeasInicial";
    }

    @GetMapping("/exclusao")
    public String abrir(){
        return "cadastro/exclusao";
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

    @GetMapping("/excluirPassaroFilhote")
    public ModelAndView excluirPassaroFilhote(@RequestParam("nomeFilhote") String nome,
                                       HttpServletResponse response, HttpServletRequest request) throws Exception {

        Passaro nomePassaro = passaroRepository.findByName(nome);
        Long codigo = nomePassaro.getCodigo();
        passaroRepository.deleteById(codigo);
        ModelAndView andView = new ModelAndView("cadastro/exclusao");
        andView.addObject("filhotes", filhotes());
        andView.addObject("plantel", plantel());
        return andView;
    }

    @GetMapping("/excluirPassaroPlantel")
    public ModelAndView excluirPassaroPlantel(@RequestParam("nomePassaro") String nome,
                                              HttpServletResponse response, HttpServletRequest request) throws Exception {

        Passaro nomePassaro = passaroRepository.findByName(nome);
        Long codigo = nomePassaro.getCodigo();
        passaroRepository.deleteById(codigo);
        ModelAndView andView = new ModelAndView("cadastro/exclusao");
        andView.addObject("filhotes", filhotes());
        andView.addObject("plantel", plantel());
        return andView;
    }



    @PostMapping("/pesquisarpassaro")
    public ModelAndView retornoCombos(@RequestParam("pesGalador") String pesGalador, @RequestParam("pesMatriz") String pesMatriz) {
        ModelAndView andView = new ModelAndView("cadastro/consultasCruzas");
        Passaro passaroComboGalador = passaroRepository.findByName(pesGalador);
        Passaro passaroComboMatriz = passaroRepository.findByName(pesMatriz);
        andView.addObject("passaroComboGalador", passaroComboGalador);
        andView.addObject("passaroComboMatriz", passaroComboMatriz);
        return andView;
    }

    @PostMapping("/pesquisarpassaroInicial")
    public ModelAndView retornoCombosInicial(@RequestParam("pesGalador") String pesGalador, @RequestParam("pesMatriz") String pesMatriz) {
        ModelAndView andView = new ModelAndView("cadastro/consultasCruzasInicial");
        Passaro passaroComboGalador = passaroRepository.findByName(pesGalador);
        Passaro passaroComboMatriz = passaroRepository.findByName(pesMatriz);
        andView.addObject("passaroComboGalador", passaroComboGalador);
        andView.addObject("passaroComboMatriz", passaroComboMatriz);
        return andView;
    }

    @ModelAttribute("filhotes")
    public List<Passaro> filhotes( ){
        return passaroRepository.findByNameS();
    }

    @ModelAttribute("plantel")
    public List<Passaro> plantel( ){
        return passaroRepository.findByNamePlantel();
    }


}
