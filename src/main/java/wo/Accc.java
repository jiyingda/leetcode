package wo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Accc extends Asss {
    public void getss(){
        System.out.println("iiiii");
    }
    public static void main(String... args) throws IOException {
        Accc kkk = new Accc();
        kkk.getss();
        byte[] bb = new byte[10];
        InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
            @Override
            public int read(byte[] bb) throws IOException {
                for(int i = 0; i < bb.length; i++){
                    bb[i] = '1';
                }
                return 0;
            }
        };
        System.out.println(in.available());
        System.out.println(in.read(bb));
        System.out.println(new String(bb));
    }
}
