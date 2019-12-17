package hw_2.trades;


import hw_2.Trade;

public class FxSpot extends Trade  {
    final private String type = "FX_SPOT";


    public FxSpot(double price) {
        super(price);
    }

    public String type() {return type;}
}
