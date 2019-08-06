package pl.bookmaker.app.bookmakerapp.price;

import java.math.BigDecimal;

import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.PLACE;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.SHOW;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.WIN;

class FirstBookmakerPriceStrategy extends FinalPriceStrategy {
    
    FirstBookmakerPriceStrategy() {
        super();
        
        prepareFunctions();
    }
    
    private void prepareFunctions() {
        betTypeToFunctionMap.put(WIN, bet -> new BigDecimal("115").multiply(bet));
        betTypeToFunctionMap.put(PLACE, bet -> new BigDecimal("120").multiply(bet));
        betTypeToFunctionMap.put(SHOW, bet -> new BigDecimal("110").multiply(bet));
    }
    
}

