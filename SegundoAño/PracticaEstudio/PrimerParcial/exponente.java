package SegundoAño.PracticaEstudio.PrimerParcial;

import java.util.Scanner;

public class exponente {

    static int exponenteRecursivo(int numeroBase, int numeroExponente){
        if(numeroExponente == 0){
            return 1; // caso base
        }else{
            return numeroBase * exponenteRecursivo(numeroBase, numeroExponente - 1);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int base, exponenteUsuario;
        System.out.print("Introduce la base: ");
        base = scanner.nextInt();
        System.out.print("Ahora introduce el exponente: ");
        exponenteUsuario = scanner.nextInt();

        int resultadoExponente = exponenteRecursivo(base, exponenteUsuario);
        System.out.println("El resultado es: "+resultadoExponente);
    }
}
