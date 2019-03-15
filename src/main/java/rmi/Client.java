package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String... args) throws RemoteException, NotBoundException, MalformedURLException {
        Hello zhello = (Hello)Naming.lookup("rmi://127.0.0.1:8888/RHello");
        System.out.println(zhello.sayHelloToSomeBody("iiiiii"));;
    }
}
