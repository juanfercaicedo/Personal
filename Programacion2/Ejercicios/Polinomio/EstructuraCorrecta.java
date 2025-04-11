package Programacion2.Ejercicios.Polinomio;

public class EstructuraCorrecta {

    public boolean estructuraCorrecta;

    public String[] estructuraValida(String[] ecuacionUsuario, String[] mostrarPolinomio) {
        if (ecuacionUsuario == mostrarPolinomio) {
            estructuraCorrecta = true;
        }
    }

}
