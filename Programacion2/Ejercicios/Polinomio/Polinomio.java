package Programacion2.Ejercicios.Polinomio;

public class Polinomio {

    private final IngresarEcuacion ingresarEcuacion;
    public final Derivada derivada;
    private final Operaciones operaciones;
    private final GradoPolinomio gradoPolinomio;
    private final EstructuraPolinomio estructuraPolinomio;
    private final EstructuraCorrecta estructuraCorrecta;

    public Polinomio() {
        ingresarEcuacion = new IngresarEcuacion();
        derivada = new Derivada();
        operaciones = new Operaciones();
        gradoPolinomio = new GradoPolinomio();
        estructuraPolinomio = new EstructuraPolinomio();
        estructuraCorrecta = new EstructuraCorrecta();
    }

    public void iniciar() {
        int grado = gradoPolinomio.ingresarGrado();
        String[] mostrarPolinomio = estructuraPolinomio.mostrarPolinomio(grado);
        String[] ecuacionUsuario = ingresarEcuacion.nuevaEcuacion(mostrarPolinomio);
        String[] resultadoValidacion = estructuraCorrecta.estructuraValida(ecuacionUsuario, mostrarPolinomio);
        double[] pasear = operaciones.parsear(resultadoValidacion);
        double[] suma = operaciones.sumaDePolinomio(pasear);
    }
}
