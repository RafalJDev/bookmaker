package pl.bookmaker.app.bookmakerapp.price;

import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;

class DefaultFinalPriceStrategy extends FinalPriceStrategy {
    
    @Override
    public BigDecimal calculatePrice(BetTypes betType, BigDecimal bet) {
        return new BigDecimal("0");
    }
    
}
