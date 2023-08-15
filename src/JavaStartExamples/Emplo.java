package JavaStartExamples;
/*1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/
public class Emplo {
    private String name;
    private String role;
    private String email;
    private String tel;
    private double salary;
    private int age;

    public Emplo(String name, String role, String email, String tel, double salary, int age) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }
    public void info(){
        System.out.println("name: "+name+",\nrole: "+role+",\ne-mail: "+email+",\nphone number: "+tel+",\nrate: "+salary+",\nage: "+age);
    }

    public int getAge() {
        return age;
    }
}
class Main {
    public static void main(String[] args) {
        Emplo [] persons = new Emplo [5];
        persons[0] = new Emplo("George Harrisson", "accountant", "across@universe.com", "+12345678991", 25000, 64);
        persons[1] = new Emplo("Ritchie Blackmore", "plumber", "smoke@onthewater.com", "+12345678991", 15000, 34);
        persons[2] = new Emplo("Jimmie Hendrixx", "producer", "guitar@player.com", "+12345678991", 20000, 42);
        persons[3] = new Emplo("Justin Bieber", "economist", "singer@usa.com", "+12345678991", 21000, 29);
        persons[4] = new Emplo("Keith Richards", "cleaner", "stones@rollin.com", "+12345678991", 18000, 36);

        for (int i=0; i< persons.length;i++) {
            if (persons[i].getAge()>=40){
                persons[i].info();
            }
            System.out.println();
        }
    }
}
