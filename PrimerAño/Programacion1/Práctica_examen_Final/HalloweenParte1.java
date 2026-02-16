import java.util.Scanner;

class HalloweenParte1 {
    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);

        int[] caramelos = { 0, 0, 0 };
        boolean[] bolsasLlenas = { false, false, false };
        int pisoActual = 5;
        int casasVisitadas = 0;

        final int MAXIMO_CARAMELOS = 20;
        final double PROBABILIDAD_CASA_ABIERTA = 0.7;
        final double PROBABILIDAD_DE_DAR_CARAMELOS = 0.8;
        final int MAXIMO_CARAMELOS_POR_CASA = 3;

        while (pisoActual >= 1) {
            System.out.println("=== Piso " + pisoActual + " ===");
            System.out.println("Presione Enter para continuar...");
            entrada.nextLine();

            for (int i = 1; i <= 4; i++) {
                casasVisitadas++;
                System.out.println("Visitando casa " + i);

                if (bolsasLlenas[0] && bolsasLlenas[1] && bolsasLlenas[2]) {
                    System.out.println("Ya no pedimos, pero seguimos bajando...");
                } else {
                    visitarCasa(bolsasLlenas, caramelos, MAXIMO_CARAMELOS, PROBABILIDAD_CASA_ABIERTA,
                            PROBABILIDAD_DE_DAR_CARAMELOS, MAXIMO_CARAMELOS_POR_CASA);
                }
            }

            pisoActual--;
        }

        mostrarResultados(casasVisitadas, caramelos, bolsasLlenas);
        entrada.close();
    }

    private static void visitarCasa(boolean[] bolsasLlenas, int[] caramelos, int maximoCaramelos,
            double probabilidadCasaAbierta, double probabilidadDeDarCaramelos, int maximoCaramelosPorCasa) {
        if (Math.random() <= probabilidadCasaAbierta) {
            System.out.println("Casa abierta!");

            if (Math.random() <= probabilidadDeDarCaramelos) {
                int caramelosRecibidos = (int) (Math.random() * maximoCaramelosPorCasa + 1);

                for (int i = 0; i < 3; i++) {
                    if (!bolsasLlenas[i]) {
                        int nuevoTotal = caramelos[i] + caramelosRecibidos;
                        caramelos[i] = Math.min(nuevoTotal, maximoCaramelos);
                        System.out.println("Niño " + (i + 1) + " recibe " + caramelosRecibidos + " caramelos");
                        if (caramelos[i] == maximoCaramelos) {
                            bolsasLlenas[i] = true;
                            System.out.println("Bolsa del niño " + (i + 1) + " llena!");
                        }
                    }
                }
            }
        } else {
            System.out.println("Casa cerrada... siguiente!");
        }
    }

    private static void mostrarResultados(int casasVisitadas, int[] caramelos, boolean[] bolsasLlenas) {
        System.out.println("=== Resultados Finales ===");
        System.out.println("Casas visitadas: " + casasVisitadas);
        for (int i = 0; i < 3; i++) {
            System.out.println(
                    "Niño " + (i + 1) + ": " + caramelos[i] + " caramelos" + (bolsasLlenas[i] ? " Bolsa llena" : ""));
        }
    }
}
