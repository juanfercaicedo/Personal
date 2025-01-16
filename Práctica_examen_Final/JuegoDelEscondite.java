import java.util.Scanner;

class JuegoDelEscondite {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int Arbol = 1;
        final int Banco = 2;
        final int Arbusto = 3;
        final int Columpio = 4;
        final int Caseta = 5;
        final int Tobogan = 6;
        final double PROBABILIDAD_USUARIO_NO_VEA_NIÑOS = 0.1;
        final double PROBABILIDAD_RUIDO = 0.05;
        final double PROBABILIDAD_DE_CAMBIO = 0.3;
        int posicionNiño1, posicionNiño2, posicionNiño3, posicionNiño4;
        final int intentosMaximos = 12;
        int intentos = 0;
        boolean niño1Encontrado = false, niño2Encontrado = false, niño3Encontrado = false;

        posicionNiño1 = (int) (Math.random() * 6) + 1;
        posicionNiño2 = (int) (Math.random() * 6) + 1;
        posicionNiño3 = (int) (Math.random() * 6) + 1;

        System.out.println("¡Los niños se han escondido!");
        System.out.println(
                Arbol + " -Árbol " + Banco + " -Banco " + Arbusto + " -Arbusto " + Columpio + " -Columpio " + Caseta
                        + " -Caseta " + Tobogan + " -Tobogan ");
        System.out.println("En donde quieres buscar a los niños?");

        intentos++;

        while (intentos < intentosMaximos && (!niño1Encontrado || !niño2Encontrado || !niño3Encontrado)) {
            System.out.println("\nIntento #" + (intentos++) + ": ¿Dónde quieres buscar? (1-6)");
            posicionNiño4 = entrada.nextInt();

            if (intentos % 2 == 0 && Math.random() < PROBABILIDAD_RUIDO) {
                int niñoDelatado = (Math.random() < 0.33)
                        ? posicionNiño1
                        : (Math.random() < 0.5)
                                ? posicionNiño2
                                : posicionNiño3;

                System.out.println("¡Un niño hizo ruido y delató su posición!");
                System.out.println("Pista: Un niño está en el lugar " + niñoDelatado);
            } else {
                System.out.println("Todo está en silencio...");
            }

            if (intentos == 6 && Math.random() < PROBABILIDAD_DE_CAMBIO) {
                System.out.println("¡Los niños han cambiado de ubicación sigilosamente!");
                int nuevaPosicion1 = (int) (Math.random() * 6) + 1;
                int nuevaPosicion2 = (int) (Math.random() * 6) + 1;
                while (nuevaPosicion2 == nuevaPosicion1) {
                    nuevaPosicion2 = (int) (Math.random() * 6) + 1;
                }
                int nuevaPosicion3 = (int) (Math.random() * 6) + 1;
                while (nuevaPosicion3 == nuevaPosicion1 || nuevaPosicion3 == nuevaPosicion2) {
                    nuevaPosicion3 = (int) (Math.random() * 6) + 1;
                }

                posicionNiño1 = nuevaPosicion1;
                posicionNiño2 = nuevaPosicion2;
                posicionNiño3 = nuevaPosicion3;
            }

            if (!niño1Encontrado && posicionNiño4 == posicionNiño1) {
                if (Math.random() < PROBABILIDAD_USUARIO_NO_VEA_NIÑOS) {
                    System.out.println("¡Estabas cerca! Pero el niño 1 logró esconderse de nuevo.");
                } else {
                    niño1Encontrado = true;
                    System.out.println("¡Has encontrado al niño 1!");
                }
            } else if (!niño2Encontrado && posicionNiño4 == posicionNiño2) {
                if (Math.random() < PROBABILIDAD_USUARIO_NO_VEA_NIÑOS) {
                    System.out.println("¡Estabas cerca! Pero el niño 2 logró esconderse de nuevo.");
                } else {
                    niño2Encontrado = true;
                    System.out.println("¡Has encontrado al niño 2!");
                }
            } else if (!niño3Encontrado && posicionNiño4 == posicionNiño3) {
                if (Math.random() < PROBABILIDAD_USUARIO_NO_VEA_NIÑOS) {
                    System.out.println("¡Estabas cerca! Pero el niño 3 logró esconderse de nuevo.");
                } else {
                    niño3Encontrado = true;
                    System.out.println("¡Has encontrado al niño 3!");
                }
            } else {
                System.out.println("No hay niños en este lugar.");
            }

            do {
                posicionNiño2 = (int) (Math.random() * 6) + 1;
            } while (posicionNiño2 == posicionNiño1);

            do {
                posicionNiño3 = (int) (Math.random() * 6) + 1;
            } while (posicionNiño3 == posicionNiño1 || posicionNiño3 == posicionNiño2);

        }

        if (niño1Encontrado && niño2Encontrado && niño3Encontrado) {
            System.out.println("\n¡Felicidades! Has encontrado a todos los niños en " + intentos + " intentos.");
        } else {
            System.out.println("\nLo siento, no lograste encontrar a todos los niños.");
            System.out.println("Las posiciones de los niños eran:");
            if (!niño1Encontrado)
                System.out.println("Niño 1: en el lugar " + posicionNiño1);
            if (!niño2Encontrado)
                System.out.println("Niño 2: en el lugar " + posicionNiño2);
            if (!niño3Encontrado)
                System.out.println("Niño 3: en el lugar " + posicionNiño3);
        }

        entrada.close();
    }
}
