import java.util.Scanner;

class Ascensores {
    public static void main(String[] args) {
        final int CAPACIDAD_MAXIMA_PERSONAS = 6;
        final int NUMERO_PISOS = 7;
        final int PISO_BASE = -3;
        final double PROBABILIDAD_LLEGADA_PERSONA = 0.1;
        final int NUMERO_ASCENSORES = 3;

        int[] posicionesAscensores = new int[NUMERO_ASCENSORES];
        int[] personasEnAscensores = new int[NUMERO_ASCENSORES];
        boolean[] ascensoresEnMovimiento = new boolean[NUMERO_ASCENSORES];
        int[] destinosAscensores = new int[NUMERO_ASCENSORES];

        int[] personasEsperandoEnPisos = new int[NUMERO_PISOS];
        int[][] personasPorBajarEnPisos = new int[NUMERO_ASCENSORES][NUMERO_PISOS];

        for (int i = 0; i < NUMERO_ASCENSORES; i++) {
            posicionesAscensores[i] = 0;
            personasEnAscensores[i] = 0;
            ascensoresEnMovimiento[i] = false;
            destinosAscensores[i] = 0;
        }

        boolean continuarSimulacion = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a los ascensores de la Universidad Europea del Atlántico");

        while (continuarSimulacion) {
            for (int piso = 0; piso < NUMERO_PISOS; piso++) {
                if (Math.random() < PROBABILIDAD_LLEGADA_PERSONA) {
                    personasEsperandoEnPisos[piso]++;
                    System.out.println("¡Ha llegado una persona nueva al piso " + convertirPiso(piso, PISO_BASE) + "!");
                }
            }

            for (int i = 0; i < NUMERO_ASCENSORES; i++) {
                if (ascensoresEnMovimiento[i]) {
                    posicionesAscensores[i] = (posicionesAscensores[i] < destinosAscensores[i])
                            ? posicionesAscensores[i] + 1
                            : (posicionesAscensores[i] > destinosAscensores[i])
                                    ? posicionesAscensores[i] - 1
                                    : posicionesAscensores[i];

                    if (posicionesAscensores[i] == destinosAscensores[i]) {
                        ascensoresEnMovimiento[i] = false;
                        int pisoIndex = posicionesAscensores[i] - PISO_BASE;
                        System.out.println("El ascensor " + (i + 1) + " ha llegado al piso "
                                + convertirPiso(posicionesAscensores[i], PISO_BASE));
                        System.out.println(personasPorBajarEnPisos[i][pisoIndex] + " personas se bajan del ascensor.");

                        personasEnAscensores[i] -= personasPorBajarEnPisos[i][pisoIndex];
                        personasPorBajarEnPisos[i][pisoIndex] = 0;
                    }
                }
            }

            for (int piso = 0; piso < NUMERO_PISOS; piso++) {
                if (personasEsperandoEnPisos[piso] > 0) {
                    int ascensorAsignado = asignarAscensor(posicionesAscensores, personasEnAscensores, piso,
                            CAPACIDAD_MAXIMA_PERSONAS, ascensoresEnMovimiento);
                    if (ascensorAsignado != -1) {
                        destinosAscensores[ascensorAsignado] = piso + PISO_BASE;
                        ascensoresEnMovimiento[ascensorAsignado] = true;

                        int espacioDisponible = CAPACIDAD_MAXIMA_PERSONAS - personasEnAscensores[ascensorAsignado];
                        int subiendo = Math.min(personasEsperandoEnPisos[piso], espacioDisponible);

                        personasEnAscensores[ascensorAsignado] += subiendo;
                        personasEsperandoEnPisos[piso] -= subiendo;

                        for (int j = 0; j < subiendo; j++) {
                            int destinoAleatorio;
                            do {
                                destinoAleatorio = (int) (Math.random() * NUMERO_PISOS);
                            } while (destinoAleatorio == piso);
                            personasPorBajarEnPisos[ascensorAsignado][destinoAleatorio]++;
                        }

                        System.out.println(subiendo + " personas han subido al ascensor " + (ascensorAsignado + 1)
                                + " desde el piso " + convertirPiso(piso, PISO_BASE) + ".");
                    }
                }
            }

            for (int i = 0; i < NUMERO_ASCENSORES; i++) {
                if (!ascensoresEnMovimiento[i] && personasEnAscensores[i] > 0) {
                    int destinoAsignado = obtenerDestinoDePersonas(i, personasPorBajarEnPisos);
                    if (destinoAsignado != -1) {
                        destinosAscensores[i] = destinoAsignado;
                        ascensoresEnMovimiento[i] = true;
                    }
                }
            }

            imprimirEstado(personasEsperandoEnPisos, posicionesAscensores, personasEnAscensores,
                    personasPorBajarEnPisos, PISO_BASE);

            System.out.println("Presiona Enter para continuar o 'q' para salir...");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                continuarSimulacion = false;
            }
        }

        System.out.println("¡Gracias por usar el sistema de ascensores!");
        scanner.close();
    }

    private static int asignarAscensor(int[] posicionesAscensores, int[] personasEnAscensores, int piso,
            int CAPACIDAD_MAXIMA_PERSONAS, boolean[] ascensoresEnMovimiento) {
        int ascensorAsignado = -1;
        int menorDistancia = Integer.MAX_VALUE;

        for (int i = 0; i < posicionesAscensores.length; i++) {
            if (personasEnAscensores[i] < CAPACIDAD_MAXIMA_PERSONAS && !ascensoresEnMovimiento[i]) {
                int distancia = Math.abs(posicionesAscensores[i] - (piso - 3));
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    ascensorAsignado = i;
                }
            }
        }

        return ascensorAsignado;
    }

    private static int obtenerDestinoDePersonas(int ascensorIndex, int[][] personasPorBajarEnPisos) {
        for (int destino = 0; destino < personasPorBajarEnPisos[ascensorIndex].length; destino++) {
            if (personasPorBajarEnPisos[ascensorIndex][destino] > 0) {
                return destino + (-3);
            }
        }
        return -1;
    }

    private static void imprimirEstado(int[] personasEsperandoEnPisos, int[] posicionesAscensores,
            int[] personasEnAscensores, int[][] personasPorBajarEnPisos, int PISO_BASE) {
        System.out.println("\nEstado de los ascensores y pisos:");
        System.out.println("Personas esperando  Ascensores    Personas en la planta");

        for (int piso = personasEsperandoEnPisos.length - 1; piso >= 0; piso--) {
            String lineaAscensores = "";

            for (int i = 0; i < posicionesAscensores.length; i++) {
                lineaAscensores += (posicionesAscensores[i] == piso + PISO_BASE)
                        ? " [^" + personasEnAscensores[i] + "^] "
                        : "  [ ]  ";
            }

            String nombrePiso = convertirPiso(piso, PISO_BASE);
            System.out.println("Piso " + nombrePiso + "   Esperando " + personasEsperandoEnPisos[piso] + "   "
                    + lineaAscensores + "   " + personasEsperandoEnPisos[piso]);
        }

        System.out.println();
    }

    private static String convertirPiso(int piso, int PISO_BASE) {
        return (piso + PISO_BASE == 0) ? "B" : Integer.toString(piso + PISO_BASE);

    }
}
