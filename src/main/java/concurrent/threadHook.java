package concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class threadHook {

    public static void main(String... args) throws IOException {

        /*Thread th = new Thread(()->{
            System.out.println("-------------shutdown--------");
        });

        Runtime.getRuntime().addShutdownHook(th);

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(Runtime.getRuntime().freeMemory());

        System.out.println(Runtime.getRuntime().maxMemory());
        Runtime.getRuntime().exec("cmd.exe");
        Runtime.getRuntime().halt(-1);*/
        //getIp();
        getIII();
        //getProperty();
        //StringBuffer



    }

    public static void getProperty(){
        //SecurityManager securityManager = new SecurityManager();
        //System.setSecurityManager(securityManager);

        System.out.println(System.getProperty("java.security.manager"));;

        Throwable throwable = new Throwable();
        StackTraceElement[] elements = throwable.getStackTrace();
        for (StackTraceElement e: elements){
            e.getLineNumber();
        }
    }

    public static void getIII(){
        String command="dir";
        Runtime runtime = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            Process process = runtime.exec(command);
            BufferedReader	bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));


            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                //if (line.contains(s)) {
                    System.out.println(line);
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        getProperty();
    }

    public static void getIp(){
        String command="ipconfig -all";
        String s="IPv4";
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(command);
            BufferedReader	bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));


            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                if (line.contains(s)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }
}
