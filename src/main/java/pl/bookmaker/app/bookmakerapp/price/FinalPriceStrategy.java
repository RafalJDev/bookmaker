package pl.bookmaker.app.bookmakerapp.price;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.function.Function;

abstract class FinalPriceStrategy {
    
    protected final HashMap<String, Function<BigDecimal, BigDecimal>> betTypeToFunctionMap;
    
    protected FinalPriceStrategy() {
        this.betTypeToFunctionMap = new HashMap<>();
    }
    
    public BigDecimal calculatePrice(String betType, BigDecimal bet) {
        return betTypeToFunctionMap.getOrDefault(betType, bigDecimal -> new BigDecimal("0"))
                                   .apply(bet);
    }
    
}
