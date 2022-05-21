package BANKSERVER;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface Banque extends Remote {
    public int  getSolde() throws RemoteException;

    public String  Retirer(int amount) throws RemoteException;

    public String verser(int amount) throws RemoteException;
    public HashMap<String, Integer> Lister() throws RemoteException;
}
