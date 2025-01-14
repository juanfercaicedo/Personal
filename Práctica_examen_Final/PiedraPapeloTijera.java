import java.util.Scanner;

class PiedraPapeloTiejera {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int Piedra = 1;
        final int Papel = 2;
        final int Tijera = 3;
        int eleccioncomputadora = 0;
        int eleccionjugador = 0;
        int turnos = 0;
        final int turnosMaximos = 10;
        boolean jugando = true;

        System.out.println("Escoge 1 para Piedra, 2 Para papel o 3 para Tijera");

        while (turnos < turnosMaximos && jugando) {
            System.out.println("Estas en el intento #" + (turnos++));
            eleccionjugador = entrada.nextInt();
            eleccioncomputadora = (int) (Math.random() * 3) + 1;
            String empate = (eleccionjugador == eleccioncomputadora) ? "Empataste " : "Sigue intentando ";
            String resultado1 = (eleccionjugador == Piedra && eleccioncomputadora == Tijera) ? "Ganaste "
                    : "Sigue intentando ";
            String resultado2 = (eleccionjugador == Papel && eleccioncomputadora == Piedra) ? "Ganaste "
                    : "Sigue intentando ";
            String resultado3 = (eleccionjugador == Tijera && eleccioncomputadora == Papel) ? "Ganaste "
                    : "Sigue intentando ";
            System.out.println("Tu eleccion fue: " + eleccionjugador + " y la eleccion de la computadora fue: "
                    + eleccioncomputadora);
            System.out.printf(resultado1, resultado2, resultado3, empate);
        }

        entrada.close();
    }

}
