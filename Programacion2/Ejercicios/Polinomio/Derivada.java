package Programacion2.Ejercicios.Polinomio;

public class Derivada {


    public double[] calcularDerivada(double[] coeficientes) {
        if (coeficientes.length == 0) {
            return new double[0]; 
        }

        double[] derivada = new double[coeficientes.length - 1];

        for (int i = 1; i < coeficientes.length; i++) {
            derivada[i - 1] = coeficientes[i] * i; // n * a_n
        }

        return derivada;
    }

    public String mostrarPolinomio(double[] coeficientes) {
        String resultado = "";
        for (int i = 0; i < coeficientes.length; i++) {
            if (coeficientes[i] != 0) {
                if (!resultado.isEmpty()) {
                    resultado += " + ";
                }
                resultado += coeficientes[i];
                if (i > 0) {
                    resultado += "x^" + i;
                }
            }
        }
        return resultado.isEmpty() ? "0" : resultado;
    }
}
