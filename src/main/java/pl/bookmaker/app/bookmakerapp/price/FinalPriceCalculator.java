package pl.bookmaker.app.bookmakerapp.price;

import org.springframework.stereotype.Service;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;
import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.FIRST;
import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.SECOND;
import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.THIRD;

@Service
public class FinalPriceCalculator {
    
    private final Map<BookmakerNames, FinalPriceStrategy> bookmakerToFinalPriceStrategyMap;
    
    public FinalPriceCalculator() {
        bookmakerToFinalPriceStrategyMap = new HashMap<>();
        
        prepareStrategies();
    }
    
    private void prepareStrategies() {
        bookmakerToFinalPriceStrategyMap.put(FIRST, new FirstBookmakerPriceStrategy());
        bookmakerToFinalPriceStrategyMap.put(SECOND, new SecondBookmakerPriceStrategy());
        bookmakerToFinalPriceStrategyMap.put(THIRD, new FirstBookmakerPriceStrategy());
    }
    
    public Map<String, BigDecimal> calculateFinalPriceForEachBetType(BookmakerNames bookmakerName,
                                                                     Map<String, BigDecimal> betToAmountMap) {
        return betToAmountMap.entrySet()
                             .stream()
                             .map(betToAmount -> {
                                 BigDecimal finalPrice = calculatePrice(bookmakerName,
                                                                        betToAmount.getKey(),
                                                                        betToAmount.getValue());
                                 //todo I don't like this
                                 betToAmount.setValue(finalPrice);
                                 return betToAmount;
                             })
                             .collect(toMap(Entry::getKey, Entry::getValue));
    }
    
    private BigDecimal calculatePrice(BookmakerNames bookmakerName, String betType, BigDecimal amount) {
        return getStrategy(bookmakerName).calculatePrice(betType, amount);
    }
    
    private FinalPriceStrategy getStrategy(BookmakerNames bookmakerName) {
        return bookmakerToFinalPriceStrategyMap.getOrDefault(bookmakerName, new DefaultFinalPriceStrategy());
    }
    
}
