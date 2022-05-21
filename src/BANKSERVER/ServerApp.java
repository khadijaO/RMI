package BANKSERVER;

import SERVER.EchoImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerApp {
    public static void main(String args[]){
        try{
            BankImpl objetDist = new BankImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("bank",objetDist);
            System.out.println("l objet distant (objetDist) est enregisté");
        }catch(Exception e){
            System.out.println("Serveur non lancé");
        }
    }

}