package HW6;

public class Dog extends Animal{
    private static int dogCount;
    private String name;
    public static final int STAMINARUN = 500;
    public static final int STAMINASWIM = 10;

    public Dog(String name, String color, int weight) {
        super(color, weight);
        this.name = name;
        dogCount++;
    }

    @Override
    public void run(int metres) {
        if (metres<STAMINARUN) System.out.println(name + " пробежал "+ metres+" м.");
        else System.out.println(name + " пробежал "+ STAMINARUN+" метров и устал");
    }

    @Override
    public void voice() {
        System.out.println("Гав");
    }

    public void swim(int metres){
        if (metres < STAMINASWIM) System.out.println(name + " проплыл "+ metres+" м.");
        else System.out.println(name + " проплыл "+ STAMINASWIM+" м. и утонул.");
    }

    public static void showDogs(){
        System.out.println("создано собак:"+dogCount);
    }
}
