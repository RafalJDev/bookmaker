package pl.bookmaker.app.bookmakerapp.result;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.Map;

class DefaultFinalResultStrategy implements FinalResultStrategy {
    
    @Override
    public BigDecimal calculateResult(Map<BetTypes, BigDecimal> betToFinalPriceMap) {
        return new BigDecimal("0");
    }
    
}
