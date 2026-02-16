import java.util.Scanner;

class HalloweenParte2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int TOTAL_EDIFICIOS = 10;
        final int PISOS_POR_EDIFICIO = 5;
        final int CASAS_POR_PISO = 4;

        final int BOLSA_ANA = 15;
        final int BOLSA_BRUNO = 25;
        final int BOLSA_CARMEN = 20;

        final double PROBABILIDAD_ANA = 0.6;
        final double PROBABILIDAD_BRUNO = 0.9;
        final double PROBABILIDAD_CARMEN = 0.8;

        final int MIN_CARAMELLOS_ANA = 1, MAX_CARAMELLOS_ANA = 2;
        final int MIN_CARAMELLOS_BRUNO = 2, MAX_CARAMELLOS_BRUNO = 4;
        final int MIN_CARAMELLOS_CARMEN = 1, MAX_CARAMELLOS_CARMEN = 3;

        int caramelosAna = 0, caramelosBruno = 0, caramelosCarmen = 0;
        boolean bolsaLlenaAna = false, bolsaLlenaBruno = false, bolsaLlenaCarmen = false;

        int totalCaramelosEdificio;
        int totalCasasConCaramelos = 0;
        int pisoMasGeneroso = 0, maxCaramelosPiso = 0;
        int edificioMasGeneroso = 0, maxCaramelosEdificio = 0;

        for (int edificio = 1; edificio <= TOTAL_EDIFICIOS; edificio++) {
            totalCaramelosEdificio = 0;

            System.out.println("=== Edificio " + edificio + " ===");
            for (int piso = PISOS_POR_EDIFICIO; piso >= 1; piso--) {
                int caramelosPiso = 0;

                System.out.println("=== Piso " + piso + " ===");
                System.out.println("Presione Enter para continuar...");
                entrada.nextLine();

                for (int casa = 1; casa <= CASAS_POR_PISO; casa++) {
                    System.out.println("Visitando casa " + casa + " del piso " + piso);

                    if (Math.random() <= PROBABILIDAD_ANA && !bolsaLlenaAna) {
                        int caramelosRecibidos = (int) (Math.random() * (MAX_CARAMELLOS_ANA - MIN_CARAMELLOS_ANA + 1))
                                + MIN_CARAMELLOS_ANA;
                        caramelosAna = Math.min(caramelosAna + caramelosRecibidos, BOLSA_ANA);
                        if (caramelosAna == BOLSA_ANA)
                            bolsaLlenaAna = true;
                        caramelosPiso = caramelosPiso + caramelosRecibidos;
                        totalCasasConCaramelos++;
                    }

                    if (Math.random() <= PROBABILIDAD_BRUNO && !bolsaLlenaBruno) {
                        int caramelosRecibidos = (int) (Math.random()
                                * (MAX_CARAMELLOS_BRUNO - MIN_CARAMELLOS_BRUNO + 1)) + MIN_CARAMELLOS_BRUNO;
                        caramelosBruno = Math.min(caramelosBruno + caramelosRecibidos, BOLSA_BRUNO);
                        if (caramelosBruno == BOLSA_BRUNO)
                            bolsaLlenaBruno = true;
                        caramelosPiso = caramelosPiso + caramelosRecibidos;
                        totalCasasConCaramelos++;
                    }

                    if (Math.random() <= PROBABILIDAD_CARMEN && !bolsaLlenaCarmen) {
                        int caramelosRecibidos = (int) (Math.random()
                                * (MAX_CARAMELLOS_CARMEN - MIN_CARAMELLOS_CARMEN + 1)) + MIN_CARAMELLOS_CARMEN;
                        if (piso == 4 || piso == 5)
                            caramelosRecibidos++;
                        caramelosCarmen = Math.min(caramelosCarmen + caramelosRecibidos, BOLSA_CARMEN);
                        if (caramelosCarmen == BOLSA_CARMEN)
                            bolsaLlenaCarmen = true;
                        caramelosPiso = caramelosPiso + caramelosRecibidos;
                        totalCasasConCaramelos++;
                    }
                }

                totalCaramelosEdificio = totalCaramelosEdificio + caramelosPiso;
                if (caramelosPiso > maxCaramelosPiso) {
                    maxCaramelosPiso = caramelosPiso;
                    pisoMasGeneroso = piso;
                }
            }

            if (totalCaramelosEdificio > maxCaramelosEdificio) {
                maxCaramelosEdificio = totalCaramelosEdificio;
                edificioMasGeneroso = edificio;
            }

            System.out.println("Caramelos en edificio " + edificio + ": " + totalCaramelosEdificio);
        }

        double porcentajeCasasConCaramelos = (double) totalCasasConCaramelos
                / (TOTAL_EDIFICIOS * PISOS_POR_EDIFICIO * CASAS_POR_PISO) * 100;

        System.out.println("=== Resultados Finales ===");
        System.out.println("Ana: " + caramelosAna + " caramelos" + (bolsaLlenaAna ? " (Bolsa llena)" : ""));
        System.out.println("Bruno: " + caramelosBruno + " caramelos" + (bolsaLlenaBruno ? " (Bolsa llena)" : ""));
        System.out.println("Carmen: " + caramelosCarmen + " caramelos" + (bolsaLlenaCarmen ? " (Bolsa llena)" : ""));
        System.out.println("Promedio de caramelos por edificio: " + (maxCaramelosEdificio / (double) TOTAL_EDIFICIOS));
        System.out.println(
                "Edificio más generoso: " + edificioMasGeneroso + " con " + maxCaramelosEdificio + " caramelos");
        System.out.println("Piso más generoso: " + pisoMasGeneroso + " con " + maxCaramelosPiso + " caramelos");
        System.out.println("Porcentaje de casas que dieron caramelos: " + porcentajeCasasConCaramelos + "%");
        entrada.close();
    }
}
