package Programacion2.Ejercicios.AdivinaElNumero;

import java.util.Random;

public class EleccionComputadora {

    static Random random = new Random();
    public int eleccionComputadora;

    public int numeroAleatorio() {
        eleccionComputadora = random.nextInt(1, 101);
        return eleccionComputadora;
    }
}
