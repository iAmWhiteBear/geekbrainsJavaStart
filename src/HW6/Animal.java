package HW6;

public abstract class Animal {
    private static int animalCount;
    private int weight;
    private String color;

    public Animal(String color, int weight) {
        this.weight = weight;
        this.color = color;
        animalCount++;
    }

    public abstract void run(int metres);
    public abstract void swim(int metres);
    public abstract void voice();
    public int getWeight() {return weight;}
    public String getColor() {return color;}

    public static void showAnimals(){
        System.out.println("total animals: "+animalCount);
    }
}
