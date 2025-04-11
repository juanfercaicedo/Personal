package Programacion2.Ejercicios.Polinomio;

import java.util.Arrays;
import java.util.Scanner;

public class IngresarEcuacion {

    static Scanner scanner = new Scanner(System.in);

    public String[] nuevaEcuacion(String[] mostrarPolinomio) {
        System.out.println("Ingresa tu ecuación de la siguente forma " + Arrays.toString(mostrarPolinomio) + ": ");
        String ecuacionUsuario = scanner.nextLine();
        System.out.println(ecuacionUsuario);
        return mostrarPolinomio;
    }

}
