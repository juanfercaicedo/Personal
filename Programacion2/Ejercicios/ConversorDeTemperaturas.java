package Programacion2.Ejercicios;

import java.util.Scanner;

public class ConversorDeTemperaturas {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String seleccionTemperatura = seleccionTemperatura();
        cambioDeTemperatura(seleccionTemperatura);
    }

    private static String seleccionTemperatura() {
        System.out.print("Ingresa a que quieres transformar, Grados Celcius o Fahrenheit: ");
        String seleccionTemperatura = scanner.nextLine();
        return seleccionTemperatura;
    }

    private static void cambioDeTemperatura(String seleccionTemperatura) {
        System.out.print("Ingresa la temperatura a cambiar: ");
        double temperaturaACambiar = scanner.nextDouble();
        double temperaturaFinal = (seleccionTemperatura.toLowerCase().contains("Grados Celcius")) ? temperaturaACambiar * 9 / 5 + 32 : temperaturaACambiar * 9 / 5 + 32;
        System.out.printf("La temperatura final es: %.1f " , temperaturaFinal);
    }
}
