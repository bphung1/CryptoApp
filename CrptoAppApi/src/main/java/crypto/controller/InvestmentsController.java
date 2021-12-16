package crypto.controller;


import crypto.dto.Crypto;
import crypto.entity.Investment;
import crypto.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestmentsController extends ControllerBase {
    @Autowired
    private CryptoService service;
    @GetMapping("/getInvestments/{portfolioId}")
    public ResponseEntity<List<Investment>> getInvestments(@PathVariable int portfolioId){
        List<Investment> investmentList=service.getInvestmentsByPortfolioId(portfolioId);
        if(investmentList == null){
            return new ResponseEntity("user does not exist", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(investmentList);
    }

    @GetMapping("/getCrypto/{symbol}")
    public ResponseEntity<Crypto> getCrypto(@PathVariable String symbol) {
        try {

            Crypto crypto = service.rateForCrypto(symbol);

            return ResponseEntity.ok(crypto);

        } catch (Exception ex) {
            return new ResponseEntity("Crypto symbol does not exist", HttpStatus.NOT_FOUND);
        }
    }

}
