package pl.bookmaker.app.bookmakerapp.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BetTypes {
    
    WIN("WIN"), PLACE("PLACE"), SHOW("SHOW");
    
    private final String betName;
}
