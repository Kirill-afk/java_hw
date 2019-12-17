package hw_2.trades;


import hw_2.Trade;

public class CommoditySpot extends Trade {
    final private String type = "COMMODITY_SPOT";

    public CommoditySpot(double price) {
        super(price);
    }

    public String type() {return type;}
}
