package pl.bookmaker.app.bookmakerapp.result;

import org.springframework.stereotype.Service;
import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResultCalculator {
    
    private final Map<Integer, FinalResultStrategy> betTypeToStrategy;
    private DefaultFinalResultStrategy defaultStrategy = new DefaultFinalResultStrategy();
    
    ResultCalculator() {
        betTypeToStrategy = new HashMap<>();
        betTypeToStrategy.put(1, new OneSelectionResultStrategy());
        betTypeToStrategy.put(2, new TwoSelectionResultStrategy());
        betTypeToStrategy.put(3, new ThreeSelectionResultStrategy());
    }
    
    public BigDecimal calculateResult(Map<BetTypes, BigDecimal> betToFinalPriceMap) {
        return getStrategy(betToFinalPriceMap.size()).calculateResult(betToFinalPriceMap);
    }
    
    private FinalResultStrategy getStrategy(Integer betSize) {
        return betTypeToStrategy.getOrDefault(betSize, defaultStrategy);
    }
    
}
