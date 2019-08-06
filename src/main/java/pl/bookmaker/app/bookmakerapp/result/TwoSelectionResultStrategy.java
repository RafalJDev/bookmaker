package pl.bookmaker.app.bookmakerapp.result;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.Map;

import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.PLACE;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.SHOW;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.WIN;

class TwoSelectionResultStrategy implements FinalResultStrategy {
    
    @Override
    public BigDecimal calculateResult(Map<BetTypes, BigDecimal> betToFinalPriceMap) {
        if (betToFinalPriceMap.containsKey(PLACE)) {
            BigDecimal placePrice = betToFinalPriceMap.get(PLACE);
            BigDecimal three = new BigDecimal("3");
            
            if (betToFinalPriceMap.containsKey(WIN)) {
                BigDecimal winPrice = betToFinalPriceMap.get(WIN);
                return winPrice.add(three.multiply(placePrice));
            } else if (betToFinalPriceMap.containsKey(SHOW)) {
                final BigDecimal showPrice = betToFinalPriceMap.get(SHOW);
                return placePrice.add(three.multiply(showPrice));
            }
        }
        throw new IllegalStateException("Required betType " + PLACE.getBetName() + " was not provided.");
    }
    
}
