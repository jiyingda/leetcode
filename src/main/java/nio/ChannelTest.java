package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;

public class ChannelTest {

    public static void main(String... args) throws IOException {

        //read();
        long st = System.currentTimeMillis();
        System.out.println(sequentialSum(1000000));
        long ed = System.currentTimeMillis();
        System.out.println(ed - st);
        long st2 = System.currentTimeMillis();
        System.out.println(parallelSum(1000000));;
        long ed2 = System.currentTimeMillis();
        System.out.println(ed2 - st2);
    }


    public static long sequentialSum(long n){
            return Stream.iterate(1L, i ->i + 1)
                    .limit(n).reduce(0L,Long::sum);
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,i -> i +1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }


    public static void read() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("d:/123.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(10);
        ByteBuffer buf1 = ByteBuffer.allocate(20);
        ByteBuffer[] buff = {buf, buf1};

        long bytesRead = inChannel.read(buff);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
