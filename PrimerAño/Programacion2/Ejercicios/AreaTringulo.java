package Programacion2.Ejercicios;

import java.util.Scanner;

public class AreaTringulo {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int base = base();
        int height = height();
        area(base, height);
    }

    private static int base() {
        System.out.print("Ingresa la base de tu triangulo: ");
        int base = scanner.nextInt();
        return base;
    }

    private static int height() {
        System.out.print("Ingresa la altura de tu triangulo: ");
        int height = scanner.nextInt();
        return height;
    }

    private static int area(int base, int height) {
        int area = (base * height) / 2;
        System.out.print("El area de tu triangulo es: " + area);
        return area;
    }
}
