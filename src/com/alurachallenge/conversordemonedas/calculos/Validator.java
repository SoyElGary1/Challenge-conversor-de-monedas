package com.alurachallenge.conversordemonedas.calculos;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;

public class Validator {

    Scanner sc = new Scanner(in);

    public int validadorOpcion() {
        boolean entradaValida = false;
        int opcion = 0;
        do {
            try {
                System.out.println("Introduce la opción: ");
                opcion = sc.nextInt();
                entradaValida = true;
                return opcion;
            } catch (InputMismatchException e) {
                System.out.println("¡Cuidado! Solo puedes introducir números enteros.");
                sc.next();
            }
        } while (!entradaValida);
        return opcion;
    }

    public double solicitarMonto() {
        double numero;
        do {
            numero = solicitarNumero();
            if (numero <= 0) {
                System.out.println("El monto debe ser mayor a 0. Por favor, inténtelo de nuevo.");
            }
        } while (numero <= 0);
        return numero;
    }

    private double solicitarNumero() {
        while (true) {
            try {
                System.out.println("Introduce el monto: ");
                double valor = sc.nextDouble();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("¡Cuidado! Solo puedes introducir números.");
                sc.next(); // Limpiar el buffer del scanner
            }
        }
    }
}
