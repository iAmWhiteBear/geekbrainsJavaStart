package HW7;

public class MyCat implements SimpleCat {
    private String name;
    private int weight;
    private int stomachVolume;
    private boolean replete;

    public MyCat(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.replete = false;
        this.stomachVolume = 25 + ((weight - 3) * 15);
    }

    @Override
    public boolean eat(SimplePlate plate) {
        if (plate.getFoodAmount() < stomachVolume) return false;
        if (!replete) {
            plate.decreaseFood(this.stomachVolume);
            replete = true;
        }
        return true;
    }

    @Override
    public void voice() {
        System.out.println("Мяу!");
    }

    @Override
    public void pet() {
        System.out.println(name + ": мур мур мур ");
    }

    @Override
    public boolean isHungry() {
        return replete;
    }

    @Override
    public String toString() {
        return "MyCat{" +
                "имя ='" + name + '\'' +
                (replete ? ", сыт" : ", голоден") +
                ", вес = " + weight +
                ", необходимо еды =" + stomachVolume +
                '}';
    }
}
