package crypto.controller;

import crypto.entity.Portfolio;
import crypto.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController extends ControllerBase{

    @Autowired
    CryptoService service;

    @GetMapping("/{userId}/getportfolio")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable int userId) {
        Portfolio portfolio = service.getPortfolio(userId);

        if(portfolio == null) {
            return new ResponseEntity("Portfolio not found.", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(portfolio);
    }

    @PostMapping("/{userId}/updatenoninvestedbalance")
    public Portfolio updateNonInvestedBalanceInPortfolio(@PathVariable int userId) {}

}
