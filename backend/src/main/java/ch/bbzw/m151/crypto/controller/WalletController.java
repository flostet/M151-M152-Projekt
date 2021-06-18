package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.model.Wallet;
import ch.bbzw.m151.crypto.dto.WalletDto;
import ch.bbzw.m151.crypto.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/wallets")
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public class WalletController {
    @Autowired
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('USER')")
    public Wallet add(@RequestBody final WalletDto wallet) {
        return walletService.add(wallet);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void delete(@PathVariable final long id) {
        walletService.delete(id);
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
