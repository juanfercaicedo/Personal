import java.util.Scanner;

class ElViajeDeMarco {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final double VELOCIDAD_MINIMA = 10;
        final double VELOCIDAD_MAXIMA = 15;
        final double TIEMPO_DE_TRAYECTO_MINIMO = 8;
        final double TIEMPO_DE_TRAYECTO_MAXIMO = 10;
        final double PROBABILIDAD_LLUVIA_FUERTE = 0.1;
        final double PROBABILIDAD_LLUVIA_NORMAL = 0.4;
        final double PROBABILIDAD_MONO_SE_ESCAPE = 0.15;
        final double PROBABILIDAD_MONO_SE_CANSA = 0.25;
        final double TIEMPO_PERDIDO_POR_ESCAPE_MONO = 2;
        final double TIEMPO_NO_PERDIDO_POR_NO_ESCAPE_DE_MONO = 0;
        final double REDUCCION_VELOCIDAD_POR_CANSANCIO_MONO = 0.9;
        final double VELOCIDAD_SIN_REDUCCION = 1;
        final double REDUCCION_AVANCE_POR_LLUVIA_FUERTE = 0.25;
        final double REDUCCION_AVANCE_POR_LLUVIA_NORMAL = 0.75;
        final double AVANCE_SIN_LLUVIA = 1;

        double probabilidadLluvia;
        double velocidadMarco, avanceMarco, tiempoMarco;
        double distanciaMarcoMadre = 350;
        boolean seHanEncontrado = false;
        int dias = 0;

        probabilidadLluvia = Math.random();

        while (!seHanEncontrado) {
            dias++;
            velocidadMarco = Math.random() * (VELOCIDAD_MAXIMA - VELOCIDAD_MINIMA) + VELOCIDAD_MINIMA;
            tiempoMarco = Math.random() * (TIEMPO_DE_TRAYECTO_MAXIMO - TIEMPO_DE_TRAYECTO_MINIMO)
                    + TIEMPO_DE_TRAYECTO_MINIMO;
            probabilidadLluvia = probabilidadLluvia <= PROBABILIDAD_LLUVIA_FUERTE ? REDUCCION_AVANCE_POR_LLUVIA_FUERTE
                    : probabilidadLluvia <= PROBABILIDAD_LLUVIA_NORMAL ? REDUCCION_AVANCE_POR_LLUVIA_NORMAL
                            : AVANCE_SIN_LLUVIA;
            String estadoClima = probabilidadLluvia <= PROBABILIDAD_LLUVIA_FUERTE ? "Lluvia Fuerte"
                    : probabilidadLluvia <= PROBABILIDAD_LLUVIA_NORMAL ? "Lluvia Normal" : "No esta lloviendo";

            double probabilidadMonoSeCansa = Math.random();
            double correcionMono = probabilidadMonoSeCansa <= PROBABILIDAD_MONO_SE_CANSA
                    ? REDUCCION_VELOCIDAD_POR_CANSANCIO_MONO
                    : VELOCIDAD_SIN_REDUCCION;
            String correcionPorMono = correcionMono <= REDUCCION_VELOCIDAD_POR_CANSANCIO_MONO ? "El mono se cansa"
                    : "El mono no se cansa";

            double probabilidadMonoSeEscapa = Math.random();
            double correcionTiempoPorMono = probabilidadMonoSeEscapa <= PROBABILIDAD_MONO_SE_ESCAPE
                    ? TIEMPO_PERDIDO_POR_ESCAPE_MONO
                    : TIEMPO_NO_PERDIDO_POR_NO_ESCAPE_DE_MONO;
            String descripcionCorrecionTiempoPorMono = probabilidadMonoSeEscapa <= PROBABILIDAD_MONO_SE_ESCAPE
                    ? "El mono se escapo"
                    : "El mono no se escapo";

            double AVANCE_MADRE = 80;
            avanceMarco = (velocidadMarco * probabilidadLluvia * correcionMono)
                    * (tiempoMarco - correcionTiempoPorMono);
            distanciaMarcoMadre = distanciaMarcoMadre - avanceMarco + AVANCE_MADRE;

            if (distanciaMarcoMadre <= 0) {
                System.out.println("Se han encontrado despues de " + dias + "dias");
                break;
            } else if (distanciaMarcoMadre > 0) {
                System.out.println("DIA NUMERO: " + dias);
                System.out.println("La distancia entre Marco y su madre es de: " + distanciaMarcoMadre + " km");
                System.out.println(estadoClima);
                System.out.println(correcionPorMono);
                System.out.println(descripcionCorrecionTiempoPorMono);
                System.out.println("El avance fue de Marco fue de: " + avanceMarco);
                System.out.println(!seHanEncontrado ? "Aun no" : "Ya se encontraron!!!");
                System.out.println("=======================");
                entrada.nextLine();
            }

        }
        System.out.println("Se han encontrado despues de " + dias + "dias");
        entrada.close();

    }

}
