import java.util.ArrayList;

public class PetStore {
    private final String name;
    private final ArrayList<Pet> pets;

    public PetStore(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        System.out.println("Added " + pet);
    }

    public void listPets() {
        System.out.println("\nAvailable pets in " + name + ":");
        if (pets.isEmpty()) {
            System.out.println("No pets available.");
        } else {
            for (Pet pet : pets) {
                System.out.println("- " + pet);
            }
        }
    }

    public void sellPet(String petName) {
        Pet petToSell = null;
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                petToSell = pet;
                break;
            }
        }
        if (petToSell != null) {
            pets.remove(petToSell);
            System.out.println("Sold " + petToSell);
        } else {
            System.out.println("Pet not found: " + petName);
        }
    }
}
