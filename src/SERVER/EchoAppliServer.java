package SERVER;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EchoAppliServer {
    public static void main(String args[]){
        try{
            EchoImpl objetDist = new EchoImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("irisi",objetDist);
            System.out.println("l objet distant (objetDist) est enregisté");
        }catch(Exception e){
            System.out.println("Serveur non lancé");
        }
    }

}



