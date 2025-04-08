package Práctica;

import java.util.Scanner;

class AcordesYEscalas {
    public static void main(String[] args) {
        String note = userChoice();
        majorScale(note);
        majorChord(note);
        impression(note);
    }

    static String userChoice() {
        System.out.println("Elige una nota, 1 Do, 2 Do#, etc...");
        String notes[] = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        Scanner entry = new Scanner(System.in);
        int choice = entry.nextInt();
        entry.close();
        return notes[choice - 1];
    }

    static void majorScale(String note) {
        final int MAX_NOTES = 12;
        final int TONE_MOVEMENT = 2;
        final int SEMITONE_MOVEMENT = 1;
        String notes[] = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

        int choice = 0;

        for (int i = 0; i < MAX_NOTES; i++) {
            if (notes[i].equals(note)) {
                choice = i;
            }
        }

        System.out.println("Major scale: ");
        for (int i = 0; i < 7; i++) {
            System.out.println(notes[choice]);
            choice = (choice + TONE_MOVEMENT) % MAX_NOTES;
        }
    }

    static void majorChord(String note) {
        // implement major chord generation here
    }

    static void impression(String note) {
        // implement impression generation here
    }
}