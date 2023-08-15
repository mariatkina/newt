package JavaStartExamples;
import java.util.Scanner;
/*1. 3адачa про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.*/
public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public int getFood() {
        return food;
    }
    public int decrease(Cats c){

        if (food - c.getAppet() >= 0){
            System.out.println(c.getName() + " eats "+c.getAppet()+" food. "+c.getName() + " satisfied");
            food-=c.getAppet();
            System.out.println("Now food = "+food);
            return food;}
        else {
            System.out.println(c.getName()+" doesn't get enough food!!!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to add 20 food? (y/n)");
            String s = sc.nextLine();
            if (s.equals("y")){
                food+=20;
                System.out.println(c.getName() + " eats "+c.getAppet()+" food. "+c.getName() + " satisfied");
                food-=c.getAppet();
                System.out.println("Now food = "+food);
                return food;}
            else {
                return food;
            }
        }
    }
}
class Cats {
    private int appet;
    private String name;
    public Cats(int appet, String name) {
        this.appet = appet;
        this.name = name;
    }
    public int getAppet() {
        return appet;
    }
    public String getName() {
        return name;
    }
}
class catsApp{
    public static void main(String[] args) {
        Cats [] cats = new Cats[5];
        cats[0] = new Cats(15, "Persy");
        cats[1] = new Cats(25, "Fatsy");
        cats[2] = new Cats(10, "Nancy");
        cats[3] = new Cats(17, "Ollie");
        cats[4] = new Cats(12, "Chuck");
        Plate plate = new Plate(30);
        System.out.println("Food in the plate = "+plate.getFood());
        for (Cats cat : cats) {
            plate.decrease(cat);
        }
    }
}