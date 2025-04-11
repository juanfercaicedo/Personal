package Programacion2.Ejercicios.AdivinaElNumero;

public class Victoria {

    public void quienGana(int numeroUsuario, int numeroComputadora) {
        if (numeroUsuario == numeroComputadora) {
            System.out.println("Felicidades, ganaste.");
        } else {
            System.out.println("Perdiste.");
            System.out.println("El numero escogido por la computadora es: " + numeroComputadora);
        }
    }
}
