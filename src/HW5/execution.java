package HW5;

/**
 * 4. Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class execution {
    public static void main(String[] args) {
        Employee[] firm = new Employee[5];
        firm[0] = new Employee("Bria","Poles","Tadd","VP Accounting","tpoles0@wordpress.com", 88005553535L,117202,44);
        firm[1] = new Employee("Ric","Jakobssen","Freeland","Senior Editor","fjakobssen1@craigslist.org",3891063909972L,98286,34);
        firm[2] = new Employee("Dall","Smith","Jason","Financial Analyst","jcanada2@umich.edu",463894962496L,55299,18);
        firm[3] = new Employee("Sheilah","Houseman","Merwyn","Geological Engineer","mhouseman3@vinaora.com",3517659208056L,196465,49);
        firm[4] = new Employee("Stepha","Flowith","Olvan","General Manager","oflowith4@imgur.com",864141115353L,159566,60);

        for(Employee e: firm)
            if (e.getAge()>40) System.out.println(e);

    }
}
