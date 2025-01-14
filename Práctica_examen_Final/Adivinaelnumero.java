import java.util.Scanner;

class AdivinaelNumero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int NUMERO_MINIMO = 0, NUMERO_MAXIMO = 100;
        int eleccionJugador;
        int eleccionOrdenador = (int) (Math.random() * (NUMERO_MAXIMO - NUMERO_MINIMO + 1)) + NUMERO_MINIMO;

        System.out.println("Adivina el numero, escoge un numero entre " + NUMERO_MINIMO + " y " + NUMERO_MAXIMO++);
        eleccionJugador = entrada.nextInt();
        entrada.close();

        while (true) {
            if (eleccionJugador == eleccionOrdenador) {
                System.out.println("Ganaste, tu elección fue: " + eleccionJugador + " y el ordenador eligio: "
                        + eleccionOrdenador);
            } else {
                System.out.println("Perdiste, el número del ordenador era " + eleccionOrdenador);
            }
        }
    }

}