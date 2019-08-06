package pl.bookmaker.app.bookmakerapp.result;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.Map;

interface FinalResultStrategy {
    
    BigDecimal calculateResult(Map<BetTypes, BigDecimal> betToFinalPriceMap);
    
}
