import java.util.Scanner;

class ClasificacionEdades {
    public static void main(String[] args) {
        final int EDAD_MINIMA = 0;
        final int PRIMERA_INFANCIA = 5;
        final int INFANCIA = 11;
        final int ADOLESCENCIA = 18;
        final int JUVENTUD = 26;
        final int ADULTEZ = 59;
        final int EDAD_MAXIMA = 100;

        final String PRIMERA_INFANCIA_DESCRIPTOR = "Primera Infancia";
        final String INFANCIA_DESCRIPTOR = "Infancia";
        final String ADOLESCENCIA_DESCRIPTOR = "Adolescencia";
        final String JUVENTUD_DESCRIPTOR = "Juventud";
        final String ADULTEZ_DESCRIPTOR = "Adultez";
        final String PERSONA_MAYOR_DESCRIPTOR = "Persona Mayor";
        final String EDAD_INVALIDA = "Edad invalida";

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce una edad entre el 0 y 100 años");
        int edadUsuario = entrada.nextInt();

        String resultadoEdad;
        if (edadUsuario >= EDAD_MINIMA && edadUsuario <= EDAD_MAXIMA) {
            if (edadUsuario <= PRIMERA_INFANCIA) {
                resultadoEdad = PRIMERA_INFANCIA_DESCRIPTOR;
            } else if (edadUsuario <= INFANCIA) {
                resultadoEdad = INFANCIA_DESCRIPTOR;
            } else if (edadUsuario <= ADOLESCENCIA) {
                resultadoEdad = ADOLESCENCIA_DESCRIPTOR;
            } else if (edadUsuario <= JUVENTUD) {
                resultadoEdad = JUVENTUD_DESCRIPTOR;
            } else if (edadUsuario <= ADULTEZ) {
                resultadoEdad = ADULTEZ_DESCRIPTOR;
            } else {
                resultadoEdad = PERSONA_MAYOR_DESCRIPTOR;
            }
        } else {
            resultadoEdad = EDAD_INVALIDA;
        }

        System.out.println("La clasificacion de la edad es: " + resultadoEdad);

        entrada.close();
    }
}
