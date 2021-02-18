package HW7;

import java.util.Random;

/**
 * 1. Расширить задачу про котов и тарелки с едой. (брать из методички)
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
 *      а кот пытается покушать 15-20).
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 *      Если коту удалось покушать (хватило еды), сытость = true.
 * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
 *      (это сделано для упрощения логики программы).
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию
 *      о сытости котов в консоль.
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Execution {
    private static final String[] CATNAMES = {"Соня","Клеопатра","Цунами","Забияка","Матильда","Кнопка","Гарфилд","Том","Гудвин",
            "Рокки","Ленивец","Пушок","Спорти","Бегемот","Пират","Гудини","Зорро","Саймон","Альбус","Базилио",
            "Леопольд","Нарцисс","Атос","Каспер","Валли","Масяня","Царапка","Серсея","Ворсинка","Амели","Наоми",
            "Маркиза","Изольда"};

    public static void main(String[] args) {
        MyPitomnik pitomnik = new MyPitomnik(new MyPlate(300)); // вместимость миски в граммах
        int cats = 12;
        for (int i = 0; i < cats ; i++) {           // заселение
            pitomnik.addCats(generateNewCat());
        }

        pitomnik.feedCats();
        pitomnik.displayCatsState();
        System.out.println(pitomnik.getPlate().getFoodAmount());
        pitomnik.getPlate().increaseFood(400);
        System.out.println("-------------------------------------");
        pitomnik.feedCats();
        pitomnik.displayCatsState();
        System.out.println("количество котов: "+pitomnik.getCatsNum());
        System.out.println("еды в миске: "+pitomnik.getPlate().getFoodAmount());
        pitomnik.getCats()[0].pet();


    }

    public static SimpleCat generateNewCat(){
        Random random = new Random();
        int weight = random.nextInt(4)+3;  //только взрослые коты
        String name = CATNAMES[random.nextInt(CATNAMES.length)];
        return new MyCat(name, weight);
    }

}
