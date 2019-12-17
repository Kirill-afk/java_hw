package hw_2.trades;


import hw_2.Trade;

public class IrSwap extends Trade {
    final private String type = "IR_SWAP";

    public IrSwap(double price) {
        super(price);
    }

    public String type() {return type;}
}
