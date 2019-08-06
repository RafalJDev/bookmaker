package pl.bookmaker.app.bookmakerapp.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerNames;
import pl.bookmaker.app.bookmakerapp.pojo.BookmakerWithBets;
import pl.bookmaker.app.bookmakerapp.price.FinalPriceCalculator;
import pl.bookmaker.app.bookmakerapp.request.BetToAmountJsonMap;
import pl.bookmaker.app.bookmakerapp.response.BetBookmakerResult;
import pl.bookmaker.app.bookmakerapp.response.BetResults;
import pl.bookmaker.app.bookmakerapp.result.ResultCalculator;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
@RequiredArgsConstructor
public class BetHandler {
    
    private final FinalPriceCalculator priceCalculator;
    
    private final ResultCalculator resultCalculator;
    
    List<BookmakerNames> bookmakers = asList(BookmakerNames.values());
    
    public BetResults handle(BetToAmountJsonMap betToAmountMap) {
        
        List<BetBookmakerResult> betBookmakerResults = calculateFinalResults(betToAmountMap);
        
        return BetResults.builder()
                         .amounts(betBookmakerResults)
                         .build();
    }
    
    private List<BetBookmakerResult> calculateFinalResults(BetToAmountJsonMap betToAmountMap) {
        return bookmakers.stream()
                         .map(bookmakerName -> new BookmakerWithBets(bookmakerName, betToAmountMap.getMap()))
                         .map(bookmakerWithBets -> priceCalculator.calculateFinalPriceForEachBetType(bookmakerWithBets))
                         .map(calculateResultAndMapToBetResult())
                         .sorted(Comparator.comparing(BetBookmakerResult::getFinalResult).reversed())
                         .collect(Collectors.toList());
    }
    
    private Function<BookmakerWithBets, BetBookmakerResult> calculateResultAndMapToBetResult() {
        return bookmakerWithFinalPriceBets -> {
            BigDecimal finalResult = resultCalculator.calculateResult(bookmakerWithFinalPriceBets.getBetToAmountMap());
            BookmakerNames bookmakerName = bookmakerWithFinalPriceBets.getBookmakerName();
            
            return BetBookmakerResult.builder()
                                     .bookmakerName(bookmakerName.getBookmakerName())
                                     .finalResult(finalResult)
                                     .build();
        };
    }
    
}
