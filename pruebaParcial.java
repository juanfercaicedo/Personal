import java.util.Scanner;

public class pruebaParcial {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int c1 = 0, c2 = 0, c3 = 0;
        boolean b1 = false, b2 = false, b3 = false;
        int casasVisitadas = 0;
        int maxCaramelos = 20;
        final double PROBABILIDAD_CASA_ABIERTA = 0.7;
        final double PROBABILIDAD_TE_DEN_CARAMELOS = 0.8;

        int piso = 1;
        while (piso <= 5) {
            System.out.println("\n=== Piso " + piso + " ===");
            int casa = 1;
            while (casa <= 4) {
                casasVisitadas++;
                System.out.println("\nVisitando casa " + casa + " del piso " + piso);

                if (Math.random() < PROBABILIDAD_CASA_ABIERTA) {
                    System.out.println("¡La casa está abierta!");

                    if (!b1 && Math.random() < PROBABILIDAD_TE_DEN_CARAMELOS) {
                        int n1 = (int) (Math.random() * 3) + 1;
                        c1 += n1;
                        System.out.println("Niño 1 recibió " + n1 + " caramelos");
                        if (c1 >= maxCaramelos) {
                            b1 = true;
                            c1 = maxCaramelos;
                            System.out.println("¡La bolsa del niño 1 está llena!");
                        }
                    }

                    if (!b2 && Math.random() < PROBABILIDAD_TE_DEN_CARAMELOS) {
                        int n2 = (int) (Math.random() * 3) + 1;
                        c2 += n2;
                        System.out.println("Niño 2 recibió " + n2 + " caramelos");
                        if (c2 >= maxCaramelos) {
                            b2 = true;
                            c2 = maxCaramelos;
                            System.out.println("¡La bolsa del niño 2 está llena!");
                        }
                    }

                    if (!b3 && Math.random() < PROBABILIDAD_TE_DEN_CARAMELOS) {
                        int n3 = (int) (Math.random() * 3) + 1;
                        c3 += n3;
                        System.out.println("Niño 3 recibió " + n3 + " caramelos");
                        if (c3 >= maxCaramelos) {
                            b3 = true;
                            c3 = maxCaramelos;
                            System.out.println("¡La bolsa del niño 3 está llena!");
                        }
                    }

                } else {
                    System.out.println("Casa cerrada, seguimos adelante...");
                }

                System.out.println("Presiona enter para continuar");
                entrada.nextLine();

                if (b1 && b2 && b3) {
                    System.out.println("\n¡Todas las bolsas están llenas! Terminamos la búsqueda.");
                    break;
                }
                casa++;
            }

            if (b1 && b2 && b3)
                break;
            piso++;
        }

        System.out.println("\n=== Resultados Finales ===");
        System.out.println("Casas visitadas: " + casasVisitadas);
        System.out.println("Niño 1: " + c1 + " caramelos" + (b1 ? " (Bolsa llena)" : ""));
        System.out.println("Niño 2: " + c2 + " caramelos" + (b2 ? " (Bolsa llena)" : ""));
        System.out.println("Niño 3: " + c3 + " caramelos" + (b3 ? " (Bolsa llena)" : ""));

        entrada.close();
    }
}