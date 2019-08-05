package pl.bookmaker.app.bookmakerapp.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookmakerNames {
    
    FIRST("first"), SECOND("second"), THIRD("third");
    
    private final String bookmakerName;
    
}
