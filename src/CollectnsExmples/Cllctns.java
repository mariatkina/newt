package CollectnsExmples;

import java.util.*;
/*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс "Телефонный Справочник", который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
взаимодействие с пользователем через консоль и т.д).
Консоль использовать только для вывода результатов проверки телефонного справочника.*/
public class Cllctns {
    public static void main(String[] args) {
        //1.:
        wrds("коллекции представляет собой контейнер объектов который хранит в себе множество элементов и представляет работать с этой множество элементов как с одним объектов коллекции хранит для хранит получения работать с этой множество объектов");
        //2.:
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "+79189995566");
        phoneBook.add("Smirnov", "+79567895566");
        phoneBook.add("Glazunov", "+79189995566");
        phoneBook.add("Smirnov", "+7918659126");
        phoneBook.add("Sivov", "+79589995517");
        phoneBook.add("Glazov", "+79589455516");
        phoneBook.add("Pavlova", "+79589789231");
        phoneBook.add("Ivanov", "+79139995516");
        phoneBook.add("Shapkin", "+79812995516");

        //вывод всего справочника:
//        phoneBook.getBook().forEach((k, v) ->{
//            System.out.println(k+": "+v);});
        System.out.println();
        //вывод телефона по фамилии:
        phoneBook.get("Ivanov");
    }
    //преобразование строки слов в список уникальных элементов с подсчетом вхождений:
    public static void wrds(String s){
        List<String> wrdList = new ArrayList<>(List.of(s.split(" ")));
        Set<String> wrdsSet = new LinkedHashSet<>(wrdList);
        Map<String, Integer> wrdMap = new LinkedHashMap<>();
        for (String o:wrdsSet){
            wrdMap.put(o, count(o, wrdList));
        }
        wrdMap.forEach((k, v) ->{
            System.out.println(k+" - "+v);});
    }
    //подсчет вхождений элемента в список:
    public static <T> Integer count(T t, List<T> list){
        Iterator<T> iter = list.iterator();
        int count = 0;
        while (iter.hasNext()) {
            T s = iter.next();
            if (t.equals(s)){count++;}
        }return count;
    }
}
