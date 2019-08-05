package pl.bookmaker.app.bookmakerapp.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class BetResult {
    
    List<BetBookMakerResult> amounts;
    
}
