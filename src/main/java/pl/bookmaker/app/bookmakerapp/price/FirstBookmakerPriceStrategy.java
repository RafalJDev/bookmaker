package pl.bookmaker.app.bookmakerapp.price;

import java.math.BigDecimal;

class FirstBookmakerPriceStrategy extends FinalPriceStrategy {
    
    FirstBookmakerPriceStrategy() {
        super();
        
        addFunctionsToMap();
    }
    
    private void addFunctionsToMap() {
        betTypeToFunctionMap.put("win", bet -> new BigDecimal("115").multiply(bet));
        betTypeToFunctionMap.put("place", bet -> new BigDecimal("120").multiply(bet));
        betTypeToFunctionMap.put("show", bet -> new BigDecimal("110").multiply(bet));
    }
    
}

