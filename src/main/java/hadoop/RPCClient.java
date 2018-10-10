package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

public class RPCClient {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        MyBizable proxy = RPC.getProxy(MyBizable.class, 123456,
                new InetSocketAddress("127.0.0.1", 8077) , new Configuration());
        String result = proxy.doSomething("服务端");
        System.out.println(result);
        RPC.stopProxy(proxy);
    }
}
