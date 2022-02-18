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
        return "/administracao";
    }

    @GetMapping("/liberarAcesso")
    public String liberarAcesso(String usuario, String senha){
//        Usuario usuarioRetorno = usuarioRepository.findNomeSenha(usuario, senha);
        if(usuario.equals("renan") && senha.equals("usina")){
            return "cadastro/administracao";
        }
        return "cadastro/login";
    }
}
