package hw_2;

import hw_2.trades.Bond;
import hw_2.trades.CommoditySpot;
import hw_2.trades.FxSpot;
import hw_2.trades.IrSwap;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //1 - считывание из заранее заданного пути, 0 - считывание из параметров запуска

        boolean testFlag = true;
        String path;

        if (testFlag) {
            path = "D:\\java_hw\\src\\hw_2\\trades\\BOND.txt";
        } else {
            if (args.length == 0) {
                System.err.println("No input file");
                System.exit(1);
            }
            path = args[0];
        }
        String buff, type;
        double price;

        BufferedReader buffReader = new BufferedReader(new FileReader(path));

        buff = buffReader.readLine(); // пропуск первой строки

        buff = buffReader.readLine();
        type = buff.split("=")[1];

        buff = buffReader.readLine();
        price = Double.parseDouble(buff.split("=")[1]);

        // 1-й способ через switch
        switch (type) {
            case "FX_SPOT":
                Trade fxSpot = new FxSpot(price);
                break;
            case "BOND":
                Trade bond = new Bond(price);
                break;
            case "COMMODITY_SPOT":
                Trade commoditySpot = new CommoditySpot(price);
                break;
            case "IR_SWAP":
                Trade irSwap = new IrSwap(price);
                break;
        }

        // 2-й способ через Enum + abstract createTrade
        Trade trade = TradeType.valueOf(type).createTrade(price);


    }

}
