import java.util.Scanner;

class JuegoNiñosConMatrices {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int ARBOL = 1;
        final int BANCO = 2;
        final int ARBUSTO = 3;
        final int COLUMPIO = 4;
        final int CASETA = 5;
        final int TOBOGAN = 6;

        final double PROBABILIDAD_NO_ENCONTRAR = 0.1;
        final int INTENTOS_MAXIMOS = 12;

        int[] posicionesNiños = new int[3];
        boolean[] niñosEncontrados = { false, false, false };
        int intentos = 0;

        for (int i = 0; i < posicionesNiños.length; i++) {
            posicionesNiños[i] = (int) (Math.random() * 6) + 1;
        }

        System.out.println("¡Los niños se han escondido!");
        System.out.println(
                ARBOL + " -Árbol " + BANCO + " -Banco " + ARBUSTO + " -Arbusto " + COLUMPIO + " -Columpio " + CASETA
                        + " -Caseta " + TOBOGAN + " -Tobogan ");
        System.out.println("Tienes " + INTENTOS_MAXIMOS + " intentos para encontrarlos.\n");

        while (intentos < INTENTOS_MAXIMOS && (!niñosEncontrados[0] || !niñosEncontrados[1] || !niñosEncontrados[2])) {
            System.out.println("Intento #" + (intentos++) + ": ¿Dónde quieres buscar? (1-6)");
            int posicionElegida = entrada.nextInt();
            if (posicionElegida > 6 || posicionElegida < 1) {
                System.out.println("Introduce un número válido");
            }

            boolean alguienEncontrado = false;
            for (int i = 0; i < posicionesNiños.length; i++) {
                if (!niñosEncontrados[i] && posicionesNiños[i] == posicionElegida) {
                    if (Math.random() < PROBABILIDAD_NO_ENCONTRAR) {
                        System.out.println("¡Estabas cerca! Pero el niño logró esconderse de nuevo.");
                    } else {
                        niñosEncontrados[i] = true;
                        System.out.println("¡Has encontrado al niño " + (i + 1) + "!");
                        alguienEncontrado = true;
                    }
                }
            }

            if (!alguienEncontrado) {
                System.out.println("No hay niños en este lugar.");
            }

            intentos++;
        }

        if (niñosEncontrados[0] && niñosEncontrados[1] && niñosEncontrados[2]) {
            System.out.println("\n¡Felicidades! Has encontrado a todos los niños en " + intentos + " intentos.");
        } else {
            System.out.println("\nLo siento, no lograste encontrar a todos los niños.");
            System.out.println("Las posiciones de los niños eran:");
            for (int i = 0; i < posicionesNiños.length; i++) {
                if (!niñosEncontrados[i]) {
                    System.out.println("Niño " + (i + 1) + ": en el lugar " + posicionesNiños[i]);
                }
            }
        }

        entrada.close();
    }
}
