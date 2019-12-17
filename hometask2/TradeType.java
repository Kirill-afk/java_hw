package hometask2;

import hometask2.trades.Bond;
import hometask2.trades.CommoditySpot;
import hometask2.trades.FxSpot;
import hometask2.trades.IrSwap;

public enum TradeType {
    FX_SPOT{
        public FxSpot createTrade(double a){
            return new FxSpot(a);
        }
    },
    BOND{
        public Bond createTrade(double a){
            return new Bond(a);
        }

    },
    COMMODITY_SPOT{
        public CommoditySpot createTrade(double a){
            return new CommoditySpot(a);
        }
    },
    IR_SWAP{
        public IrSwap createTrade(double a){
            return new IrSwap(a);
        }
    };

    public abstract Trade createTrade(double a);
}
