package Generikks;

import java.util.Arrays;

public class MnApp {
    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        ArrChng<String> exOne = new ArrChng<>("one", "two", "three", "four");
        ArrChng<Integer> exTwo = new ArrChng<>(45, 26, 3, 82);
        ArrChng<Character> exoTw = new ArrChng<>('*', '^', '$', '/');
        try {
            System.out.println(exOne.chngElts(1, 2));
            System.out.println(exTwo.chngElts(2, 4));
            System.out.println(exoTw.chngElts(1, 3));
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        /*2. Задача:
            Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
            Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
            Для хранения фруктов внутри коробки можно использовать ArrayList;
            Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
            Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
            Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;*/

        //создание и вывод содержимого коробок:
        Box<Apple> aBox = new Box<>(new Apple(),45);
        Box<Orange> oBox = new Box<>(new Orange(), 30);
        System.out.println("The "+aBox.getT().getName().toLowerCase()+" box weight is "+aBox.getBoxWeight());
        System.out.println("The "+oBox.getT().getName().toLowerCase()+" box weight is "+oBox.getBoxWeight());

        //сравнение коробок по весу:
        if (aBox.compareBoxes(oBox)) {
            System.out.println("The weight of boxes is equal");
        }else {
            System.out.println("The weight of boxes is not equal");
        }
        //создание новых коробоки добавление в них фруктов из других:
        Box<Apple> emptyABox = new Box<>(new Apple(), 0);
        Box<Orange> newOBox = new Box<>(new Orange(), 33);
        emptyABox.addToBox(aBox, 40);
        newOBox.addToBox(oBox, 28);
    }
}
