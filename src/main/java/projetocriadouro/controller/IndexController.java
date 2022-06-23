package projetocriadouro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/login"})
    public String login(){
        return "login";
    }

    @GetMapping({"/login-error"})
    public String loginError(ModelMap model){
        model.addAttribute("Alerta", "Erro");
        model.addAttribute("titulo", "Credenciais inválidas!");
        model.addAttribute("text", "Login ou senha incorretos, tente novamente");
        model.addAttribute("subtexto", "Acesso permitidos apenas para admin");
        return "login";
    }

}
