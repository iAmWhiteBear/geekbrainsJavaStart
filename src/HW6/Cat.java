package HW6;

public class Cat extends Animal{
    private static int catCount;
    private String name;
    public static final int STAMINA = 200;

    public Cat(String name, String color, int weight) {
        super(color,weight);
        this.name = name;
        catCount++;
    }

    @Override
    public void run(int metres) {
        if (metres<STAMINA) System.out.println(name + " пробежал "+ metres+" м.");
        else System.out.println(name + " пробежал "+ STAMINA+" метров и устал");
    }

    @Override
    public void swim(int metres) {
        System.out.println(name +" отказался плыть");
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    public static void showCats(){
        System.out.println("создано котов: "+catCount);
    }
}
