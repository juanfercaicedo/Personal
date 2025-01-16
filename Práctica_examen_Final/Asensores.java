class Asensores {
    public static void main(String[] args) {
        final int PERSONAS_MAXIMAS = 6;
        final int PLANTA_TOTAL = 7;
        final int PLANTA_MINIMA = 0;
        final double PROBABILIDAD_LLEGADA_PERSONA = 0.3;
        final int NUMERO_ASCENSORES = 3;
        int piso;

        int[] plantaActual = new int[NUMERO_ASCENSORES];
        int[] personasEnAsensor = new int[PERSONAS_MAXIMAS];

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bienvenido al sistema de asensores de la Universidad Europea del Atlantico");
            for (piso = 0; piso < PLANTA_TOTAL; piso++) {
                if (Math.random() < PROBABILIDAD_LLEGADA_PERSONA) {
                    System.out.println("Una persona nueva se a subido al asensor en el piso #" + piso);
                } else {
                    System.out.println("No hay personas nuevas en el piso #" + piso);
                }
            }

        }
    }

}