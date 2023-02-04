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
public class MyWatchlistSingelton {
    private UpdateCoins cl;
    private ArrayList<Coin> watchList;
    private static MyWatchlistSingelton inst = null;
    
    public static MyWatchlistSingelton getInstance(){
        if(inst == null){ // doesn't already exist?
           inst = new MyWatchlistSingelton();
        }
        return inst;
    }

    private MyWatchlistSingelton(){
        //market = new ArrayList(); 
        cl = new UpdateCoins();
        watchList = new ArrayList();
       
    }
    
    public boolean isCoinInside(Coin coin){
        return watchList.contains(coin);
    }
    
    public void addCoin(Coin coin){
        watchList.add(coin);   
    }
    
     public void removeCoin(Coin coin){
        watchList.remove(coin);
    }
    
    public void setData(int i, Coin newValue){
        watchList.set(i, newValue);  
    }
    
    public Coin getCoin(int i){ 
        return watchList.get(i);
    }
    
    public int getLength() {
        return watchList.size();
    }

    public ArrayList<Coin> getWholeList(){
        return (ArrayList<Coin>)watchList.clone(); 
    }
    
    public void addToPortfolio(Coin coin){
        this.watchList.add(coin);
    }
    
    public ArrayList getPortfolio(){
        return this.watchList;
    }
   
}
