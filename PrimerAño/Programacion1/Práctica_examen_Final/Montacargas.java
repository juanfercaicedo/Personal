import java.util.Scanner;

class Montacargas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int PLANTA_MINIMA = 0;
        final int PLANTA_MAXIMA = 10;
        final int CARGA_MINIMA = 30;
        final int CARGA_MAXIMA = 75;

        int plantaActual = PLANTA_MINIMA;
        boolean continuar = true;
        double cargaTotal = 0;

        System.out.println("Bienvenido al simulador del montacargas con registro de carga.");

        while (continuar) {
            imprimirMontacargas(plantaActual);
            System.out.println("En planta " + plantaActual);

            System.out.print("Ingrese la planta de destino (0 a 10) o -1 para salir: ");
            int plantaDestino = entrada.nextInt();

            if (plantaDestino == -1) {
                continuar = false;
            } else if (plantaDestino < PLANTA_MINIMA || plantaDestino > PLANTA_MAXIMA) {
                System.out.println("Planta no válida. Inténtelo de nuevo.");
            } else {
                double carga = Math.random() * (CARGA_MAXIMA - CARGA_MINIMA) + CARGA_MINIMA;
                cargaTotal = cargaTotal + carga;
                System.out.println("Carga subiendo: " + carga + " kg");

                if (plantaDestino > plantaActual) {
                    System.out.println("Subiendo a planta " + plantaDestino);
                } else if (plantaDestino < plantaActual) {
                    System.out.println("Bajando a planta " + plantaDestino);
                } else {
                    System.out.println("Ya estamos en esta planta.");
                }

                plantaActual = plantaDestino;
            }
        }

        System.out.println("Simulación terminada. El montacargas transportó un total de " + cargaTotal + " kg.");
        entrada.close();
    }

    private static void imprimirMontacargas(int plantaActual) {
        for (int i = 10; i >= 0; i--) {
            if (i == plantaActual) {
                System.out.println(i + " [---]");
            } else {
                System.out.println(i + "   |   ");
            }
        }
        System.out.println("--------------------");
    }
}
