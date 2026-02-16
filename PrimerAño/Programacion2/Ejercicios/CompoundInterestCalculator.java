package Programacion2.Ejercicios;

import java.util.Scanner;

public class CompoundInterestCalculator {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[] valores = obtenerValoresDelUsuario();
        double principal = valores[0];
        double tasaInteres = valores[1];
        int[] tiempos = obtenerTiempos();
        int tiempoEnAnios = tiempos[0];
        int capitalizacionesPorAnio = tiempos[1];

        calcularInteresCompuesto(principal, tasaInteres, tiempoEnAnios, capitalizacionesPorAnio);
    }

    private static double[] obtenerValoresDelUsuario() {
        System.out.print("Ingresa la cantidad principal: ");
        double cantidadPrincipal = scanner.nextDouble();
        System.out.print("Ingresa la tasa de interés (porcentaje): ");
        double tasaInteres = scanner.nextDouble() / 100;

        return new double[]{cantidadPrincipal, tasaInteres};
    }

    private static int[] obtenerTiempos() {
        System.out.print("Ingresa el tiempo en años: ");
        int tiempo = scanner.nextInt();
        System.out.print("Ingresa las capitalizaciones por año: ");
        int capitalizaciones = scanner.nextInt();

        return new int[]{tiempo, capitalizaciones};
    }

    private static void calcularInteresCompuesto(double principal, double tasa, int tiempo, int capitalizacionesPorAnio) {
        double montoFinal = principal * Math.pow(1 + tasa / capitalizacionesPorAnio, capitalizacionesPorAnio * tiempo);
        System.out.printf("El monto final con interés compuesto es: %.2f%n", montoFinal);
    }
}
