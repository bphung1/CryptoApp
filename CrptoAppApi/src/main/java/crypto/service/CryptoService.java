package crypto.service;

import crypto.entity.Investment;
import crypto.entity.Portfolio;
import crypto.entity.Transaction;
import crypto.entity.User;

import java.util.List;

public interface CryptoService {
    User login(String username, String password);
    User createAccount(User user); // create user AND portfolio in one method
    Portfolio inputNoninvestedBalance(int portfolioId, double deposit); //dao get portfolio, update the portfolio
    Portfolio withdrawFromNonInvBal(int portfolioId, double amount);
    Portfolio getPortfolio(int userId); //add helper method for total invested balance and update portfolio total balance
    Transaction getTransactionByPortfolioId(int portfolioId);
    List<Investment> getInvestmentsByPortfolioId(int portfolioId);
}
