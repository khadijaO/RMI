package BANKSERVER;

import SERVER.Echo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class BankImpl extends UnicastRemoteObject implements Banque {
    private final int MAX_POSSIBLE_AMOUNT_TO_VERSE=10000;
    protected BankImpl() throws RemoteException {
    }

    @Override
    public int getSolde() throws RemoteException {
        return MyBankAccount.solde;
    }

    @Override
    public String Retirer(int amount) throws RemoteException {
        LocalDate currentdate = LocalDate.now();
        String result="";
        result="solde de  "+amount+" DH est retiré  avec sucess :) ";
if(MyBankAccount.solde<amount){
    result="tu ne  peut pas retiré   "+amount+" DH :(";
}
else {
    MyBankAccount.solde=MyBankAccount.solde-amount;
    MyBankAccount.ordre++;
    MyBankAccount.operations.put("no "+ MyBankAccount.ordre+") Retrait  le "+currentdate,amount);
}    return result+" ,Votre solde actuel est: "+MyBankAccount.solde;



    }

    @Override
    public String verser(int amount) throws RemoteException {
        LocalDate currentdate = LocalDate.now();
        String result="";
        result="solde de "+amount+" DH est versé  avec sucess :) ";
        if(amount>MAX_POSSIBLE_AMOUNT_TO_VERSE){
            result="tu ne  peut pas versé   "+amount+" DH:(";
        }
        else {
            MyBankAccount.solde=MyBankAccount.solde+amount;
            MyBankAccount.ordre++;
            MyBankAccount.operations.put("no "+ MyBankAccount.ordre+") Versement  le "+currentdate ,amount);
        }    return result+" ,Votre solde actuel est: "+MyBankAccount.solde;


    }

    @Override
    public HashMap<String, Integer> Lister() throws RemoteException {
      return MyBankAccount.operations;


    }
}
