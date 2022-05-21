package BANKCLIENT;

import BANKSERVER.Banque;
import SERVER.Echo;

import java.rmi.Naming;

public class ClientApp {
    public static void main(String args[]){
        String url="rmi://localhost/bank";
        try{
            Banque banque=(Banque) Naming.lookup(url);
//            --------RETRAIT----------------
            System.out.println("Solde ------------------------ :"+banque.getSolde());
            System.out.println("Operation de Versement-------- :\n"+banque.verser(1000));
            System.out.println("Operation de retrait---------- :\n"+banque.Retirer(500));
            System.out.println("Operation de retrait---------- :\n"+banque.Retirer(1000));
            System.out.println("Operation de Versement-------- :\n"+banque.verser(40));
            System.out.println("Solde ------------------------ :"+banque.getSolde());
            System.out.println("Operations History------------ :\n");
            for (String i : banque.Lister().keySet()) {
                System.out.println("" + i + "|| montant: " + banque.Lister().get(i));
            }

        }catch(Exception e){
            System.out.println("Serveur Introuvble");
        }
    }
}


