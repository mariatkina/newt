package Chpnship;
/*Добавить класс Team, который будет содержать:
название команды;
массив из четырех участников;
метод для вывода информации о членах команды, прошедших дистанцию;
метод вывода информации обо всех членах команды.
Добавить класс Course (полоса препятствий), в котором будут находиться:
массив препятствий;
метод, который будет просить команду пройти всю полосу.*/
public class AppStart {
    public static void main(String[] args) {
        Membr[] mmbs = new Membr[4];
        Team sportsmen = new Team("Spartak", mmbs);
        sportsmen.setTeam(new Membr("Arthur", 24,90, 30, 165, 120),
                new Membr("Grigory", 20, 96, 29, 170, 110),
                new Membr("Igor", 25, 100, 31, 168, 100),
                new Membr("Klaus", 23, 89, 33, 166, 99));
        Course course = new Course();
        course.trialsPass(sportsmen);
        System.out.println();
        course.winners(sportsmen);
    }
}
