import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;

public class PairTest1 {
    public static void main(String... args){
        String[] words = {"aaa", "bbb", "cc", "dd", "ee",};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
        System.out.println(ArrayAlg.getMiddle("hello",0,null,1.1));;

        DateIn dateIn = new DateIn();
        dateIn.setSecond(null);


        TreeMap<String, String> map = new TreeMap();
        map.put("a","b");
    }

}

class ArrayAlg{
    public static Pair<String> minmax(String[] a){
        if(a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for(int i = 1; i < a.length; i++){
            if(min.compareTo(a[i]) > 0){
                min = a[i];
            }
            if(max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static <T> T getMiddle(T... a){
        return a[a.length / 2];
    }
}
