package br.com.propeest.armariosifsp.controllers;

import br.com.propeest.armariosifsp.dto.RequisicaoNovoAluno;
import br.com.propeest.armariosifsp.models.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("aluno", new Aluno());
        mv.setViewName("alunos/login");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("requisicaoNovoAluno", new RequisicaoNovoAluno());
        mv.setViewName("alunos/cadastro");
        return mv;
    }

    @GetMapping("/criarArmario")
    public ModelAndView criarArmario() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/criarArmario");
        return mv;
    }

}
