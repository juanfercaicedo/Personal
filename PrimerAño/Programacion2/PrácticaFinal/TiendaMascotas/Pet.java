public abstract class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name + " (" + getClass().getSimpleName() + ", " + age + " years old)";
    }
}
