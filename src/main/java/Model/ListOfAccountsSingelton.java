/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.UpdateCoins;
import java.util.ArrayList;

/**
 *
 * @author mor
 */
public class ListOfAccountsSingelton {
    private UpdateCoins cl;
    private ArrayList<Account> accountList;
    private static ListOfAccountsSingelton inst = null;

//    public MarketSingelton(){
//        accountList.add(cl.createCoin("bitcoin"));
//        accountList.add(cl.createCoin("bitcoin-cash"));
//        accountList.add(cl.createCoin("ethereum"));
//        accountList.add(cl.createCoin("ripple "));
//        System.out.println("ze bdika");
//    }   
    
    public static ListOfAccountsSingelton getInstance(){
        if(inst == null){ // doesn't already exist?
           inst = new ListOfAccountsSingelton();
        }
        return inst;
    }

    private ListOfAccountsSingelton(){ 
        accountList = new ArrayList();       
    }
    
    public void addAccount(Account acc){
        accountList.add(acc);   
    } 
    
    public void removeAccount(Account acc){
        accountList.remove(acc);
    } 
    
    public void setData(int i, Account newValue){
        accountList.set(i, newValue);  
    }
      
    public Account getAccount(int i){ 
        return accountList.get(i);
    }
    
    public int getLength() {
        return accountList.size();
    }
    
    public ArrayList<Account> getWholeList(){
        return (ArrayList<Account>)accountList.clone(); 
    }
    
    public void replaceList(ArrayList<Account> accList){
        accountList.clear();
        accountList.addAll(accList);
    }
    
}
