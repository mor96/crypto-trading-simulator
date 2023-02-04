/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.Coin;
import java.util.ArrayList;

/**
 *
 * @author mor
 */
public class TradeController {
    
    public void coinPurchase(Coin coin, int amountInCash, Account acc){
        float amountOfCoinBought = amountInCash / coin.getCoinValue();
        acc.addCoinToPortfolio(coin, amountOfCoinBought);
    }
    
    public void coinSelling(Coin coin, int amountInCash, Account acc){
        int indx = acc.getPortfolio().indexOf(coin);
        float amountOfCoinSold = amountInCash / coin.getCoinValue();
        acc.removeCoinFromPortfolio(coin, amountOfCoinSold);
    }
    
    public boolean checkAmountIsEnought(Account acc, Coin coin, float amountOfCoin){
        ArrayList<Coin> tmp = acc.getPortfolio();
        int idx = tmp.indexOf(coin);
        if(tmp.get(idx).getAmountl() >= amountOfCoin){
            return true;
        }
        else{
            return false;
        }
    }
    
}
