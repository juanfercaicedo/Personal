package Polinomio;

public class GradoPolinomio {

    public int detectarGrado(String[] polinomio) {
        int gradoMaximo = 0;

        for (int i = 0; i < polinomio.length; i++) {
            String termino = polinomio[i].trim();

            if (termino.contains("^")) {
                int pos = termino.indexOf("^");
                String potencia = "";
                for (int j = pos + 1; j < termino.length(); j++) {
                    if (Character.isDigit(termino.charAt(j))) {
                        potencia += termino.charAt(j);
                    }
                }

                if (!potencia.isEmpty()) {
                    int grado = Integer.parseInt(potencia);
                    if (grado > gradoMaximo) {
                        gradoMaximo = grado;
                    }
                }
            } else if (termino.contains("x")) {
                if (gradoMaximo < 1) {
                    gradoMaximo = 1;
                }
            }
        }
        return gradoMaximo;
    }
}
