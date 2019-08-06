package pl.bookmaker.app.bookmakerapp.result;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.Map;

import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.PLACE;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.SHOW;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.WIN;

public class ThreeSelectionResultStrategy implements FinalResultStrategy {
    
    @Override
    public BigDecimal calculateResult(Map<BetTypes, BigDecimal> betToFinalPriceMap) {
        if ((betToFinalPriceMap.containsKey(WIN) && betToFinalPriceMap.containsKey(PLACE) && betToFinalPriceMap.containsKey(
            SHOW))) {
            BigDecimal winPrice = betToFinalPriceMap.get(WIN);
            BigDecimal placePrice = betToFinalPriceMap.get(PLACE);
            BigDecimal showPrice = betToFinalPriceMap.get(SHOW);
            
            BigDecimal two = new BigDecimal("2");
            BigDecimal twoAndHalf = new BigDecimal("5").divide(two);
            
            return winPrice.multiply(two)
                           .add(placePrice.multiply(two))
                           .add(showPrice.multiply(twoAndHalf));
        }
        throw new IllegalStateException("Missing one of betType: win, place,show");
    }
    
}
