package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.model.Coin;
import ch.bbzw.m151.crypto.dto.CoinDto;
import ch.bbzw.m151.crypto.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/coins")
public class CoinController {
    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @PostMapping("/add")
    public Coin add(@RequestBody final CoinDto coin) {
        return coinService.add(coin);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable final String name) {
        coinService.delete(name);
    }

    @GetMapping("/{id}")
    public Coin getById(@PathVariable final long id) { return coinService.getbyId(id).orElseThrow(); }

    @GetMapping
    public List<Coin> get() {
        return coinService.getAll();
    }

    @GetMapping("/id/{coingeckoid}")
    public long getIdByName(@PathVariable final String coingeckoid) { return coinService.getIDByName(coingeckoid); }
}
