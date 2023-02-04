/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.Coin;
import Model.CoinName;
import Model.MarketSingelton;
import Model.MyWatchlistSingelton;
import View.CoinList;
import View.CoinRender;
import View.MainWindow1;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mor
 */
public class UpdateCoins {
    private CoinList cl = new CoinList();
    private MainWindow1 mw;
    private CoinRender cr;
    private MyWatchlistSingelton wList;    
    private MarketSingelton ms;
    public static Coin selCoin;
     ArrayList<CoinName> alist;
    
    
    public ArrayList alist(){
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
    
    public Coin createCoin(String name){
        String CoinName = name.toLowerCase(); 
        Coin a = new Coin(CoinName);
        return a;     
     }
    
    public void addCoinToMarket(Coin coin){
        ms = MarketSingelton.getInstance();
        ms.addCoin(coin);
    }
    
    public void addToWatchList(Coin coin){
        wList = MyWatchlistSingelton.getInstance();
        if(!wList.isCoinInside(coin)){        
            wList.addCoin(coin);
        }
    }
    
    public void removeFromWatchList(Coin coin){
        wList = MyWatchlistSingelton.getInstance();
        wList.removeCoin(coin);
    }
    
    public DefaultListModel getModel(){
        return cl.getModel();
    }
    
    public void selectedCoin(Coin coin){
        selCoin = coin;
    }
    
    public ArrayList getListPort(){
        return wList.getWholeList();
    }
    
    public String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }
   
    public void sort(int a){
        ms = MarketSingelton.getInstance();
        ArrayList<Coin> alist = ms.getWholeList();
        int n = alist.size();
       
         
            for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++){
                    if(a == 0){ // 0 for high to low and 1 for low to high
                        if (alist.get(j).getCoinValue() > alist.get(min_idx).getCoinValue()){
                            min_idx = j;
                        }
                    }
                    else if(a == 1){
                        if (alist.get(j).getCoinValue() < alist.get(min_idx).getCoinValue()){
                            min_idx = j;
                        }
                    }
                    else if(a == 2){
                        if (alist.get(j).getPriceChange() > alist.get(min_idx).getPriceChange()){
                            min_idx = j;
                        }
                    }
                    else if(a == 3){
                        if (alist.get(j).getPriceChange() < alist.get(min_idx).getPriceChange()){
                            min_idx = j;
                        }
                    }
                }
                // Swap the found minimum element with the first
                // element
                Coin temp = alist.get(min_idx);      
                alist.set(min_idx, alist.get(i));
                alist.set(i, temp);       
            }
        
        
        ms.sortList(alist);
    }
    
}
