/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Controller.AccountManager;
import Controller.UpdateCoins;
import java.util.ArrayList;
import java.util.Collections;
import Controller.MyComparator;

/**
 *
 * @author mor
 */
public class MarketSingelton {
    private UpdateCoins cl;
    private ArrayList<Coin> market;
    private ArrayList<CoinName> aList;
    private static MarketSingelton inst = null;
    private AccountManager accMng;

//    public MarketSingelton(){
//        market.add(cl.createCoin("bitcoin"));
//        market.add(cl.createCoin("bitcoin-cash"));
//        market.add(cl.createCoin("ethereum"));
//        market.add(cl.createCoin("ripple "));
//        System.out.println("ze bdika");
//    }   
    
    public static MarketSingelton getInstance(){
        if(inst == null){ // doesn't already exist?
           inst = new MarketSingelton();
        }
        return inst;
    }

    private MarketSingelton(){
        //market = new ArrayList(); 
        cl = new UpdateCoins();
        market = new ArrayList();
        accMng = new AccountManager();
        
        ArrayList<CoinName> list = accMng.getListOfCoinNames();
//        for(int i = 0; i < 15; i++){
//            market.add(cl.createCoin(list.get(i * 89).getId()));
//            System.out.println("counting: " + i);
//        }
        //market.add(cl.createCoin("bitcoin"));
//        market.add(cl.createCoin("bitcoin-cash"));
//        market.add(cl.createCoin("ethereum"));
//        market.add(cl.createCoin("ripple"));
//        market.add(cl.createCoin("0cash"));
////        market.add(cl.createCoin("gooddollar"));
//        market.add(cl.createCoin("aapl"));
//        market.add(cl.createCoin("aave"));
//        market.add(cl.createCoin("jewel"));
////        market.add(cl.createCoin("kiloample"));
////        market.add(cl.createCoin("htmlcoin"));
////        market.add(cl.createCoin("komet"));
////        market.add(cl.createCoin("abcc-token"));
//        market.add(cl.createCoin("akoin"));
//        market.add(cl.createCoin("akropolis"));
        //market.add(cl.createCoin("akroma"));
        
        
    }
    
    public void addCoin(Coin coin){
        market.add(coin);   
    } 
    
    public void setData(int i, Coin newValue){
        market.set(i, newValue);  
    }
    
    public void setNewPrice(int i, float newValue){
        market.get(i).setNewValue(newValue);
    }
    
    public Coin getCoin(int i){ 
        return market.get(i);
    }
    
    public int getLength() {
        return market.size();
    }
    
    public float getCoinPrice(Coin coin){
        float newVal = 0;
        for(int i = 0; i < market.size(); i++){
            if(market.get(i).getCoinName().equals(coin.getCoinName())){
                newVal = market.get(i).getCoinValue();
            }
        }
        return newVal;
    }
    public void sortList(ArrayList<Coin> a) {
        market.clear();
        market.addAll(a);
    }

    public ArrayList<Coin> getWholeList(){
        return (ArrayList<Coin>)market.clone(); 
    }
   
}
