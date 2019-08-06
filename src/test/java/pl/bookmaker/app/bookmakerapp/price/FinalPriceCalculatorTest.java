package pl.bookmaker.app.bookmakerapp.price;

import org.junit.Before;
import org.junit.Test;
import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerWithBets;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.PLACE;
import static pl.bookmaker.app.bookmakerapp.pojo.BetTypes.WIN;

public class FinalPriceCalculatorTest {
    
    FinalPriceCalculator calculator;
    
    @Before
    public void setUp() throws Exception {
        calculator = new FinalPriceCalculator();
    }
    
    @Test
    public void givenSomeBets_whenCalculatingPrice_thenSomeFinalPrice() {
        //given
        HashMap<BetTypes, BigDecimal> betToAmountMap = new HashMap<>();
        betToAmountMap.put(WIN, new BigDecimal("10"));
        betToAmountMap.put(PLACE, new BigDecimal("100"));
        //betToAmountMap.put(new ob, new BigDecimal("1000"));
        
        //when
        BookmakerWithBets bookmakerWithBets = calculator.calculateFinalPriceForEachBetType(BookmakerNames.FIRST,
                                                                                                 betToAmountMap);
    
        //then
        Map<BetTypes, BigDecimal> stringBigDecimalMap = bookmakerWithBets.getBetToAmountMap();
        
        BigDecimal winPrice = stringBigDecimalMap.get(WIN);
        BigDecimal placePrice = stringBigDecimalMap.get(PLACE);
        //BigDecimal noSuchPrice = stringBigDecimalMap.get("there is no such");
        
        //todo calculate it from strategy itself ?
        assertEquals(new BigDecimal("1150"), winPrice);
        assertEquals(new BigDecimal("12000"), placePrice);
        //assertEquals(new BigDecimal("0"), noSuchPrice);
    }
    
    @Test
    public void givenEmptyMap() {
        //given
        HashMap<BetTypes, BigDecimal> betToAmountMap = new HashMap<>();
        
        //when
        BookmakerWithBets bookmakerWithBets = calculator.calculateFinalPriceForEachBetType(BookmakerNames.FIRST,
                                                                                                   betToAmountMap);
    
        Map<BetTypes, BigDecimal> stringBigDecimalMap = bookmakerWithBets.getBetToAmountMap();
    
        assertEquals(stringBigDecimalMap.size(), 0);
    }
    
    //todo
    // write way mmmmooorreee test cases, but not today
}