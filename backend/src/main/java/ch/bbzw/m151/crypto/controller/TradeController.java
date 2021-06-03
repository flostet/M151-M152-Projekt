package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.model.Trade;
import ch.bbzw.m151.crypto.dto.TradeDto;
import ch.bbzw.m151.crypto.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/trades")
//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public class TradeController {
    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping("/add")
//@PreAuthorize("hasAuthority('ADMIN')")
    public Trade add(@RequestBody final TradeDto trade) {
        return tradeService.add(trade);
    }

    @DeleteMapping("/{id}")
//@PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable final long id) {
        tradeService.delete(id);
    }

    @GetMapping("/{id}")
    public Trade getById(@PathVariable final long id) { return tradeService.getbyId(id).orElseThrow(); }

    @GetMapping("/wallet/{id}")
    public List<Trade> getTradesByWallet(@PathVariable final long id) { return tradeService.getTradesByWallet(id); }
}