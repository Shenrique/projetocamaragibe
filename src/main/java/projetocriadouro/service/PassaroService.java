package projetocriadouro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import projetocriadouro.model.Passaro;
import projetocriadouro.model.StatusReproducao;
import projetocriadouro.repository.PassaroRepository;

@Service
public class PassaroService {

    @Autowired
    private PassaroRepository passaroRepository;

    public ModelAndView salvar(Passaro passaro, String pesGalador, String pesMatriz, String nome) {
        Passaro passaroComboGalador = passaroRepository.findByName(pesGalador);
        Passaro passaroComboMatriz = passaroRepository.findByName(pesMatriz);
        passaro.setMacho1(passaroComboGalador.getNome());
        passaro.setFemea1(passaroComboMatriz.getNome());

        passaro.setMacho21(passaroComboGalador.getMacho1());
        passaro.setFemea21(passaroComboGalador.getFemea1());
        passaro.setMacho22(passaroComboMatriz.getMacho1());
        passaro.setFemea22(passaroComboMatriz.getFemea1());

        passaro.setMacho31(passaroComboGalador.getMacho21());
        passaro.setFemea31(passaroComboGalador.getFemea21());
        passaro.setMacho32(passaroComboGalador.getMacho22());
        passaro.setFemea32(passaroComboGalador.getFemea22());
        passaro.setMacho33(passaroComboMatriz.getMacho21());
        passaro.setFemea33(passaroComboMatriz.getFemea21());
        passaro.setMacho34(passaroComboMatriz.getMacho22());
        passaro.setFemea34(passaroComboMatriz.getFemea22());

        passaro.setMacho41(passaroComboGalador.getMacho31());
        passaro.setFemea41(passaroComboGalador.getFemea31());
        passaro.setMacho42(passaroComboGalador.getMacho32());
        passaro.setFemea42(passaroComboGalador.getFemea32());
        passaro.setMacho43(passaroComboGalador.getMacho33());
        passaro.setFemea43(passaroComboGalador.getFemea33());
        passaro.setMacho44(passaroComboGalador.getMacho34());
        passaro.setFemea44(passaroComboGalador.getFemea34());

        passaro.setMacho45(passaroComboMatriz.getMacho31());
        passaro.setFemea45(passaroComboMatriz.getFemea31());
        passaro.setMacho46(passaroComboMatriz.getMacho32());
        passaro.setFemea46(passaroComboMatriz.getFemea32());
        passaro.setMacho47(passaroComboMatriz.getMacho33());
        passaro.setFemea47(passaroComboMatriz.getFemea33());
        passaro.setMacho48(passaroComboMatriz.getMacho34());
        passaro.setFemea48(passaroComboMatriz.getFemea34());

        if(passaro.getStatus_reproducao() == null){
            passaro.setStatus_reproducao(StatusReproducao.N);
        }

        passaroRepository.save(passaro);

        ModelAndView andView = new ModelAndView("cadastro/cadastrofilhote");
        Passaro passaroFilhote = passaroRepository.findByName(nome);
        andView.addObject("passaroFilhote",passaroFilhote);
        return andView;
    }

}
