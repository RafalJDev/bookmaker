package pl.bookmaker.app.bookmakerapp.price;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.function.Function;

abstract class FinalPriceStrategy {
    
    final HashMap<BetTypes, Function<BigDecimal, BigDecimal>> betTypeToFunctionMap;
    
    FinalPriceStrategy() {
        this.betTypeToFunctionMap = new HashMap<>();
    }
    
    public BigDecimal calculatePrice(BetTypes betType, BigDecimal bet) {
        return betTypeToFunctionMap.getOrDefault(betType, bigDecimal -> new BigDecimal("0"))
                                   .apply(bet);
    }
    
}
