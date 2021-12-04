package crypto.service;

import crypto.entity.Investment;
import crypto.entity.Portfolio;
import crypto.entity.Transaction;
import crypto.entity.User;

import java.util.List;

public interface CryptoService {
    User login(String username, String password);
    User createAccount(User user); 
    Portfolio inputNoninvestedBalance(int portfolioId, double deposit);
    Portfolio withdrawFromNonInvBal(int portfolioId, double amount);
    Portfolio getPortfolio(int userId);
    List<Transaction> getTransactionByPortfolioId(int portfolioId);
    List<Investment> getInvestmentsByPortfolioId(int portfolioId);

    //add transaction
    //update portfolio for balance
    //add helper method for total invested balance and update portfolio total balance
}
