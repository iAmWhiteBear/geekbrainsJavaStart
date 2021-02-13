package HW5;

public class FIO {
    private String Name;
    private String SecondName;
    private String ThirdName;

    public FIO(String secondName,String name, String thirdName) {
        this.Name = name;
        this.SecondName = secondName;
        this.ThirdName = thirdName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getThirdName() {
        return ThirdName;
    }

    public void setThirdName(String thirdName) {
        ThirdName = thirdName;
    }

    @Override
    public String toString() {
        return this.SecondName+" "+this.Name+" "+this.ThirdName;
    }
}
