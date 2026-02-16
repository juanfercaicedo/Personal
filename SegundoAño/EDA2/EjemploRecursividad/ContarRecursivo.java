package SegundoAño.EDA2.EjemploRecursividad;
import java.util.Scanner;
class ContarRecursivo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valorUsuario;
        System.out.print("Introduce los valores que quieres contar:");
        valorUsuario = scanner.nextInt();
        contar(valorUsuario);

        scanner.close();
    }

    static void contar(int valorFinal){
        if(valorFinal == 0){
            System.out.println(valorFinal);
        }else{
            contar(valorFinal -1);
            System.out.println(valorFinal);
        }
    }
}

// Es recursivo porqué el método se llama a si mismo

// PILA DE LLAMADA (LIFO) - LAST IN FIRST OUT
// Define un contexto   