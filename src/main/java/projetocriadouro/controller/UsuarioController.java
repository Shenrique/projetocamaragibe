package projetocriadouro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projetocriadouro.model.Usuario;
import projetocriadouro.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String paginaCadastroPassaro(){
        return "cadastro/login";
    }

    @GetMapping("/administracao")
    public String paginaAdmin(){
        return "cadastro/administracao";
    }

    @GetMapping("/liberarAcesso")
    public String liberarAcesso( @RequestParam("nome") String nome, @RequestParam("senha") String senha){
        Usuario usuarioRetornado = usuarioRepository.findNomeSenha(nome, senha);

        if(usuarioRetornado != null && !usuarioRetornado.equals("")){
            return "cadastro/administracao";
        }
        return "cadastro/login";
    }
}
