/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Coin;
import Model.MarketSingelton;
import Model.MyWatchlistSingelton;
import View.CoinList;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mor
 */
public class UpdatingPrice extends Thread {
  public static int amount = 0;
  private Coin coin;
  private CoinList coinList;
  
  private ArrayList<Coin> alist = new ArrayList();
  private ArrayList<Coin> blist = new ArrayList();
  
  public void newThread() {
    UpdatingPrice thread = new UpdatingPrice();
    thread.start();
    
    // Wait for the thread to finish
//    while(thread.isAlive()) {
//    System.out.println("Waiting...");
//  }
//  // Update amount and print its value
//  System.out.println("Main: " + amount);
//  amount++;
//  System.out.println("Main: " + amount);
  }
  public void run() {
    MarketSingelton ms = MarketSingelton.getInstance();
    MyWatchlistSingelton ps = MyWatchlistSingelton.getInstance();
    Coin a = ms.getCoin(0);
    String s = a.getCoinName();
    System.out.println(s);
    while(true){
        try {
            for(int i = 0; i < ms.getLength(); i++){
            float newPrice = ms.getCoin(i).getUpdatedPrice(ms.getCoin(i).getCoinId());
            ms.setNewPrice(i, newPrice);  
            System.out.println(ms.getCoin(i).getCoinName() + "  " + ms.getCoin(i).getCoinValue());
            //Thread.sleep(5000);
        }    
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdatingPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  } 
}
