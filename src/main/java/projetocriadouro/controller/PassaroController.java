package projetocriadouro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import projetocriadouro.model.Passaro;
import projetocriadouro.repository.PassaroRepository;
import projetocriadouro.service.JasperService;
import projetocriadouro.service.PassaroService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/administracao")
    public String paginaAdmin() {
        return "cadastro/administracao";
    }

    @GetMapping("/cadastroplantel")
    public String paginaCadastroPassaro() {
        return "cadastro/cadastroplantel";
    }

    @GetMapping("/consultasCruzas")
    public String paginaConsultaMacho() {
        return "cadastro/consultasCruzas";
    }

    @GetMapping("/consultasCruzasInicial")
    public String paginaConsultaMacho2() {
        return "cadastro/consultasCruzasInicial";
    }

    @GetMapping("/cadastrofilhote")
    public String paginaCadastroFilhote() {
        return "cadastro/cadastrofilhote";
    }

    @GetMapping("/exibirMachos")
    public String paginaExibirMachos() {
        return "cadastro/exibirMachos";
    }

    @GetMapping("/exibirFemeas")
    public String paginaExibirFemeas() {
        return "cadastro/exibirFemeas";
    }

    @GetMapping("/plantelGaladores")
    public String paginaExibirMachos2() {
        return "cadastro/plantelGaladores";
    }

    @GetMapping("/plantelMatrizes")
    public String paginaExibirFemeas2() {
        return "cadastro/plantelMatrizes";
    }

    @GetMapping("/exclusao")
    public String abrir() {
        return "cadastro/exclusao";
    }

    @GetMapping("/editarPassaro")
    public String editarPassaro() {
        return "cadastro/editarPassaro";
    }

    @GetMapping("/filhotesAVendaMachos")
    public String filhotesAVendaMachos() {
        return "cadastro/filhotesAVendaMachos";
    }

    @GetMapping("/filhotesAVendaFemeas")
    public String filhotesAVendaFemeas() {
        return "cadastro/filhotesAVendaFemeas";
    }

    @GetMapping("/filhotesAVendaMachosADM")
    public String filhotesAVendaMachosADM() {
        return "cadastro/filhotesAVendaMachosADM";
    }

    @GetMapping("/filhotesAVendaFemeasADM")
    public String filhotesAVendaFemeasADM() {
        return "cadastro/filhotesAVendaFemeasADM";
    }

    @ModelAttribute("todos")
    public List<Passaro> listarTodos() {
        return passaroRepository.findBySexo("Macho");
    }

    @ModelAttribute("todas")
    public List<Passaro> listarTodas() {
        return passaroRepository.findBySexo("Fêmea");
    }

    @PostMapping("/salvarpassaro")
    public String salvarPassaro(Passaro passaro) {
        passaroRepository.save(passaro);
        return "cadastro/cadastroplantel";
    }

    @PostMapping("/salvarpassarofilhote")
    public ModelAndView salvarPassaroFilhote(Passaro passaro, @RequestParam("pesGalador") String pesGalador,
                                             @RequestParam("pesMatriz") String pesMatriz, @RequestParam("nome") String nome,
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

    @PostMapping("/editarPassaros")
    public ModelAndView editarPassaro(Passaro passaro, @RequestParam("nomeEdicao") String nome,
                                      HttpServletResponse response, HttpServletRequest request) throws Exception {


        ModelAndView andView = new ModelAndView("cadastro/editarPassaro");
        andView.addObject("geralAves", geralAves());
        Passaro nomePassaro = passaroRepository.findByName(nome);
        andView.addObject("nomePassaro", nomePassaro);



        return andView;
    }

    @PostMapping("/verArvoreFilhote")
    public ModelAndView verArvoreFilhoteVenda(@RequestParam("anilhaFilhote") String anilhaFilhote,
                                              HttpServletResponse response, HttpServletRequest request) throws Exception {
        Passaro passaroArvoreFilhote = passaroRepository.findByAnilhaFilhoteVenda(anilhaFilhote);
        ModelAndView andView = new ModelAndView("cadastro/verArvore");
        andView.addObject("passaroArvoreFilhote", passaroArvoreFilhote);
        return andView;
    }

    @PostMapping("/verArvoreFilhoteF")
    public ModelAndView verArvoreFilhoteVendaF(@RequestParam("anilhaFilhote") String anilhaFilhote,
                                              HttpServletResponse response, HttpServletRequest request) throws Exception {
        Passaro passaroArvoreFilhote = passaroRepository.findByAnilhaFilhoteVenda(anilhaFilhote);
        ModelAndView andView = new ModelAndView("cadastro/verArvoreFemea");
        andView.addObject("passaroArvoreFilhote", passaroArvoreFilhote);
        return andView;
    }

    @PostMapping("/verArvoreFilhoteADM")
    public ModelAndView verArvoreFilhoteVendaADM(@RequestParam("anilhaFilhote") String anilhaFilhote,
                                              HttpServletResponse response, HttpServletRequest request) throws Exception {
        Passaro passaroArvoreFilhote = passaroRepository.findByAnilhaFilhoteVenda(anilhaFilhote);
        ModelAndView andView = new ModelAndView("cadastro/verArvoreADM");
        andView.addObject("passaroArvoreFilhote", passaroArvoreFilhote);
        return andView;
    }

    @PostMapping("/verArvoreFilhoteFADM")
    public ModelAndView verArvoreFilhoteVendaFADM(@RequestParam("anilhaFilhote") String anilhaFilhote,
                                               HttpServletResponse response, HttpServletRequest request) throws Exception {
        Passaro passaroArvoreFilhote = passaroRepository.findByAnilhaFilhoteVenda(anilhaFilhote);
        ModelAndView andView = new ModelAndView("cadastro/verArvoreFemeaADM");
        andView.addObject("passaroArvoreFilhote", passaroArvoreFilhote);
        return andView;
    }


    @ModelAttribute("filhotes")
    public List<Passaro> filhotes() {
        return passaroRepository.findByNameS();
    }

    @ModelAttribute("filhotesMachos")
    public List<Passaro> filhotesMachos(){
       return passaroRepository.findByVendaMacho();
    }

    @ModelAttribute("filhotesFemeas")
    public List<Passaro> filhotesFemeas() {
        return passaroRepository.findByVendaFemea();
    }

    @ModelAttribute("filhotesMachosADM")
    public List<Passaro> filhotesMachosADM(){
        return passaroRepository.findByVendaMachoADM();
    }

    @ModelAttribute("filhotesFemeasADM")
    public List<Passaro> filhotesFemeasADM() {
        return passaroRepository.findByVendaFemeaADM();
    }

    @ModelAttribute("plantel")
    public List<Passaro> plantel() {
        return passaroRepository.findByNamePlantel();
    }

    @ModelAttribute("geralAves")
    public List<Passaro> geralAves() {
        return passaroRepository.findTodos();
    }

}
