package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        list.add(2, "Marco");

        System.out.println(list.size());

        for (String obj : list) {
            System.out.println(obj);
        }

        System.out.println("-------------------------");
        list.removeIf(x -> x.charAt(0) == 'M');

        System.out.println(list);

        System.out.println("-------------------------");
        
        System.out.println("Index of Bob: " + list.indexOf("Bob"));

        System.out.println("-------------------------");

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        System.out.println(result);

        System.out.println("-------------------------");

        String name = list.stream().filter(x -> x.charAt(0)  == 'J').findFirst().orElse(null);
        System.out.println(name);
    }
}
