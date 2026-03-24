package SegundoAño.PracticaEstudio.PrimerParcial;

import java.util.Scanner;

public class contar {

    static int sumar(int numeroSuma){
        if(numeroSuma == 0){
            return 0;
        }else{
            return numeroSuma + sumar(numeroSuma - 1);        
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroUsuario;
        System.out.print("Introduzca un número: ");
        numeroUsuario = scanner.nextInt();

        int resultado = sumar(numeroUsuario);

        System.out.println("El resultado es: " + resultado);

        scanner.close();
    }   
}
