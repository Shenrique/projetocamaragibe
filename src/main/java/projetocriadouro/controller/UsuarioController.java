package projetocriadouro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @GetMapping("/login")
    public String paginaCadastroPassaro(){
        return "cadastro/login";
    }

    @GetMapping("/administracao")
    public String paginaAdmin(){
        return "cadastro/administracao";
    }

    @GetMapping("/liberarAcesso")
    public String liberarAcesso(String usuario, String senha){
        if(usuario.equals("renan") && senha.equals("camaro")){
            return "cadastro/administracao";
        }
        return "cadastro/login";
    }
}
