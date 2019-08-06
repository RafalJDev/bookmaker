package pl.bookmaker.app.bookmakerapp.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class BetResults {
    
    List<BetBookmakerResult> amounts;
    
}
