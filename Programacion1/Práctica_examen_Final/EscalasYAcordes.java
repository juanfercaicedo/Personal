
import java.util.Arrays;
import java.util.Scanner;

class EscalasYAcordes {

    private static final int SEMITONE = 1;
    private static final int TONE = SEMITONE * 2;
    private static final int HALF_TONE = TONE + SEMITONE;
    private static final String[] NOTES = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#",
        "Si"};
    private static final int[][] SCALES = {
        {TONE, TONE, SEMITONE, TONE, TONE, TONE, SEMITONE},
        {TONE, SEMITONE, TONE, TONE, SEMITONE, TONE, TONE},
        {TONE, SEMITONE, TONE, TONE, SEMITONE, HALF_TONE, SEMITONE},
        {TONE, SEMITONE, TONE, TONE, TONE, TONE, SEMITONE},
        {TONE, TONE, HALF_TONE, TONE, HALF_TONE},
        {HALF_TONE, TONE, TONE, HALF_TONE, TONE},
        {TONE, SEMITONE, TONE, TONE, TONE, SEMITONE, TONE},
        {SEMITONE, TONE, TONE, TONE, SEMITONE, TONE, TONE},
        {TONE, TONE, TONE, SEMITONE, TONE, TONE, SEMITONE},
        {TONE, TONE, SEMITONE, TONE, TONE, SEMITONE, TONE},
        {SEMITONE, TONE, TONE, SEMITONE, TONE, TONE, TONE},
        {TONE, TONE, TONE, TONE, TONE, TONE}
    };

    private static String[] NAMES = {
        "Mayor",
        "Menor natural",
        "Menor Armónica",
        "Menor Melódica",
        "Pentatónica Mayor",
        "Pentatónica Menor",
        "Dórica",
        "Frigia",
        "Lidia",
        "Mixolidia",
        "Locria",
        "Por tonos"
    };

    public static void main(String[] args) {
        getUserChoice(NOTES, NAMES, SCALES);
        impression(getUserChoice());

    }

    static void getUserChoice(String[] notes, String[] names, int[][] scales) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija una escala con numeros: " + Arrays.toString(NAMES));
        int userChoice = scanner.nextInt();
        String scaleName = NAMES[userChoice];

        scanner.close();
    }

}
