import java.util.Scanner;

class AdivinaelNumero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int NUMERO_MINIMO = 0;
        int NUMERO_MAXIMO = 100;
        int eleccionJugador;
        int turnos = 0;
        final int turnosMaximos = 15;
        boolean adivinado = false;

        int eleccionOrdenador = (int) (Math.random() * (NUMERO_MAXIMO - NUMERO_MINIMO + 1)) + NUMERO_MINIMO;

        System.out.println("Adivina el numero, escoge un numero entre " + NUMERO_MINIMO + " y " + NUMERO_MAXIMO++);

        while (turnos < turnosMaximos && !adivinado) {
            System.out.println("Estás en el intento #" + (turnos++));
            eleccionJugador = entrada.nextInt();

            if (eleccionJugador == eleccionOrdenador) {
                System.out.println("Ganaste, tu elección fue: " + eleccionJugador + " y el ordenador eligio: "
                        + eleccionOrdenador);
            } else {
                System.out.println("Perdiste, el número del ordenador era " + eleccionOrdenador);
            }

            if (eleccionJugador < eleccionOrdenador) {
                System.out.println("Tu número es muy bajo");
            } else {
                System.out.println("Tu número es muy alto");
            }
        }
    }

}