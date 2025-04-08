import java.util.Scanner;

class Mercadona {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int HORAS_ABIERTO = 12;
        final int MINUTOS_POR_HORA = 40;
        final int TIEMPO_TOTAL = HORAS_ABIERTO * MINUTOS_POR_HORA;
        final double PROBABILIDAD_LLEGADA_CLIENTE = 0.6;
        final int PRODUCTOS_MINIMOS = 5, PRODUCTOS_MAXIMOS = 10;
        final String PERSONA = "_O_ ", PRODUCTO = "[]";
        int unaFila = 0;
        int minutosCajaVacia = 0;
        int caja1 = 0, caja2 = 0, caja3 = 0, caja4 = 0;
        int horas = 9, minutos = 0;

        for (int tiempoActual = 1; tiempoActual <= TIEMPO_TOTAL; tiempoActual++) {
            minutos++;
            minutos = (minutos >= 60) ? 0 : minutos;
            horas += (minutos >= 60) ? 1 : 0;

            int llegaClienteNuevo = Math.random() <= PROBABILIDAD_LLEGADA_CLIENTE ? 1 : 0;
            unaFila = unaFila + llegaClienteNuevo;

            int[] cajas = { caja1, caja2, caja3, caja4 };

            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i] <= 0 && unaFila > 0) {
                    unaFila--;
                    cajas[i] = (int) (Math.random() * (PRODUCTOS_MAXIMOS - PRODUCTOS_MINIMOS) + PRODUCTOS_MINIMOS);
                }
            }

            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i] > 0) {
                    cajas[i] -= 1;
                }
            }

            caja1 = cajas[0];
            caja2 = cajas[1];
            caja3 = cajas[2];
            caja4 = cajas[3];

            minutosCajaVacia = minutosCajaVacia + ((unaFila == 0 && llegaClienteNuevo == 0) ? 1 : 0);

            System.out.println("Tiempo: [" + horas + "]:[" + minutos + "]");
            System.out.println((llegaClienteNuevo > 0 ? "   ===>" : "       ") + PERSONA.repeat(unaFila));
            System.out.println("CAJA 1 " + PRODUCTO.repeat(caja1));
            System.out.println("CAJA 2 " + PRODUCTO.repeat(caja2));
            System.out.println("CAJA 3 " + PRODUCTO.repeat(caja3));
            System.out.println("CAJA 4 " + PRODUCTO.repeat(caja4));
            System.out.println("---------------------------------------------");
            for (int i = 0; i < 1000000000; i++) {
            }
        }
        System.out.println("Al final de la jornada, la fila ha estado " + minutosCajaVacia + " minutos vacia");
        System.out.println("y quedan " + unaFila + " personas esperando");

        entrada.close();
    }
}
