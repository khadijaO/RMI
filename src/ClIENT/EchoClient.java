package ClIENT;

import SERVER.Echo;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EchoClient {
    public static void main(String args[]){
        String url="rmi://localhost/irisi";
        try{
            Echo od=(Echo) Naming.lookup(url);
            System.out.println(od.echo("Message du Client"));
        }catch(Exception e){
            System.out.println("Serveur Introuvble");
        }
    }
}
