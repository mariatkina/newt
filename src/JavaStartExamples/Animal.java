package JavaStartExamples;
/*1. ������� ������ ������ � ��� � ������������� �� ������ ��������.
2. ��� �������� ����� ������ � �����. � �������� ��������� ������� ������ ���������� ����� �����������.
����������� ���������� �������� ����� ������ � �������. (��������, dogBobik.run(150); -> '����� �������� 150 �.');
3. � ������� ��������� ���� ����������� �� �������� (���: ��� 200 �., ������ 500 �.; ��������: ��� �� ����� �������, ������ 10 �.).*/
public abstract class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void swim(int dis) {
        System.out.println(name + " swims " + dis +" m");
    }
    public void run(int dis) {
        System.out.println(name + " runs " + dis +" m");
    }
}
class Dog extends Animal {
    public Dog(String name){
        super(name);
    }
    @Override
    public void swim(int dis) {
        if (dis > 10) {
            System.out.println("Too large distance for "+ getName());
        }else
        {
            super.swim(dis);
        }
    }
    public void run(int dis) {
        if (dis>500){
            System.out.println(getName()+" runs only 500 m and can't run further");
        }else
        {
            super.run(dis);
        }
    }
}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void swim(int dis) {
        if (dis > 0) {
            System.out.println(getName()+" won't swim, because cats never swim!");
        }
    }
    public void run(int dis) {
        if (dis>200){
            System.out.println(getName()+" runs only 200 m and can't run further");
        }else {super.run(dis);}
    }
}
class MainApp{
    public static void main(String[] args) {
        Animal animal1 = new Dog("Pippo");
        Animal animal2 = new Cat("Ollie");
        Cat cat = new Cat("Ric");
        Dog dog = new Dog("Archie");
        cat.run(50);
        dog.run(300);
        animal1.run(800);
        animal2.run(300);
        dog.swim(40);
        animal1.swim(10);
        animal2.swim(10);


//        System.out.println(cat.hashCode());
//        System.out.println(dog.hashCode());
//        System.out.println(animal1.hashCode());
//        System.out.println(animal2.hashCode());
    }
}