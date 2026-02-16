package Programacion2.Ejercicios.AdivinaElNumero;

public class AdivinaElNumero {

    private final EleccionComputadora eleccionComputadora;
    private final EleccionUsuario eleccionUsuario;
    private final Victoria victoria;

    public AdivinaElNumero() {
        eleccionComputadora = new EleccionComputadora();
        eleccionUsuario = new EleccionUsuario();
        victoria = new Victoria();
    }

    public void jugar() {
        int numeroComputadora = eleccionComputadora.numeroAleatorio();
        int numeroUsuario = eleccionUsuario.numeroEscogido();
        victoria.quienGana(numeroUsuario, numeroComputadora);
    }
}
