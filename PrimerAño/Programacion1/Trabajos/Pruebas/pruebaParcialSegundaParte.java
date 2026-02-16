public class pruebaParcialSegundaParte {
    public static void main(String[] args) {
        int cAna = 0, cBruno = 0, cCarmen = 0;
        boolean bAna = false, bBruno = false, bCarmen = false;
        int casasVisitadas = 0, casasQueDieronCaramelos = 0;
        int maxCaramelosAna = 15, maxCaramelosBruno = 25, maxCaramelosCarmen = 20;
        final double PROBABILIDAD_CASA_ABIERTA = 0.7;
        final double PROBABILIDAD_ANA = 0.6;
        final double PROBABILIDAD_BRUNO = 0.9;
        final double PROBABILIDAD_CARMEN = 0.8;

        int edificioMasGeneroso = 0, pisoMasGeneroso = 0;
        int maxCaramelosEdificio = 0, maxCaramelosPiso = 0;
        int totalCaramelos = 0;

        boolean todasBolsasLlenas = false;
        int edificio = 1;

        while (edificio <= 10 && !todasBolsasLlenas) {
            System.out.println("\n=== Edificio " + edificio + " ===");
            int caramelosEdificioActual = 0;
            int piso = 1;

            while (piso <= 5 && !todasBolsasLlenas) {
                System.out.println("\n=== Piso " + piso + " ===");
                int caramelosPisoActual = 0;
                int casa = 1;

                while (casa <= 4 && !todasBolsasLlenas) {
                    casasVisitadas++;
                    System.out.println("\nVisitando casa " + casa + " del piso " + piso);

                    if (Math.random() < PROBABILIDAD_CASA_ABIERTA) {
                        System.out.println("¡La casa está abierta!");
                        boolean casaDioCaramelos = false;

                        if (!bAna && Math.random() < PROBABILIDAD_ANA) {
                            int n1 = (int) (Math.random() * 2) + 1;
                            cAna = Math.min(cAna + n1, maxCaramelosAna);
                            caramelosEdificioActual += n1;
                            caramelosPisoActual += n1;
                            System.out.println("Ana recibió " + n1 + " caramelos");
                            bAna = cAna >= maxCaramelosAna;
                            System.out.println(bAna ? "¡La bolsa de Ana está llena!" : "");
                            casaDioCaramelos = true;
                        } else {
                            System.out.println("Ana no recibió caramelos");
                        }

                        if (!bBruno && Math.random() < PROBABILIDAD_BRUNO) {
                            int n2 = (int) (Math.random() * 3) + 2;
                            cBruno = Math.min(cBruno + n2, maxCaramelosBruno);
                            caramelosEdificioActual += n2;
                            caramelosPisoActual += n2;
                            System.out.println("Bruno recibió " + n2 + " caramelos");
                            bBruno = cBruno >= maxCaramelosBruno;
                            System.out.println(bBruno ? "¡La bolsa de Bruno está llena!" : "");
                            casaDioCaramelos = true;
                        } else {
                            System.out.println("Bruno no recibió caramelos");
                        }

                        if (!bCarmen && Math.random() < PROBABILIDAD_CARMEN) {
                            int n3 = (piso == 4 || piso == 5) ? 2 : 1;
                            cCarmen = Math.min(cCarmen + n3, maxCaramelosCarmen);
                            caramelosEdificioActual += n3;
                            caramelosPisoActual += n3;
                            System.out.println("Carmen recibió " + n3 + " caramelos");
                            bCarmen = cCarmen >= maxCaramelosCarmen;
                            System.out.println(bCarmen ? "¡La bolsa de Carmen está llena!" : "");
                            casaDioCaramelos = true;
                        } else {
                            System.out.println("Carmen no recibió caramelos");
                        }

                        casasQueDieronCaramelos += casaDioCaramelos ? 1 : 0;

                    } else {
                        System.out.println("Casa cerrada, seguimos adelante...");
                    }

                    todasBolsasLlenas = bAna && bBruno && bCarmen;
                    if (todasBolsasLlenas) {
                        System.out.println("\n¡Todas las bolsas están llenas! Terminamos la búsqueda.");
                    }
                    casa++;
                }

                if (caramelosPisoActual > maxCaramelosPiso) {
                    maxCaramelosPiso = caramelosPisoActual;
                    pisoMasGeneroso = piso;
                }
                piso++;
            }

            if (caramelosEdificioActual > maxCaramelosEdificio) {
                maxCaramelosEdificio = caramelosEdificioActual;
                edificioMasGeneroso = edificio;
            }

            totalCaramelos += caramelosEdificioActual;
            edificio++;

            System.out.println("\n=== Resultados Finales ===");
            System.out.println("Casas visitadas: " + casasVisitadas);
            System.out.println("Ana: " + cAna + " caramelos" + (bAna ? " (Bolsa llena)" : ""));
            System.out.println("Bruno: " + cBruno + " caramelos" + (bBruno ? " (Bolsa llena)" : ""));
            System.out.println("Carmen: " + cCarmen + " caramelos" + (bCarmen ? " (Bolsa llena)" : ""));

            int cantidadEdificios = 10;
            int promedioCaramelos = totalCaramelos / cantidadEdificios;

            System.out.println("\n=== Estadísticas ===");
            System.out.println("Total de caramelos recolectados: " + totalCaramelos);
            System.out.println("Cantidad de edificios: " + cantidadEdificios);
            System.out.println("Promedio de caramelos por edificio: " + promedioCaramelos);
            System.out.println("Edificio más generoso: " + edificioMasGeneroso);
            System.out.println("Piso que más caramelos dio: " + pisoMasGeneroso);

            int porcentajeCasas = (casasQueDieronCaramelos * 100) / casasVisitadas;
            System.out.println("Porcentaje de casas que dieron caramelos: " + porcentajeCasas + "%");
        }
    }
}