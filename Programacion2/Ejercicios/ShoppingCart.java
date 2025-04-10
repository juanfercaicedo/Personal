package Programacion2.Ejercicios;

import java.util.Scanner;

public class ShoppingCart {

    public static Scanner scanner = new Scanner(System.in);
    public static char dolarSign = '$';

    public static void main(String[] args) {
        String food = foodToBuy();
        int quantity = quantityToBuy();
        double price = price();

        totalPrice(quantity, price, food);
    }

    private static String foodToBuy() {
        System.out.print("Ingresa la comida que quieres comprar: ");
        String food = scanner.nextLine();
        System.out.println("Comida seleccionada: " + food);
        return food;
    }

    private static int quantityToBuy() {
        System.out.print("Ingresa la cantidad de comida que quieres comprar: ");
        int quantity = scanner.nextInt();
        System.out.println("Cantidad seleccionada: " + quantity);
        scanner.nextLine();
        return quantity;
    }

    private static double price() {
        System.out.print("Ingresa el precio de la comida: ");
        double price = scanner.nextDouble();
        System.out.println("El precio individual es: " + dolarSign + price);
        scanner.nextLine();
        return price;
    }

    private static void totalPrice(int quantity, double price, String food) {
        double totalPrice = quantity * price;
        System.out.println("El precio total de #" + quantity + " " + food + " es: " + dolarSign + totalPrice);
    }

}
