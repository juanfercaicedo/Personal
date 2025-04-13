package Programacion2.Ejercicios;

import java.util.Scanner;

public class Calculadora {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double primerNumeroUsuario = primerNumeroUsuario();
        double segundoNumeroUsuario = segundoNumeroUsuario();
        char operador = operador();
        double resultado = resultado(primerNumeroUsuario, segundoNumeroUsuario, operador);
        numeroFinal(resultado);
    }

    private static double primerNumeroUsuario() {
        System.out.print("Ingresa tu primer valor: ");
        double primerNumeroUsuario = scanner.nextDouble();
        return primerNumeroUsuario;
    }

    private static double segundoNumeroUsuario() {
        System.out.print("Ingresa tu segundo valor: ");
        double segundoNumeroUsuario = scanner.nextDouble();
        return segundoNumeroUsuario;
    }

    private static char operador() {
        System.out.print("Ingresa el operador(+, -, *, /, ^): ");
        char operador = scanner.next().charAt(0);
        return operador;
    }

    private static double resultado(double primerNumeroUsuario, double segundoNumeroUsuario, char operador) {
        double resultado;
        switch (operador) {
            case '+' ->
                resultado = primerNumeroUsuario + segundoNumeroUsuario;
            case '-' ->
                resultado = primerNumeroUsuario - segundoNumeroUsuario;
            case '*' ->
                resultado = primerNumeroUsuario * segundoNumeroUsuario;
            case '/' -> {
                if (segundoNumeroUsuario == 0) {
                    System.out.println("No se puede dividir por cero");
                }
                resultado = primerNumeroUsuario / segundoNumeroUsuario;
            }
            case '^' ->
                resultado = Math.pow(primerNumeroUsuario, segundoNumeroUsuario);
            default -> {
                System.out.println("Operador inválido.");
                return Double.NaN;
            }
        }
        return resultado;
    }

    private static void numeroFinal(double resultado) {
        System.out.printf("El resultado es %.1f \n", resultado);
    }
}
