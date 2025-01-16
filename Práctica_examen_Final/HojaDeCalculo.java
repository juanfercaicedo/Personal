import java.util.Scanner;

public class HojaDeCalculo {
    public static void main(String[] args) {
        String[][] hojaCalculo = new String[15][10];
        int posicionFila = 0;
        int posicionColumna = 0;
        inicializarHoja(hojaCalculo);

        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            imprimirHoja(hojaCalculo, posicionFila, posicionColumna);
            System.out.println("Celda actual -> [" + obtenerNombreColumna(posicionColumna) + (posicionFila + 1) + "]");
            System.out.println("Utilice las teclas W, A, S y D para moverse.");
            System.out.println("Presione 'E' para ingresar texto en la celda actual.");
            System.out.println("Presione 'Q' para salir.");
            String comando = entrada.nextLine().toUpperCase();

            if (comando.equals("W")) {
                if (posicionFila > 0)
                    posicionFila--;
            } else if (comando.equals("S")) {
                if (posicionFila < 14)
                    posicionFila++;
            } else if (comando.equals("A")) {
                if (posicionColumna > 0)
                    posicionColumna--;
            } else if (comando.equals("D")) {
                if (posicionColumna < 9)
                    posicionColumna++;
            } else if (comando.equals("E")) {
                System.out.println("Ingrese el texto para la celda actual (máximo 7 caracteres):");
                String texto = entrada.nextLine();
                hojaCalculo[posicionFila][posicionColumna] = texto.length() > 7 ? cortarTexto(texto)
                        : rellenarConEspacios(texto, 7);
            } else if (comando.equals("Q")) {
                continuar = false;
            } else {
                System.out.println("Comando no reconocido.");
            }
        }

        entrada.close();
    }

    public static void inicializarHoja(String[][] hojaCalculo) {
        for (int fila = 0; fila < hojaCalculo.length; fila++) {
            for (int columna = 0; columna < hojaCalculo[fila].length; columna++) {
                hojaCalculo[fila][columna] = crearCadenaEspacios(7);
            }
        }
    }

    public static void imprimirHoja(String[][] hojaCalculo, int posicionFila, int posicionColumna) {
        System.out.println("  +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

        for (int fila = 0; fila < hojaCalculo.length; fila++) {
            String numeroFila = (fila + 1) < 10 ? " " + (fila + 1) : Integer.toString(fila + 1);
            System.out.print(numeroFila + "|");

            for (int columna = 0; columna < hojaCalculo[fila].length; columna++) {
                if (fila == posicionFila && columna == posicionColumna) {
                    System.out.print("[" + cortarTexto(hojaCalculo[fila][columna]) + "]|");
                } else {
                    System.out.print(" " + hojaCalculo[fila][columna] + " |");
                }
            }
            System.out.println();
        }

        System.out.print("   ");
        for (int indiceColumna = 0; indiceColumna < 10; indiceColumna++) {
            String letraColumna = obtenerNombreColumna(indiceColumna);
            System.out.print("   " + letraColumna + "   ");
        }
        System.out.println();
    }

    public static String obtenerNombreColumna(int indiceColumna) {
        String[] letrasColumnas = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        return letrasColumnas[indiceColumna];
    }

    public static String cortarTexto(String texto) {
        String textoCortado = "";
        for (int i = 0; i < 7 && i < texto.length(); i++) {
            textoCortado = textoCortado + texto.charAt(i);
        }
        return textoCortado;
    }

    public static String rellenarConEspacios(String texto, int longitud) {
        while (texto.length() < longitud) {
            texto = texto + " ";
        }
        return texto;
    }

    public static String crearCadenaEspacios(int longitud) {
        String espacios = "";
        for (int i = 0; i < longitud; i++) {
            espacios = espacios + " ";
        }
        return espacios;
    }
}
