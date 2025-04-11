package Programacion2.Ejercicios.Polinomio;

public class Operaciones {

    private double[] coeficientes;

    public double[] parsear(String[] resultadoValidacion) {
        double[] coeficientes = new double[resultadoValidacion.length];
        for (int i = 0; i < resultadoValidacion.length; i++) {
            coeficientes[i] = Double.parseDouble(resultadoValidacion[i]);
        }
        return coeficientes;
    }

    public double[] sumaDePolinomio(double[] parsear) {

    }

}
