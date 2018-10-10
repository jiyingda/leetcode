package wo;

import java.io.*;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Fileeeeee {
    public static void main(String... args) throws IOException {
        TreeMap treeMap = new TreeMap();
        File file = new File("f:\\hadoop\\out090603.txt");
        int i = 0;
        File files = new File("f:\\hadoop\\out090604.txt");
        FileWriter ou = new FileWriter(files);
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
            String ss = "";
            while ((ss = in.readLine()) != null) {
                String[] sssss = ss.split("\t");
                if (sssss.length > 1 && sssss[1].length() > 2) {
                    System.out.println(ss);
                    treeMap.put(sssss[1], sssss[0]);
                    ou.write(ss);
                }
            }
        }
        treeMap.forEach((k,v) -> System.out.println( k  + " " + v));
        System.out.println("========" + i);
    }
}
