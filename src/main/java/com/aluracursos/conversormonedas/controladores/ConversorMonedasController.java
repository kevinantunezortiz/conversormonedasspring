package com.aluracursos.conversormonedas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conversor")
public class ConversorMonedasController {
    // Aquí puedes agregar métodos para manejar las solicitudes HTTP y la lógica de conversión de monedas.
    // Por ejemplo, puedes tener un método para mostrar el formulario de conversión y otro para procesar la conversión.
    @GetMapping("/")
    public String index() {
        return "index"; // Devuelve el nombre de la vista (index.html) para mostrar el formulario de conversión.
    }
}
