import java.util.Scanner;

public class IntegralExamenParcial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Límite inferior (a): ");
        double a = scanner.nextDouble();

        System.out.print("Límite superior (b): ");
        double b = scanner.nextDouble();

        int n = 100;

        double resultado = integrar(a, b, n);
        System.out.println("Resultado de la integral: " + resultado);

        scanner.close();
    }

    public static double funcion(double x) {
        return 5 * (Math.sin(x / 1.59) + 0.33 * Math.sin(3 * x / 1.59) + 0.2 * Math.sin(5 * x / 1.59));
    }

    public static double integrar(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = (funcion(a) + funcion(b)) / 2;

        for (int i = 1; i < n; i++) {
            suma += funcion(a + i * h);
        }

        return suma * h;
    }

}
