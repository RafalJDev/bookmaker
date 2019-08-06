package pl.bookmaker.app.bookmakerapp.price;

import org.springframework.stereotype.Service;
import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerWithBets;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.FIRST;
import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.SECOND;

@Service
public class FinalPriceCalculator {
    
    private final Map<BookmakerNames, FinalPriceStrategy> bookmakerToFinalPriceStrategyMap;
    private static final DefaultFinalPriceStrategy defaultStrategy = new DefaultFinalPriceStrategy();
    
    public FinalPriceCalculator() {
        bookmakerToFinalPriceStrategyMap = new HashMap<>();
        
        prepareStrategies();
    }
    
    private void prepareStrategies() {
        bookmakerToFinalPriceStrategyMap.put(FIRST, new FirstBookmakerPriceStrategy());
        bookmakerToFinalPriceStrategyMap.put(SECOND, new SecondBookmakerPriceStrategy());
    }
    
    public BookmakerWithBets calculateFinalPriceForEachBetType(BookmakerWithBets bookmakerWithBets) {
        return calculateFinalPriceForEachBetType(bookmakerWithBets.getBookmakerName(),
                                                 bookmakerWithBets.getBetToAmountMap());
    }
    
    public BookmakerWithBets calculateFinalPriceForEachBetType(BookmakerNames bookmakerName,
                                                               Map<BetTypes, BigDecimal> betToAmountMap) {
        Map<BetTypes, BigDecimal> betTypeToFinalPrice = new HashMap<>();
        betToAmountMap.forEach((betType, price) -> {
            BigDecimal finalPrice = calculatePrice(bookmakerName, betType, price);
            betTypeToFinalPrice.put(betType, finalPrice);
        });
        
        return new BookmakerWithBets(bookmakerName, betTypeToFinalPrice);
    }
    
    private BigDecimal calculatePrice(BookmakerNames bookmakerName, BetTypes betType, BigDecimal amount) {
        return getStrategy(bookmakerName).calculatePrice(betType, amount);
    }
    
    private FinalPriceStrategy getStrategy(BookmakerNames bookmakerName) {
        return bookmakerToFinalPriceStrategyMap.getOrDefault(bookmakerName, defaultStrategy);
    }
    
}
