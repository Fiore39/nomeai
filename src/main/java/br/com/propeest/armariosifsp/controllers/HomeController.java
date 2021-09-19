package br.com.propeest.armariosifsp.controllers;

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

    @GetMapping("/criarArmario")
    public ModelAndView criarArmario() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/criarArmario");
        return mv;
    }

}
