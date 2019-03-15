package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    String sayHelloToSomeBody(String someBody) throws RemoteException;
}
