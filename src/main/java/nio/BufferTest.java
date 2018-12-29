package nio;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.SimpleFileVisitor;
import java.util.Objects;

public class BufferTest implements Serializable {

    private static final long serialVersionUID = 7863414576159590535L;

    public String getSSSS(){
        return "ssssss";
    }

    public static void main(String... args) throws IllegalAccessException, InstantiationException {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        IntBuffer ib = bb.asIntBuffer();
        bb.put(new byte[]{1,42,12});
        /*将ByteBuffer转化为IntBuffer视图后，再调用put，ByteBuffer中的position指针不会移动
         * 但是所生成的IntBuffer中的position会按正常方式移动
         * 而且整个IntBuffer的capacity会按照byte 和 int 之间的所占字节大小比例而改变*/
        System.out.println("ByteBuffer.position = "+bb.position());
        System.out.println("ByteBuffer.limit = "+bb.limit());
        System.out.println("ByteBuffer.capacity = "+bb.capacity());
        System.out.println("IntBuffer.position = "+ib.position());
        System.out.println("IntBuffer.limit = "+ib.limit());
        System.out.println("IntBuffer.capacity = "+ib.capacity());
        ib.flip();
        while(ib.hasRemaining()) {
            System.out.println(ib.get());
        }
        String ss = String.class.newInstance();
        System.out.println(ss);

        //System.out.println(Objects.compare("124"));
        //StringBuffer

    }
}
