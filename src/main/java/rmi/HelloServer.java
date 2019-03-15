package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

    public static void main(String... args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        Hello hello = new HelloImpl();
        LocateRegistry.createRegistry(8888);
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        Naming.bind("rmi://localhost:8888/RHello", hello);

    }


}
