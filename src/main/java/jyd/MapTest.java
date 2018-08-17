package jyd;

import java.util.*;

public class MapTest {
    public static void main(String... args){

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.forEach((k,v) -> System.out.println(k + v));

        System.out.println(map.merge("a", 1, Integer::sum));;
        Set<String> sss = map.keySet();
        Collection<Integer> sssss = map.values();
        sss.forEach(p -> System.out.println(p));
        System.out.println("\n");
        sssss.forEach(q -> System.out.println(q));


        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> none = EnumSet.noneOf(Weekday.class);
        none.add(Weekday.FRIDAY);
        none.forEach(p -> System.out.println(p));

        String[] dd = new String[52];
        List<String> aaa = new ArrayList<>(52);
        for(int i = 0; i < dd.length; i++){
            dd[i] = "" + i;
            aaa.add(dd[i]);;
        }


        List<String> ddd = Arrays.asList(dd);
        System.out.println("----->>>>" + ddd.get(1));;
        List llll = aaa.subList(10, 20);
        System.out.println(aaa.size());
        llll.clear();
        System.out.println(llll.size());
        System.out.println(aaa.size());

    }
    enum Weekday {MONDAY, TUESDAY, WEDNEDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

}
