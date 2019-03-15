package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String... args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("d:/123.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);

        System.out.println(bytesRead);;

        String newData = "new string to write to file " + System.currentTimeMillis();

        ByteBuffer buff = ByteBuffer.allocate(48);
        buff.clear();
        buff.put(newData.getBytes());
        buff.flip();

        while (buff.hasRemaining()){
            inChannel.write(buff);
        }
        inChannel.close();


        ChannelTest.read();


    }
}
