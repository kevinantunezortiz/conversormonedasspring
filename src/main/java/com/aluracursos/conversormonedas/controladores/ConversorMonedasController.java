package com.aluracursos.conversormonedas.controladores;

import com.aluracursos.conversormonedas.modelos.ApiMonedas;
import com.aluracursos.conversormonedas.modelos.HistorialMonedas;
import com.aluracursos.conversormonedas.modelos.Resultado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.transform.Result;
import java.util.ArrayList;

@Controller
@RequestMapping("/conversor")
public class ConversorMonedasController {
    ApiMonedas apiMonedas = new ApiMonedas();
    HistorialMonedas historialMonedas = new HistorialMonedas();
    String origen = "Dólar Estadounidense";
    String destino = "Peso Mexicano";
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        model.addAttribute("monedas",apiMonedas.getMonedas().keySet());
        return "index"; // Devuelve el nombre de la vista (index.html) para mostrar el formulario de conversión.
    }
    @PostMapping("/")
    public String convertir(@RequestParam("monedaOrigen") String monedaOrigen,@RequestParam("monedaDestino") String monedaDestino,@RequestParam("cantidad") String cantidad,Model model ){
       Resultado resultado = apiMonedas.obtenerResultado(monedaOrigen, monedaDestino, cantidad);
       model.addAttribute("origen", monedaOrigen);
       model.addAttribute("destino", monedaDestino);
       model.addAttribute("cantidad",cantidad);
       model.addAttribute("monedas",apiMonedas.getMonedas().keySet());
       model.addAttribute("resultado",resultado);
       historialMonedas.guardarResultado(resultado);
       return "index";
    }
    @GetMapping("/historial")
    public String historial(Model model){
        var resultados = historialMonedas.obtenerResultados();
        model.addAttribute("resultados",resultados);
        return "historial";
    }
}
