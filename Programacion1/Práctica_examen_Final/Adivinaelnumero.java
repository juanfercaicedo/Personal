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

            String MENSAJE_MAYOR_O_MENOR = (eleccionJugador > eleccionOrdenador)
                    ? "El número que has elegido mayor que el del ordenador"
                    : "El número escogido es menor que el del ordenador";
            System.out.println(MENSAJE_MAYOR_O_MENOR);

            String resultado = (eleccionJugador == eleccionOrdenador) ? "Haz ganado, felicidades"
                    : "No adivinaste, sigue intentando";
            System.out.println(resultado);
        }
        entrada.close();
    }

}