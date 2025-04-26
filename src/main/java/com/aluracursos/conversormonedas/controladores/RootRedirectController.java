package com.aluracursos.conversormonedas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootRedirectController {
    @GetMapping("/")
    public String redirectToConversor(){
        return"redirect:/conversor/";
    }
}
