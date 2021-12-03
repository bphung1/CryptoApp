package crypto.controller;

import crypto.entity.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController extends ControllerBase{
    @GetMapping("/{portfolioId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsForPortfolio(@PathVariable int portfolioId) {
        return null;
    }

    @PostMapping("/{portfolioId}/newtransaction")
    public ResponseEntity<Transaction> addTransaction(@PathVariable int portfolioId, @RequestBody Transaction transaction) {
        return null;
    }
}
