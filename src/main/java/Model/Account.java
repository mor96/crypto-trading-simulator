/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author mor
 */
public class Account {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int walletNum;
    private int accountValue;
    private int cash;
    private ArrayList<Coin> portfolio;
    
    public Account(String firstName, String lastName, String email,String password){
        this.firstName = firstName;
        this.lastName = lastName; 
        this.email = email;
        this.password = password ;
        this.walletNum = (int)(Math.random() * 1000000000);
        this.portfolio = new ArrayList();
        cash = 0;
        accountValue = 0;
    }        
    
    public String getName(){
        return firstName + " "+ lastName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    public int getBalance(){
        return walletNum;
    }
    public void setWalletNum(int wallet){
        this.walletNum = wallet;
    }
    
    public int getWalletNum(){
        return this.walletNum;
    }
    
    public float getAccValue(){
        return this.accountValue;
    }
    
    public int getCash(){
        return this.cash;
    }
    
    public void removeCash(int cash){
        this.cash -= cash;
    }
    
    public void addCash(int cash){
        this.cash += cash;
    }
    
    public void addCoinToPortfolio(Coin coin, float amountOfCoinBought){
        if(!portfolio.contains(coin)){
            portfolio.add(coin);
        }
        
        int indx = portfolio.indexOf(coin);
        portfolio.get(indx).addAmount(amountOfCoinBought);
    }
    
    public void removeCoinFromPortfolio(Coin coin, float amountOfCoinSold){
        if(!portfolio.contains(coin)){
            portfolio.add(coin);
        }
        
        int indx = portfolio.indexOf(coin);
        portfolio.get(indx).removeAmount(amountOfCoinSold);
        
        if(portfolio.get(indx).getAmountl() == 0){
            portfolio.remove(indx);
        }
    }
    
    public ArrayList getPortfolio(){
        return this.portfolio;
    }
    
    public int getAccountValue(){
        accountValue = 0;
        for(int i = 0; i < portfolio.size(); i++){
            Coin c = portfolio.get(i);
            this.accountValue += c.getAmountl() * c.getCoinValue();
        }
        return this.accountValue;
    }
}
