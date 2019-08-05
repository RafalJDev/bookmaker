package pl.bookmaker.app.bookmakerapp.pojo;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Map;

@Value
public class BookmakerToBets {
    
    String bookmakerName;
    Map<String, BigDecimal> map;
    
}
