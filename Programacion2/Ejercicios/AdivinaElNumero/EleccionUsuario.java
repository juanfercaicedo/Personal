package Programacion2.Ejercicios.AdivinaElNumero;

import java.util.Scanner;

public class EleccionUsuario {

    static Scanner scanner = new Scanner(System.in);
    public int eleccionUsuario;

    public int numeroEscogido() {
        do {
            System.out.print("Ingresa un número entre 1 y 100: ");
            eleccionUsuario = scanner.nextInt();
            if (eleccionUsuario < 1 || eleccionUsuario > 100) {
                System.out.println("Valor fuera de rango. Inténtalo de nuevo.");
            }
        } while (eleccionUsuario < 1 || eleccionUsuario > 100);
        System.out.println("El número escogido por el usuario es: " + eleccionUsuario);
        scanner.close();
        return eleccionUsuario;
    }
}
