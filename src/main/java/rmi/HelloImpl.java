package rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {


    private static final long serialVersionUID = 6306012100711048924L;

    public HelloImpl() throws RemoteException {
    }

    public HelloImpl(int port) throws RemoteException {
        super(port);
    }

    public HelloImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String sayHelloToSomeBody(String someBody) throws RemoteException {
        System.out.println("connected success");
        return "hello " + someBody;
    }
}
