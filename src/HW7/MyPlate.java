package HW7;

public class MyPlate implements SimplePlate {
    private int foodAmount;

    public MyPlate(int food) {
        this.foodAmount = food;
    }

    public void increaseFood(int amount) {
        foodAmount += amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        int rest = foodAmount - amount;
        if (rest >= 0) foodAmount = rest;
    }
}
