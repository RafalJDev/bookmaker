package pl.bookmaker.app.bookmakerapp.price;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;

public class SecondBookmakerPriceStrategy extends FinalPriceStrategy {
    
    SecondBookmakerPriceStrategy() {
        super();
        
        prepareFunctions();
    }
    
    private void prepareFunctions() {
        betTypeToFunctionMap.put(BetTypes.WIN, bet -> new BigDecimal("110").multiply(bet));
        betTypeToFunctionMap.put(BetTypes.PLACE, bet -> new BigDecimal("101").multiply(bet));
        betTypeToFunctionMap.put(BetTypes.SHOW, bet -> new BigDecimal("107").multiply(bet));
    }
    
}
