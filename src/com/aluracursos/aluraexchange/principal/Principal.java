package com.aluracursos.aluraexchange.principal;

import com.aluracursos.aluraexchange.recursos.ConsultaValorMoneda;
import com.aluracursos.aluraexchange.recursos.ConversionDeMoneda;
import com.aluracursos.aluraexchange.recursos.DivisasDisponibles;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);
        ConsultaValorMoneda consulta = new ConsultaValorMoneda();
        Set<String> divisas = DivisasDisponibles.NOMBRES_DIVISAS.keySet();

        boolean continuar = true;

        while (continuar) {
            System.out.println("----------------------------------------");
            System.out.println("Alura Exchange - Conversor de Monedas");
            System.out.println("----------------------------------------");
            System.out.println("Seleccione la moneda de origen:");

            String[] divisasArray = divisas.toArray(new String[0]);
            for (int i = 0; i < divisasArray.length; i++) {
                String codigo = divisasArray[i];
                String nombre = DivisasDisponibles.NOMBRES_DIVISAS.get(codigo);
                System.out.println((i + 1) + ". " + codigo + " - " + nombre);
            }

            int indiceOrigen = leerNumeroSeguro(entradaUsuario, divisasArray.length);
            if (indiceOrigen == -1) continue;

            String monedaBase = divisasArray[indiceOrigen - 1];

            System.out.println("\nSeleccione la moneda de destino:");
            int contador = 1;
            for (String codigo : divisasArray) {
                if (!codigo.equals(monedaBase)) {
                    String nombre = DivisasDisponibles.NOMBRES_DIVISAS.get(codigo);
                    System.out.println(contador + ". " + codigo + " - " + nombre);
                    contador++;
                }
            }

            int seleccionDestino = leerNumeroSeguro(entradaUsuario, divisasArray.length - 1);
            if (seleccionDestino == -1) continue;

            String monedaTarget = null;
            contador = 1;
            for (String codigo : divisasArray) {
                if (!codigo.equals(monedaBase)) {
                    if (contador == seleccionDestino) {
                        monedaTarget = codigo;
                        break;
                    }
                    contador++;
                }
            }

            if (monedaTarget == null) {
                System.out.println("Selección inválida. Intente de nuevo.");
                continue;
            }

            ConversionDeMoneda.convertir(monedaBase, monedaTarget, consulta, entradaUsuario);

            System.out.println("\n¿Desea realizar otra operación? (S/N)");
            String respuesta = entradaUsuario.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                continuar = false;
                System.out.println("Gracias por usar Alura Exchange. ¡Hasta luego!");
            }
        }
    }

    private static int leerNumeroSeguro(Scanner scanner, int maximoPermitido) {
        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            if (numero < 1 || numero > maximoPermitido) {
                System.out.println("Número fuera de rango. Intente de nuevo.");
                return -1;
            }
            return numero;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine();
            return -1;
        }
    }
}




