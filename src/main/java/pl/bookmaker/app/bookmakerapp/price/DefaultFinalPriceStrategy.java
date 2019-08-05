package pl.bookmaker.app.bookmakerapp.price;

import java.math.BigDecimal;

class DefaultFinalPriceStrategy extends FinalPriceStrategy {
    
    @Override
    public BigDecimal calculatePrice(String betType, BigDecimal bet) {
        return new BigDecimal("0");
    }
    
}
