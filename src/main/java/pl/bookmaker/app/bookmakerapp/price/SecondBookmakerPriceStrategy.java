package pl.bookmaker.app.bookmakerapp.price;

import java.math.BigDecimal;

public class SecondBookmakerPriceStrategy extends FinalPriceStrategy {
    
    SecondBookmakerPriceStrategy() {
        super();
        
        addFunctionsToMap();
    }
    
    private void addFunctionsToMap() {
        betTypeToFunctionMap.put("win", bet -> new BigDecimal("110").multiply(bet));
        betTypeToFunctionMap.put("place", bet -> new BigDecimal("101").multiply(bet));
        betTypeToFunctionMap.put("show", bet -> new BigDecimal("107").multiply(bet));
    }
    
}
