package com.aluracursos.aluraexchange.recursos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversionDeMoneda {

    public static void convertir(String monedaBase, String monedaTarget, ConsultaValorMoneda consultar, Scanner lectura) {
        DecimalFormat formatoDecimal = new DecimalFormat("#,##0.00");

        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consultar.buscarMonedas(monedaBase, monedaTarget);
        System.out.println("----------------------------------------");
        System.out.println("Tipo de Cambio:");
        System.out.println("1 " + monedaBase + " = " + formatoDecimal.format(monedas.conversion_rate()) + " " + monedaTarget);
        System.out.println("----------------------------------------");

        System.out.println("Ingrese la cantidad de " + monedaBase + " a convertir:");
        cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();

        System.out.println("----------------------------------------");
        System.out.println(formatoDecimal.format(cantidad) + " " + monedaBase + " = " + formatoDecimal.format(cantidadConvertida) + " " + monedaTarget);
        System.out.println("----------------------------------------");
    }
}
