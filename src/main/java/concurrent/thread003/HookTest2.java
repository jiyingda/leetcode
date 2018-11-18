package concurrent.thread003;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HookTest2 {
    private final static String LOCK_PATH = System.getProperty("user.home")+File.separator+"loks" +File.separator;

    private final static String LOCK_FILE = ".lock";

    private final static String PER = "rw-------";


    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("the pg resivve kill single");
            getLockFile().toFile().delete();

        }));

        checkRunning();


        for (int i = 0; i < 50; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("pg is running");
        }



    }


    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()){
            throw new RuntimeException("the pg already running");
        }

        //Set<PosixFilePermission> permissionSet = PosixFilePermissions.fromString(PER);

        Files.createFile(path);
    }





    private static Path getLockFile(){
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }
}
