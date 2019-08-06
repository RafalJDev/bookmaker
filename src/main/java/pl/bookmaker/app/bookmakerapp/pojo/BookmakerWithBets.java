package pl.bookmaker.app.bookmakerapp.pojo;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Map;

@Value
public class BookmakerWithBets {
    
    BookmakerNames bookmakerName;
    Map<BetTypes, BigDecimal> betToAmountMap;
    
}
