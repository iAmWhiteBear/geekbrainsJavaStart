package HW6;

public class Execution {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Тузик","рыжий",10),
                new Cat("ураган","чёрный",3),
                new Dog("Шарик","рыже-белый",7),
                new Dog("Найда","чёрный",12),
                new Cat("курмень","белый",5),
                new Dog("Рэкс","белый",15),
                new Dog("Пикси","серый",20)
        };

        animals[1].run(100);
        animals[1].run(200);
        animals[2].run(200);
        animals[2].run(700);
        animals[5].swim(5);
        animals[5].swim(500);
        animals[4].swim(5);



        Dog.showDogs();
        Cat.showCats();
        Animal.showAnimals();

    }
}
