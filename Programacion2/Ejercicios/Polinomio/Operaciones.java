package Programacion2.Ejercicios.Polinomio;

public class Operaciones {

    public double[] parsear(String[] resultadoValidacion) {
        double[] coeficientes = new double[resultadoValidacion.length];
        for (int i = 0; i < resultadoValidacion.length; i++) {
            coeficientes[i] = Double.parseDouble(resultadoValidacion[i]);
        }
        return coeficientes;
    }

    public double[] sumaDePolinomios(double[][] coeficientes) {
        int coeficienteMayor = 0;
        for (double[] polinomio : coeficientes) {
            coeficienteMayor = Math.max(coeficienteMayor, polinomio.length);
        }

        double[] resultadoSuma = new double[coeficienteMayor];

        for (double[] polinomio : coeficientes) {
            for (int i = 0; i < polinomio.length; i++) {
                resultadoSuma[i] += polinomio[i];
            }
        }

        return resultadoSuma;
    }

    public double[] restaDePolinomios(double[][] coeficientes) {
        int coeficienteMayor = 0;
        for (double[] polinomio : coeficientes) {
            coeficienteMayor = Math.max(coeficienteMayor, polinomio.length);
        }

        double[] resultadoResta = new double[coeficienteMayor];

        for (int i = 0; i < coeficientes[0].length; i++) {
            resultadoResta[i] = coeficientes[0][i];
        }

        for (int i = 1; i < coeficientes.length; i++) {
            for (int j = 0; j < coeficientes[i].length; j++) {
                resultadoResta[j] -= coeficientes[i][j];
            }
        }

        return resultadoResta;
    }
}
