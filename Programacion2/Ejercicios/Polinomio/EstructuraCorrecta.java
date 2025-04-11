package Programacion2.Ejercicios.Polinomio;

public class EstructuraCorrecta {

    public boolean estructuraCorrecta;

    public Boolean estructuraValida(String polinomio, String[] mostrarEstructuraPolinomios) {
        String[] terminos = polinomio.split(",");

        if (terminos.length != mostrarEstructuraPolinomios.length) {
            System.out.println("La cantidad de términos no coincide con la estructura esperada.");
            return false;
        }

        for (int i = 0; i < terminos.length; i++) {
            String termino = terminos[i].trim();

            if (i == 0 && !termino.matches("-?\\d*\\.?\\d+")) {
                System.out.println("Término constante no válido: " + termino);
                return false;
            }
            if (i == 1 && !termino.matches("-?\\d*\\.?\\d+x")) {
                System.out.println("Término lineal no válido: " + termino);
                return false;
            }
            if (i > 1 && !termino.matches("-?\\d*\\.?\\d+x\\^" + i)) {
                System.out.println("Término de grado " + i + " no válido: " + termino);
                return false;
            }
        }

        System.out.println("Estructura correcta.");
        return true;
    }

}
