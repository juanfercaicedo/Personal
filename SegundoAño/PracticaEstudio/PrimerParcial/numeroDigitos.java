package SegundoAño.PracticaEstudio.PrimerParcial;

import java.util.Scanner;

public class numeroDigitos {

    static int digitos(int numero){
        if(numero < 10){
            return 1; // caso base
        } else {
            return 1 + digitos(numero / 10);        
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroUsuario;
        System.out.print("Introduce un numero: ");
        numeroUsuario = scanner.nextInt();

        int resultado = digitos(numeroUsuario);
        System.out.println("El numero introducido tiene " + resultado + " digitos");
    }
}
