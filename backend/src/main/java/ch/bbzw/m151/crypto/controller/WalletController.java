package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.model.Wallet;
import ch.bbzw.m151.crypto.dto.WalletDto;
import ch.bbzw.m151.crypto.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/wallets")
public class WalletController {
    @Autowired
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/add")
    public Wallet add(@RequestBody final WalletDto wallet) {
        return walletService.add(wallet);
    }

    @DeleteMapping("/delete/coin/{id}")
    public void delete(@PathVariable final long id) {
        walletService.deleteWithId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWithWalletId(@PathVariable final long id) {
        walletService.deleteWithWalletId(id);
    }

    @GetMapping("/{id}")
    public Wallet getById(@PathVariable final long id) { return walletService.getbyId(id).orElseThrow(); }

    @GetMapping("/user/{name}")
    public List<Wallet> getByName(@PathVariable final String name) { return walletService.getByUser(name);}

    @GetMapping
    public List<Wallet> get() {
        return walletService.getAll();
    }
}
