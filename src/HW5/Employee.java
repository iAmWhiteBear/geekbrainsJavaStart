package HW5;

/**
 *  * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 *  * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 *  * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 */
public class Employee {
    private FIO name;
    private String position;
    private String email;
    private long telephone;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(String name, String secondName, String thirdName, String position, String email, long telephone, double salary, int age) {
        this.name = new FIO(secondName, name, thirdName);
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String name, String secondName, String thirdName, int age) {
        this.name = new FIO(secondName, name, thirdName);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name.toString();
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public long getTelephone() {
        return telephone;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
