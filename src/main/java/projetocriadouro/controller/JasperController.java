package projetocriadouro.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import projetocriadouro.model.Passaro;
import projetocriadouro.repository.PassaroRepository;
import projetocriadouro.service.JasperService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class JasperController {

    @Autowired
    private JasperService service;

    @Autowired
    private PassaroRepository passaroRepository;

    @GetMapping("/reports")
    public String abrir(){
        return "cadastro/reports";
    }


    @GetMapping("/relatorioGalador")
    public void exibirRelatorioGalador(@RequestParam(name="nomeGalador", required = false) String nome,
                                  HttpServletResponse response) throws JRException, IOException {

        service.adicionandoParamentro("galador", nome);

        byte[] bytes = service.exportarRelatorioPDFGalador();
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename="+ nome +".pdf");
        response.getOutputStream().write(bytes);
    }

    @GetMapping("/relatorioGeral")
    public void exibirRelatorioGeral(HttpServletResponse response) throws JRException, IOException {

        byte[] bytes = service.exportarRelatorioPDF();
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename=relatorioGeral.pdf");
        response.getOutputStream().write(bytes);

    }

    @GetMapping("/certificado")
    public void exibirRelatorio09(@RequestParam(name="nomeCertificado", required = false) String nome,
                                  HttpServletResponse response) throws JRException, IOException {

        service.adicionandoParamentro("nome", nome);

        byte[] bytes = service.exportarCertificadoPDF();
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename="+ nome +".pdf");
        response.getOutputStream().write(bytes);

    }

    @GetMapping("/placaIntervalo")
    public void placaIntervalo(@RequestParam(name="dataInicial", required = false) Date dataInicial, @RequestParam(name="dataFinal",  required = false) Date dataFinal,
                                  HttpServletResponse response) throws JRException, IOException, ParseException {


//        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
//        String dataIni = formatador.format(dataInicial);
//        String dataFin = formatador.format(dataFinal);
//
//        Date dataIncial1 = formatador.parse(dataIni);
//        Date dataFinal1 = formatador.parse(dataFin);

        service.adicionandoParamentro("dataInicial", dataInicial);
        service.adicionandoParamentro("dataFinal", dataFinal);

        byte[] bytes = service.exportarPlacasPDF();
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename=placa.pdf");
        response.getOutputStream().write(bytes);

    }

    @GetMapping("/certificadoplantel")
    public void exibirRelatorioPlantel(@RequestParam(name="plantelCertificado", required = false) String nome,
                                  HttpServletResponse response) throws JRException, IOException {

        service.adicionandoParamentro("nome", nome);

        byte[] bytes = service.exportarCertificadoPDF();
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename="+ nome +".pdf");
        response.getOutputStream().write(bytes);

    }

    @ModelAttribute("filhotes")
        public List<Passaro> filhotes( ){
            return passaroRepository.findByNameS();
        }

    @ModelAttribute("plantel")
    public List<Passaro> plantel( ){
        return passaroRepository.findByNamePlantel();
    }

    @ModelAttribute("galador")
    public List<Passaro> galador(){
        return passaroRepository.findByGalador();
    }

}
