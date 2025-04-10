package Programacion2.Ejercicios;

import java.util.Scanner;

public class Hypotenuse {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cathetaA = cathetaA();
        int cathetaB = cathetaB();
        hypotenuse(cathetaA, cathetaB);
    }

    private static int cathetaA() {
        System.out.print("Dame el valor del cateto A: ");
        int cathetaA = scanner.nextInt();
        return cathetaA;
    }

    private static int cathetaB() {
        System.out.print("Dame el valor del cateto B: ");
        int cathetaB = scanner.nextInt();
        return cathetaB;
    }

    private static void hypotenuse(int cathetaA, int cathetaB) {
        double hypotenuse = Math.sqrt(Math.pow(cathetaA, 2) + Math.pow(cathetaB, 2));
        long result = Math.round(hypotenuse);
        System.out.println("La hipotenusa de tu triangulo es: " + result);
        scanner.close();
    }

}
