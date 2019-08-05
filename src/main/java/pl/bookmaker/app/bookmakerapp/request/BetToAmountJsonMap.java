package pl.bookmaker.app.bookmakerapp.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BetToAmountJsonMap {
    
    private Map<String, BigDecimal> map = new HashMap<>();
    
    @JsonAnyGetter()
    public Map<String, BigDecimal> getMap() {
        return this.map;
    }
    
    public void setMap(Map<String, BigDecimal> map) {
        this.map = map;
    }
    
    @JsonAnySetter
    public void addValue(String key, BigDecimal value) {
        this.map.put(key, value);
    }
    
}