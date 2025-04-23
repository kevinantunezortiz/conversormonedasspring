package com.aluracursos.conversormonedas.modelos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
        @Expose @SerializedName("conversion_rate") private double valor;
        @Expose @SerializedName("conversion_result") private double total;
        private String moneda1, moneda2, codigoMoneda1, codigoMoneda2, cantidad, fechaHoraActual;

        public Resultado(double valor, double total) {
                this.valor = valor;
                this.total = total;
        }

        @Override
        public String toString() {
                return """
                Moneda Origen = %s Moneda Destino = %s\n
                Cantidad = %s   1 %s = %.5f %s\n
                Total = %.5f    Fecha y Hora = %s
                """.formatted(moneda1, moneda2, cantidad, codigoMoneda1, valor, codigoMoneda2, total, fechaHoraActual);
        }
}