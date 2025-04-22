package com.aluracursos.conversormonedas.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Resultado {
        @Expose @SerializedName("conversion_rate")
        private double valor;
        @Expose @SerializedName("conversion_result")
        private double total;
        private String moneda1,moneda2,codigoMoneda1,codigoMoneda2,cantidad,fechaHoraActual;
        public Resultado(double valor, double total) {
                this.valor = valor;
                this.total = total;

        }

        public String getFechaHoraActual() {

                return fechaHoraActual;
        }


        public double getValor() {
                return valor;
        }

        public double getTotal() {
                return total;
        }

        public void setMoneda1(String moneda1) {
                this.moneda1 = moneda1;
        }

        public void setMoneda2(String moneda2) {
                this.moneda2 = moneda2;
        }

        public void setCantidad(String cantidad) {
                this.cantidad = cantidad;
        }

        public void setCodigoMoneda1(String codigoMoneda1) {
                this.codigoMoneda1 = codigoMoneda1;
        }

        public void setCodigoMoneda2(String codigoMoneda2) {
                this.codigoMoneda2 = codigoMoneda2;
        }

        public void setFechaHoraActual(String fechaHoraActual) {
                this.fechaHoraActual = fechaHoraActual;
        }

        @Override
        public String toString() {
                return "Resultado{" +
                        "valor=" + valor +
                        ", total=" + total +
                        ", moneda1='" + moneda1 + '\'' +
                        ", moneda2='" + moneda2 + '\'' +
                        ", cantidad='" + cantidad + '\'' +
                        ", fechaHoraActual='" + fechaHoraActual +'\'' +
                        '}';
        }
}
