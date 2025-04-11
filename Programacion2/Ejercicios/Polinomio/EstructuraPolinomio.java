package Programacion2.Ejercicios.Polinomio;

public class EstructuraPolinomio {

    public double[] gradoValido(int grado) {
        if (grado < 2 || grado > 7) {
            System.out.println("Grado fuera de rango(2 a 7)!");
        }
        return new double[grado + 1];
    }

    public String[] mostrarEstructuraPolinomios(int grado) {
        String[] estructura = new String[grado + 1];
        for (int i = 0; i <= grado; i++) {

            if (i == 0) {
                estructura[i] = "c";
            } else if (i == 1) {
                estructura[i] = "bx";
            } else {
                estructura[i] = "a" + "x^" + i;
            }
        }
        return estructura;
    }

}
