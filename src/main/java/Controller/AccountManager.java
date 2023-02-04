/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.CoinName;
import Model.ListOfAccountsSingelton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mor
 */
public class AccountManager {
    private ListOfAccountsSingelton listAcc = ListOfAccountsSingelton.getInstance();
    private ArrayList<Account> users;
     ArrayList<CoinName> alist;
    
    
    public AccountManager(){
        
    }
    
    public void createAccount(String firstName, String lastName, String email,String password){
        Account acc = new Account(firstName, lastName, email, password);
        listAcc.addAccount(acc);       
    }
   
    public Account findAcc(String email){
        Account tmp = null;
        for(int i = 0; i < listAcc.getLength(); i++){
            if(listAcc.getAccount(i).getEmail().equals(email)){
                tmp = listAcc.getAccount(i);
            }
        }
        return tmp;
    }
    
    public boolean isAccExist(String email){
        Account tmp = null;
        for(int i = 0; i < listAcc.getLength(); i++){
            if(listAcc.getAccount(i).getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList getListOfCoinNames(){
        alist = new ArrayList();
        Gson gson = new Gson();       

        File f = new File("/Users/mor/NetBeansProjects/finalproject2/src/main/java/Model/coinList.txt"); 

        BufferedReader brIn = null;
        try {
            brIn = new BufferedReader(
                    new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        alist.addAll(gson.fromJson(brIn, 
                new TypeToken<ArrayList<CoinName>>() {}.getType())); 
        
        
        return alist;
    }
    
    
    public void loadUsers(){
            
        Gson gson = new Gson();       

        File f = new File("/Users/mor/NetBeansProjects/finalproject2/src/main/java/Model/usersList.txt"); 

        BufferedReader brIn = null;
        try {
            brIn = new BufferedReader(
                    new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        listAcc.replaceList(gson.fromJson(brIn, 
                new TypeToken<ArrayList<Account>>() {}.getType()));       
    }
     
     public void saveData(){
        PrintWriter out = null;
        
        
        File file = new File("/Users/mor/NetBeansProjects/finalproject2/src/main/java/Model/usersList.txt");    

        Gson gson = new Gson();
        String userJson = gson.toJson(listAcc.getWholeList());
        try {
            out = new PrintWriter(file);
            
            out.println("[");
            for(int i = 0; i < listAcc.getLength(); i++){
                Account p = listAcc.getAccount(i);
                System.out.println(p.getName());
                if(i!=listAcc.getLength() - 1){
                    out.print(gson.toJson(p));
                    out.println(",");
                }
                else
                    out.println(gson.toJson(p));
            }   
            out.println("]");
            out.close();
            } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
}
