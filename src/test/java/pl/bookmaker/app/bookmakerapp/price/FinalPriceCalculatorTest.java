package pl.bookmaker.app.bookmakerapp.price;

import org.junit.Before;
import org.junit.Test;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FinalPriceCalculatorTest {
    
    FinalPriceCalculator calculator;
    
    @Before
    public void setUp() throws Exception {
        calculator = new FinalPriceCalculator();
    }
    
    @Test
    public void givenSomeBets_whenCalculatingPrice_thenSomeFinalPrice() {
        //given
        HashMap<String, BigDecimal> betToAmountMap = new HashMap<>();
        betToAmountMap.put("win", new BigDecimal("10"));
        betToAmountMap.put("place", new BigDecimal("100"));
        betToAmountMap.put("there is no such", new BigDecimal("1000"));
        
        //when
        Map<String, BigDecimal> stringBigDecimalMap = calculator.calculateFinalPriceForEachBetType(BookmakerNames.FIRST,
                                                                                                   betToAmountMap);
        
        //then
        BigDecimal winPrice = stringBigDecimalMap.get("win");
        BigDecimal placePrice = stringBigDecimalMap.get("place");
        BigDecimal noSuchPrice = stringBigDecimalMap.get("there is no such");
        
        //todo calculate it from strategy itself ?
        assertEquals(new BigDecimal("1150"), winPrice);
        assertEquals(new BigDecimal("12000"), placePrice);
        assertEquals(new BigDecimal("0"), noSuchPrice);
    }
    
    @Test
    public void givenEmptyMap() {
        //given
        HashMap<String, BigDecimal> betToAmountMap = new HashMap<>();
        
        //when
        Map<String, BigDecimal> stringBigDecimalMap = calculator.calculateFinalPriceForEachBetType(BookmakerNames.FIRST,
                                                                                                   betToAmountMap);
        
        assertEquals(stringBigDecimalMap.size(), 0);
    }
    
    //todo
    // write way mmmmooorreee test cases, but nut today
}