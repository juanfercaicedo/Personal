public class Aspiradora {
    public static void main(String[] args) {
        final int SUPERFICIE_LIMPIA = 0;
        final int SUPERFICIE_SUCIA = 1;
        final int SUPERFICIE_MUY_SUCIA = 2;
        final int SUPERFICIE_MUY_MUY_SUCIA = 3;
        final int SUPERFICIE_EXTREMADAMENTE_SUCIA = 4;
        final int EJE_X = 0;
        final int EJE_Y = 1;

        int[][] superficie = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        int posicionAspiradora[] = { 0, 0 };
        ensuciar(superficie);
        boolean superfieEstaSucia = true;

        while (superfieEstaSucia) {
            moverAspiradora(posicionAspiradora, superficie);
            limpiarMundo(superficie, posicionAspiradora);
            imprimirMundo(superficie, posicionAspiradora);
            superfieEstaSucia = estaSucia(superficie);
            pause(0.5);
        }
    }

    static void moverAspiradora(int[] posicionAspiradora, int[][] superficie){

        int posicionPrevia = new int[] {posicionAspiradora[0], posicionAspiradora[1]};

        int direcciones = {
            { -1, 1 }, { 0, 1 }, { 1, 1 },
            { -1, 0 }, { 0, 0 }, { 1, 0 },
            { -1, -1 }, { 0, -1 }, { 1, -1 }
        };

        int movimiento = direcciones[(int)*(Math.random()*direcciones.lenght)];
        posicionAspiradora[0] = posicionAspiradora[0] + movimiento[0];
        posicionAspiradora[1] = posicionAspiradora[1] + movimiento[1];

        if(posicionInvalida(posicionAspiradora, superficie)){
            posicionAspiradora[0] = posicionPrevia[0];
            posicionAspiradora[1] = posicionPrevia[1];
        }
    }

    static boolean posicionInvalida(int[] posicionAspiradora, int[][] superficie) {
        return posicionAspiradora[0] < 0 || posicionAspiradora[0] >= superficie.lenght || posicionAspiradora[1] < 0
                || posicionAspiradora >= superficie.length;
    }

    static void limpiarMundo(int[][] superficie, int[] posicionAspiradora) {
        if (superficie[posicionAspiradora[0]][posicionAspiradora[1]] > 0) {
            superficie[posicionAspiradora[0]][posicionAspiradora[1]]--;
        }
    }
}
