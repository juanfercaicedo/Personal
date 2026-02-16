package Programacion2.Ejercicios;

import java.util.Scanner;

public class ConvertidoDePeso {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String seleccionPeso = seleccionPeso();
        pesoFinal(seleccionPeso);
    }

    private static String seleccionPeso() {
        System.out.print("Selecciona que peso vas a meter en Kilos o Libras: ");
        String seleccionPeso = scanner.nextLine();
        return seleccionPeso;
    }

    private static void pesoFinal(String seleccionPeso) {
        if (seleccionPeso.toLowerCase().contains("libras")) {
            System.out.print("Ingresa el peso: ");
            double peso = scanner.nextDouble();
            System.out.println("Haz escogido pasar de libras a kilos");
            double pesoLibrasAKilo = peso / 2.25;
            System.out.printf("El peso en kilos es de: %.1f kgs \n", pesoLibrasAKilo);
        } else if (seleccionPeso.toLowerCase().contains("kilos")) {
            System.out.print("Ingresa el peso: ");
            double peso = scanner.nextDouble();
            System.out.println("Haz escogido pasar de kilos a libras");
            double pesoKiloALibras = peso * 2.25;
            System.out.printf("El peso en libras es de: %.1f lbs", pesoKiloALibras);
        } else {
            System.out.println("Seleccion de peso no valida.");
        }
        scanner.close();
    }
}
