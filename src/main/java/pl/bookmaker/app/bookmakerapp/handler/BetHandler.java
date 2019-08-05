package pl.bookmaker.app.bookmakerapp.handler;

import lombok.RequiredArgsConstructor;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames;
import pl.bookmaker.app.bookmakerapp.price.FinalPriceCalculator;
import pl.bookmaker.app.bookmakerapp.request.BetToAmountJsonMap;
import pl.bookmaker.app.bookmakerapp.response.BetResult;

import java.util.Arrays;
import java.util.List;

import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.FIRST;
import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.SECOND;
import static pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames.THIRD;

@RequiredArgsConstructor
public class BetHandler {
    
    private final FinalPriceCalculator priceCalculator;
    
        List<BookmakerNames> bookmakers = Arrays.asList(FIRST, SECOND, THIRD);
    
    public BetResult handle(BetToAmountJsonMap betToAmountMap) {
        
        
        bookmakers.stream()
                  .map(bookmakerName -> priceCalculator.calculateFinalPriceForEachBetType(bookmakerName,
                                                                                          betToAmountMap.getMap()));
        
        return null;
    }
    
    
}
