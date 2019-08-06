package pl.bookmaker.app.bookmakerapp.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import pl.bookmaker.app.bookmakerapp.pojo.BetTypes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BetToAmountJsonMap {
    
    private Map<BetTypes, BigDecimal> map = new HashMap<>();
    
    @JsonAnyGetter()
    public Map<BetTypes, BigDecimal> getMap() {
        return this.map;
    }
    
    public void setMap(Map<BetTypes, BigDecimal> map) {
        this.map = map;
    }
    
    @JsonAnySetter
    public void addValue(String key, BigDecimal value) {
        this.map.put(BetTypes.valueOf(key), value);
    }
    
}