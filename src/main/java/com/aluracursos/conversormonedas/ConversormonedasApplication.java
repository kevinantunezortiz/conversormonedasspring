package com.aluracursos.conversormonedas;

import com.aluracursos.conversormonedas.modelos.ApiMonedas;
import com.aluracursos.conversormonedas.modelos.Resultado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversormonedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversormonedasApplication.class, args);
		ApiMonedas apiMonedas = new ApiMonedas();
		Resultado resultado = apiMonedas.obtenerResultado("Dólar Estadounidense","Peso Mexicano","100");
		System.out.println(resultado.toString());
	}

}
