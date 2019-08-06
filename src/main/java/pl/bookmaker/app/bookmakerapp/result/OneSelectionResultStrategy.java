package pl.bookmaker.app.bookmakerapp.result;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.Map;

public class OneSelectionResultStrategy implements FinalResultStrategy {
    
    @Override
    public BigDecimal calculateResult(Map<BetTypes, BigDecimal> betToFinalPriceMap) {
        //getFirst
        return betToFinalPriceMap.entrySet()
                                 .iterator()
                                 .next()
                                 .getValue();
    }
    
}
