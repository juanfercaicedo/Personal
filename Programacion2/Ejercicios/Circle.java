package Programacion2.Ejercicios;

import java.util.Scanner;

public class Circle {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double radio = radio();
        circunferencia(radio);
        area(radio);
        volumen(radio);
    }

    private static double radio() {
        System.out.print("Ingresa el radio: ");
        double radio = scanner.nextDouble();
        return radio;
    }

    private static void circunferencia(double radio) {
        double circunferencia = 2 * Math.PI * radio;
        System.out.printf("La circunferencia de tu circulo es de: %.1f\n", circunferencia);
    }

    private static void area(double radio) {
        double area = Math.PI * Math.pow(radio, 2);
        System.out.printf("El área de tu circulo es de: %.1f\n ", area);
    }

    private static void volumen(double radio) {
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
        System.out.printf("El volumen de tu circulo es de: %.1f\n", volumen);
    }
}
