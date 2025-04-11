package Programacion2.Ejercicios.Polinomio;

import java.util.Arrays;

public class EstructuraCorrecta {

    public boolean estructuraCorrecta;

    public String[] estructuraValida(String[] ecuacionUsuario, String[] mostrarPolinomio) {
        if (Arrays.equals(ecuacionUsuario, mostrarPolinomio)) {
            estructuraCorrecta = true;
            System.out.println("Estructura correcta");
            return ecuacionUsuario;
        } else {
            estructuraCorrecta = false;
            return new String[]{"Ecuación no válida"};
        }
    }

}
