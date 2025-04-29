package PolinomioV1;

public class EstructuraCorrecta {

    public boolean estructuraValida(String[] polinomio) {
        if (polinomio == null) {
            System.out.println("El arreglo no puede ser nulo.");
            return false;
        }

        for (int i = 0; i < polinomio.length; i++) {
            String termino = polinomio[i].trim();

            switch (i) {
                case 0 -> {
                    if (!esNumero(termino)) {
                        System.out.println("Término constante no válido: " + termino);
                        return false;
                    }
                }
                case 1 -> {
                    if (!termino.endsWith("x")) {
                        System.out.println("Término lineal no válido: " + termino);
                        return false;
                    }
                    String coeficienteLineal = obtenerCoeficiente(termino);
                    if (!esNumero(coeficienteLineal)) {
                        System.out.println("Coeficiente del término lineal inválido: " + termino);
                        return false;
                    }
                }
                default -> {
                    String esperado = "x^" + i;
                    if (!termino.contains(esperado)) {
                        System.out.println(
                                "Término de grado " + i + " inválido: " + termino + ". Se esperaba algo como: ax^" + i);
                        return false;
                    }
                    String[] partes = termino.split("x\\^");
                    String coef = partes[0];
                    if (!esNumero(coef)) {
                        System.out.println("Coeficiente inválido para x^" + i + ": " + coef);
                        return false;
                    }
                }
            }
        }

        System.out.println("Estructura correcta.");
        return true;
    }

    private String obtenerCoeficiente(String termino) {
        String coef = "";
        for (int i = 0; i < termino.length() - 1; i++) {
            coef += termino.charAt(i);
        }
        if (coef.isEmpty()) {
            return "1";
        } else if (coef.equals("-")) {
            return "-1";
        }
        return coef;
    }

    private boolean esNumero(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }

        int cantidadDePuntosDecimales = 0;
        int posicionInicial = (texto.charAt(0) == '-' || texto.charAt(0) == '+') ? 1 : 0;

        for (int posicion = posicionInicial; posicion < texto.length(); posicion++) {
            char caracterActual = texto.charAt(posicion);

            if (caracterActual == '.') {
                cantidadDePuntosDecimales++;
                if (cantidadDePuntosDecimales > 1) {
                    return false;
                }
            } else if (caracterActual < '0' || caracterActual > '9') {
                return false;
            }
        }

        return true;
    }
}
