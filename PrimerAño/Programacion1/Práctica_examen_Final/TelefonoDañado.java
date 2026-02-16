import java.util.Scanner;

class TelefonoDañado {
    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 120;
        final int NIÑOS_MINIMOS = 5;
        final double PROBABILIDAD_LLEGADA_NIÑOS = 0.3;
        final int LIMITE_TIEMPO_LLEGADA = 40;

        int lydia = 0;
        int aisha = 0;
        boolean estaJugando = false;
        String elMensaje = "";
        int turnoNiño = 0;

        Scanner scanner = new Scanner(System.in);

        for (int minuto = 0; minuto <= TIEMPO_TOTAL; minuto++) {
            limpiarPantalla();
            System.out.println("=".repeat(30));
            System.out.println("Ludoteca - minuto " + minuto);

            if (Math.random() < PROBABILIDAD_LLEGADA_NIÑOS && minuto < LIMITE_TIEMPO_LLEGADA) {
                lydia++;
            }

            if (!estaJugando) {
                aisha = aisha + lydia;
                lydia = 0;
                mostrarCola("Lydia", lydia);
                mostrarCola("Aisha", aisha);
            } else {
                mostrarCola("Lydia", lydia);
                mostrarCola("Aisha", aisha, turnoNiño);
            }

            if (aisha >= NIÑOS_MINIMOS && !estaJugando) {
                estaJugando = true;
                elMensaje = "Me gusta la clase de programación";
                System.out.println("Aisha empieza a jugar pasando este mensaje: " + elMensaje);
                turnoNiño = 1;
            } else if (estaJugando) {
                System.out.println("🗨️: " + elMensaje);
                elMensaje = alterarMensaje(elMensaje);
                turnoNiño++;
                estaJugando = turnoNiño <= aisha;
            }

            System.out.println("Presiona enter para continuar");
            scanner.nextLine();
        }

        scanner.close();
    }

    static String alterarMensaje(String elMensaje) {
        return elMensaje + "X";
    }

    static void mostrarCola(String responsable, int numeroDeNiños) {
        mostrarCola(responsable, numeroDeNiños, 0);
    }

    static void mostrarCola(String responsable, int numeroDeNiños, int turnoNiño) {
        final String NIÑOS = "🧒";
        final String HABLANTE = "🗨️ ";

        String cola = turnoNiño > 0
                ? NIÑOS.repeat(turnoNiño - 1) + HABLANTE + NIÑOS.repeat(numeroDeNiños - turnoNiño)
                : NIÑOS.repeat(numeroDeNiños);
        System.out.println(responsable + " > " + cola);
        System.out.println("-".repeat(30));
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
