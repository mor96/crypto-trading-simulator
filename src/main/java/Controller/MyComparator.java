/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Coin;
import java.util.Comparator;

/**
 *
 * @author mor
 */

public class MyComparator implements Comparator<Coin> {
    @Override
    //i took this code from stackoverflow
    public int compare(Coin o1, Coin o2) {
        if (o1.getCoinValue() > o2.getCoinValue()) {
            return -1;
        } else if (o1.getCoinValue() < o2.getCoinValue()) {
            return 1;
        }
        return 0;
    }
}

