package SERVER;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EchoImpl extends UnicastRemoteObject implements Echo {
    private static final long serialversionUID=1L;

    protected EchoImpl() throws RemoteException {
    }

    public String echo (String str) throws RemoteException{
        return "Le serveur Repond au : "+str;
    }
}
