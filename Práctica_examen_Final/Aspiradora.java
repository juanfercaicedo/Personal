public class Aspiradora {
    public static void main(String[] args) {

        int[][] superficie = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        int posicionAspiradora[] = { 0, 0 };
        ensuciar(superficie);
        boolean superfieEstaSucia = true;

        while (superfieEstaSucia) {
            moverAspiradora(posicionAspiradora, superficie);
            limpiarMundo(superficie, posicionAspiradora);
            imprimirMundo(superficie, posicionAspiradora);
            superfieEstaSucia = superfieEstaSucia(superficie);
            pause(0.5);
        }
    }

    static void moverAspiradora(int[] posicionAspiradora, int[][] superficie) {

        int[] posicionPrevia = new int[] { posicionAspiradora[0], posicionAspiradora[1] };

        int[][] direcciones = {
                { -1, 1 }, { 0, 1 }, { 1, 1 },
                { -1, 0 }, { 0, 0 }, { 1, 0 },
                { -1, -1 }, { 0, -1 }, { 1, -1 }
        };

        int[] movimiento = direcciones[(int) (Math.random() * direcciones.length)];
        posicionAspiradora[0] = posicionAspiradora[0] + movimiento[0];
        posicionAspiradora[1] = posicionAspiradora[1] + movimiento[1];

        if (posicionInvalida(posicionAspiradora, superficie)) {
            posicionAspiradora[0] = posicionPrevia[0];
            posicionAspiradora[1] = posicionPrevia[1];
        }
    }

    static boolean posicionInvalida(int[] position, int[][] surface) {
        return position[0] < 0 || position[0] >= surface.length ||
                position[1] < 0 || position[1] >= surface[0].length;
    }

    static void limpiarMundo(int[][] superficie, int[] posicionAspiradora) {
        if (superficie[posicionAspiradora[0]][posicionAspiradora[1]] > 0) {
            superficie[posicionAspiradora[0]][posicionAspiradora[1]]--;
        }
    }

    static boolean superfieEstaSucia(int[][] superficie) {
        return true;
    }

    static void imprimirMundo(int[][] unMapa, int[] posicionAspiradora) {
        limpiarPantalla();
        System.out.println("---".repeat(unMapa[0].length));
        for (int row = 0; row < unMapa.length; row++) {
            for (int column = 0; column < unMapa[row].length; column++) {
                if (posicionAspiradora[0] == row && posicionAspiradora[1] == column) {
                    System.out.println(mapaAspiradora());
                } else {
                    System.out.print(mapValueToTitle(unMapa[row][column]));
                }
            }
            System.out.println();
        }
        System.out.println("---".repeat(unMapa[0].length));
    }

    static String mapaAspiradora() {
        return ("0");
    }

    static String mapValueToTitle(int value) {
        String[] tiles = { " . ", "...", "ooo", "OOO", "***" };
        return tiles[value];
    }

    static void ensuciar(int[][] unMapa) {
        for (int row = 0; row < unMapa.length; row++) {
            for (int column = 0; column < unMapa[row].length; column++) {
                unMapa[row][column] = (int) (Math.random() * 5);
            }
        }
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(double seconds) {
        try {
            Thread.sleep((int) (1000 * seconds));
        } catch (InterruptedException e) {

        }
    }
}
