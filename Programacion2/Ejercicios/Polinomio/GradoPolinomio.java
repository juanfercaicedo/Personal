package Programacion2.Ejercicios.Polinomio;

import java.util.Scanner;

public class GradoPolinomio {

    static Scanner scanner = new Scanner(System.in);

    public int ingresarGrado() {
        System.out.print("Ingresa el grado de tu polinomio: ");
        int gradoPolinomio = scanner.nextInt();
        return gradoPolinomio;
    }

}
