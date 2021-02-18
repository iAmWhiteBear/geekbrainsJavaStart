package HW7;

public class MyPitomnik {
    private SimplePlate plate;
    private SimpleCat[] cages;
    private int catsNum;

    public MyPitomnik(SimplePlate plate) {
        cages = new MyCat[10];
        this.plate = plate;
    }

    public void addCats(SimpleCat... cats) {
        while (cages.length - catsNum < cats.length) expandCages();
        for (SimpleCat cat : cats) {
            cages[catsNum++] = cat;
        }
    }

    private void expandCages() {
        int newLength = cages.length << 1;
        SimpleCat[] expandedCages = new MyCat[newLength];
        System.arraycopy(cages, 0, expandedCages, 0, cages.length);
        cages = expandedCages;
    }

    public void feedCats() {
        for (SimpleCat cat : cages) {
            if (cat == null ) break;
            cat.eat(plate);
        }
    }

    public void displayCatsState() {
        for (SimpleCat cat : cages) {
            if (cat != null) System.out.println(cat);
        }
    }

    public SimpleCat[] getCats(){
        return cages;
    }

    public int getCatsNum(){
        return catsNum;
    }

    public SimplePlate getPlate() {
        return plate;
    }
}
