package pl.bookmaker.app.bookmakerapp.response;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class BetBookmakerResult {
    
    String bookmakerName;
    BigDecimal finalResult;
    
}
