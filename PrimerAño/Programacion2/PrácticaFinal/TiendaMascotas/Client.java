public class Client {
    public static void main(String[] args) {
        PetStore petStore = new PetStore("Happy Pets");

        petStore.addPet(new Dog("Max", 3));
        petStore.addPet(new Cat("Luna", 2));
        petStore.addPet(new Dog("Rex", 5));

        petStore.listPets();
        petStore.sellPet("Luna");
        petStore.listPets();
    }
}
