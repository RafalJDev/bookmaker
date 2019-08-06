package pl.bookmaker.app.bookmakerapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bookmaker.app.bookmakerapp.handler.BetHandler;
import pl.bookmaker.app.bookmakerapp.request.BetToAmountJsonMap;
import pl.bookmaker.app.bookmakerapp.response.BetResults;

@RestController
@RequiredArgsConstructor
class BetController {
    
    private final BetHandler handler;
    
    @PostMapping("bet")
    BetResults betEndpoint(@RequestBody BetToAmountJsonMap jsonMap) {
        return handler.handle(jsonMap);
    }
}
