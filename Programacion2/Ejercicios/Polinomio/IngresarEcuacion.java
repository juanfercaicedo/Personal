package Programacion2.Ejercicios.Polinomio;

import java.util.Arrays;
import java.util.Scanner;

public class IngresarEcuacion {

    static Scanner scanner = new Scanner(System.in);

    public String[][] ingresarPolinomios(int cantidad, String[] estructura) {
        String[][] polinomios = new String[cantidad][estructura.length];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa el polinomio " + (i + 1) + " de la siguiente forma" + Arrays.toString(estructura) + " : ");
            String entrada = scanner.nextLine();

            String[] terminos = entrada.split(",");

            if (terminos.length != estructura.length) {
                System.out.println("Error: Debes ingresar exactamente " + estructura.length + " términos.");
                i--;
                continue;
            }

            for (int j = 0; j < terminos.length; j++) {
                polinomios[i][j] = terminos[j].trim();
            }
        }

        return polinomios;
    }
}
