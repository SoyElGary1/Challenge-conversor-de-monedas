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
                System.out.println("¡Cuidado! Solo puedes introducir números.");
                sc.next();
            }
        } while (!entradaValida);
        return opcion;
    }

    public double solicitarMonto() {
        boolean entradaValida = false;
        double numero = 0;
        do {
            System.out.println("Introduce el monto: ");
            try {
                numero = sc.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("¡Cuidado! Solo puedes introducir números.");
                sc.next();
            }
        } while (!entradaValida);
        return numero;
    }
}
