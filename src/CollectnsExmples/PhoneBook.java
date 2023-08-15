package CollectnsExmples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List> book = new HashMap<>();

    public PhoneBook() {
    }
    public Map add(String s, String v){
        List<String>list = new ArrayList<>();
        if (!book.containsKey(s)) {
            list.add(v);
            book.put(s, list);
        }else {
            list = book.get(s);
            list.add(v);
        }
        return book;
    }

    public Map<String, List> getBook() {
        return book;
    }
    public void get(String s){
        System.out.println(s+": ");
        for (Object i : book.get(s)){
            System.out.println(i);
        }
    }
    @Override
    public String toString() {
        return "PhoneBook: " + book;
    }
}
