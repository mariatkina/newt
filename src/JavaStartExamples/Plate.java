package JavaStartExamples;
import java.util.Scanner;
/*1. 3����a ��� ����� � ������� � ����.
2. ������� ���, ����� � ������� � ���� �� ����� ���������� �������������� ���������� ��� (��������, � ����� 10 ���, � ��� �������� �������� 15-20).
3. ������� ���� ����� �������� ���� ������� (����� ������� �����, ��� �������). ���� ���� ������� �������� (������� ���), ������� = true.
4. �������, ��� ���� ���� ���� ��� � �������, �� �� � ������ �� �������, �� ���� �� ����� ���� ���������� ��� (��� ������� ��� ��������� ������ ���������).
5. ������� ������ ����� � ������� � ����, ��������� ���� ����� �������� �� ���� ������� � ����� ������� ���������� � ������� ����� � �������.
6. �������� � ������� �����, � ������� �������� ����� ���� �� ��������� ��� � �������.*/
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