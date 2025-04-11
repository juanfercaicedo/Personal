package Programacion2.Ejercicios.Polinomio;

import java.util.Arrays;
import java.util.Scanner;

public class IngresarEcuacion {

    static Scanner scanner = new Scanner(System.in);

    public String[] polinomios;

    public String[] ingresarPolinomios(String[] mostrarEstructuraPolinomios) {
        System.out.print("¿Cuántos polinomios deseas ingresar? ");
        String polinomiosPorIngresar = scanner.nextLine();
        int cantidad = 0;

        for (int i = 0; i < polinomiosPorIngresar.length(); i++) {
            char cantidadPolinomios = polinomiosPorIngresar.charAt(i);
            if (cantidadPolinomios >= '0' && cantidadPolinomios <= '9') {
                cantidad = cantidad * 10 + (cantidadPolinomios - '0');
            } else {
                System.out.println("Entrada inválida. Solo se permiten números.");
                return new String[0];
            }
        }

        polinomios = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa tu ecuación de la siguente forma " + Arrays.toString(mostrarEstructuraPolinomios) + ": ");
            polinomios[i] = scanner.nextLine();
        }

        return polinomios;
    }
}
