package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import java.io.IOException;

public class RPCServer implements MyBizable{
    @Override
    public String doSomething(String str) {
        return str;
    }

    public static void main(String... args) throws IOException {
        Server server = new RPC.Builder(new Configuration())
                .setProtocol(MyBizable.class)
                .setInstance(new RPCServer())
                .setBindAddress("127.0.0.1")
                .setPort(8077)
                .build();
        server.start();
    }
}
