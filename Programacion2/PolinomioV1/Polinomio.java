package PolinomioV1;

import java.util.Scanner;

public class Polinomio {

    private final IngresarEcuacion ingresarEcuacion;
    public final Derivada derivada;
    private final Operaciones operaciones;
    private final GradoPolinomio gradoPolinomio;
    private final EstructuraPolinomio estructuraPolinomio;
    private final EstructuraCorrecta estructuraCorrecta;

    Scanner scanner = new Scanner(System.in);

    public Polinomio() {
        ingresarEcuacion = new IngresarEcuacion();
        derivada = new Derivada();
        operaciones = new Operaciones();
        gradoPolinomio = new GradoPolinomio();
        estructuraPolinomio = new EstructuraPolinomio();
        estructuraCorrecta = new EstructuraCorrecta();
    }

    public void iniciar() {
        int grado = gradoPolinomio.ingresarGrado();
        String[] estructura = estructuraPolinomio.mostrarEstructuraPolinomios(grado);

        System.out.print("¿Cuántos polinomios deseas ingresar? ");
        int cantidadPolinomios = scanner.nextInt();

        String[][] polinomios = ingresarEcuacion.ingresarPolinomios(cantidadPolinomios, estructura);

        double[][] coeficientes = new double[cantidadPolinomios][];
        for (int i = 0; i < cantidadPolinomios; i++) {
            boolean esValido = estructuraCorrecta.estructuraValida(polinomios[i]);
            if (!esValido) {
                System.out.println("Polinomio " + (i + 1) + " inválido.");
                continue;
            }
            coeficientes[i] = operaciones.parsear(polinomios[i]);
        }

        while (cantidadPolinomios == 1) {
            System.out.print("¿Deseas calcular la derivada de los polinomio? (s/n): ");
            char calcularDerivada = scanner.next().charAt(0);

            if (calcularDerivada == 's' || calcularDerivada == 'S') {
                for (int i = 0; i < cantidadPolinomios; i++) {
                    if (coeficientes[i] != null) {
                        double[] derivadaPolinomio = derivada.calcularDerivada(coeficientes[i]);
                        System.out.println("Derivada del polinomio " + (i + 1) + ": "
                                + derivada.mostrarPolinomio(derivadaPolinomio));
                    }
                }
            }
            break;
        }

        if (cantidadPolinomios > 1) {

            System.out.print("¿Deseas sumar o restar los polinomios? (s/r): ");
            char operacion = scanner.next().charAt(0);

            double[] resultado;
            if (operacion == 's' || operacion == 'S') {
                resultado = operaciones.sumaDePolinomios(coeficientes);
                System.out.println("Resultado de la suma:");
            } else if (operacion == 'r' || operacion == 'R') {
                resultado = operaciones.restaDePolinomios(coeficientes);
                System.out.println("Resultado de la resta:");
            } else {
                System.out.println("Operación no válida.");
                return;
            }

            for (int i = 0; i < resultado.length; i++) {
                System.out.println("x^" + i + ": " + resultado[i]);
            }

            System.out.print("¿Deseas calcular la derivada de los polinomios? (s/n): ");
            char calcularDerivada = scanner.next().charAt(0);

            if (calcularDerivada == 's' || calcularDerivada == 'S') {
                for (int i = 0; i < cantidadPolinomios; i++) {
                    if (coeficientes[i] != null) {
                        double[] derivadaPolinomio = derivada.calcularDerivada(coeficientes[i]);
                        System.out.println("Derivada del polinomio " + (i + 1) + ": "
                                + derivada.mostrarPolinomio(derivadaPolinomio));
                    }
                }
            }
            scanner.close();
        }
    }
}
