/*
 */
package Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author Michael Ocean <mocean@endicott.edu>
 */
public class Coin {
    private String description;
    private String coinName;
    private String main;
    private String id;
    private String iconURL;
    private String symbol;
    public static String currency = "usd", currencySymbol = "$", timePeriod = "price_change_percentage_24";
    private String price_1d, price_1w, price_1m ,price_1y;
    private float coinValue, valueChange;
    private float priceAtPurchase;
    private float amount;
    //private String coin;
    private ImageIcon im;

    JsonObject JSONcurrency;
    JsonObject JSONpriceChange;
   
   
    public Coin(String coinName){

        this.coinName = coinName;
        try{
             URL apiURL = new URL("https://api.coingecko.com/api/v3/coins/" + coinName + "?localization=false&tickers=false&market_data=true&community_data=false&developer_data=false&sparkline=false");

             URLConnection yc = apiURL.openConnection();

             InputStream inStream = yc.getInputStream();
             InputStreamReader inStreamReader = new InputStreamReader(inStream);

             BufferedReader in = new BufferedReader(inStreamReader);

             String inputLine;
             StringBuilder sb = new StringBuilder();

             while ((inputLine = in.readLine()) != null){
                 sb.append(inputLine);
                 sb.append("\n");
             }
             in.close();

            // jtaResults.setText(sb.toString());
             JsonParser jp = new JsonParser();
             JsonElement root = jp.parse(sb.toString());
             JsonObject objRoot = root.getAsJsonObject();

             //JsonElement error = objRoot.get("error");
             //JsonObject errorcheck = error.getAsJsonObject();

             JsonElement valueElem = objRoot.get("image");
             JsonObject coinList = valueElem.getAsJsonObject();
             this.iconURL = coinList.get("small").getAsString();
             this.id = objRoot.get("id").getAsString();
             this.coinName = objRoot.get("name").getAsString();
             this.symbol = objRoot.get("symbol").getAsString();

             System.out.println();
             valueElem = objRoot.get("market_data");
             coinList = valueElem.getAsJsonObject();
             valueElem = coinList.get("current_price");
             JSONpriceChange = coinList;

             JSONcurrency = valueElem.getAsJsonObject();
             coinValue = JSONcurrency.get(currency).getAsFloat();
             this.valueChange = JSONpriceChange.get(timePeriod).getAsFloat();
             this.amount = 0;

         }
         catch(Exception e){
             // TODO: Produce useful error messages for the user
             e.printStackTrace();
             System.out.println("DEed");

         }
    }
   
    public String getCoinName(){
            return this.coinName;
     }

    public String getCoinId(){
            return this.id;
     }


    public String getIconURL(){
            return this.iconURL;
     }

    public float getPriceChange(){
        return this.valueChange;
    }
   
    public float getCoinValue(){
       return this.coinValue;
    }

    public ImageIcon getIcon(){
           return this.im;
    }

    public String getSymbol(){
           return this.symbol;
    }

    public float getAmountl(){
           return this.amount;
    }

    public void addAmount(float amount){
           this.amount += amount;
    }

    public void removeAmount(float amount){
           this.amount -= amount;
    }

    public void setNewValue(float newVal){
           this.coinValue = newVal;
    }

    public void setCurrency(String curr){
       this.coinValue = JSONcurrency.get(curr).getAsFloat();
    }

    public void setPriceChangePeriod(String a){
      this.valueChange = JSONpriceChange.get(a).getAsFloat();

    }

    public float getUpdatedPrice(String coinName){
       Coin coin = new Coin(coinName);
       return coin.coinValue;
    }

}
