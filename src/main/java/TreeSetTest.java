import java.util.*;

public class TreeSetTest {

    public static void main(String... args){

        SortedSet<String> set = new TreeSet<>();
        set.add("Bob");
        set.add("Amy");
        set.add("Car");
        for(String c : set){
            System.out.println(c);
        }

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("tom", 1234));
        parts.add(new Item("wwa", 1341));
        parts.add(new Item("eeq", 5637));
        System.out.println(parts);

        NavigableSet<Item> nset = new TreeSet<>(
                Comparator.comparing(Item::getDescription)
        );

        nset.addAll(parts);
        System.out.println(nset);

    }
}
