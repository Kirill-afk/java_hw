package hw_2.trades;


import hw_2.Trade;

public class Bond extends Trade {
    final private String type = "BOND";

    public Bond(double price) {
        super(price);

    }

    public String type() {return type;}
}
