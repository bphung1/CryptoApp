package crypto.dao;

import crypto.entity.Portfolio;
import crypto.entity.Transactions;
import crypto.entity.Users;

import java.util.List;

public interface PortfolioDao {
    Portfolio createPortfolio(Portfolio portfolio);
    List<Portfolio> getPortfolio (int userId);

//    List<Transactions> getActiveInvestment (int portfolioId);
//    Portfolio getInvestmentBalance (int userId);
//    Portfolio nonInvestmentBalance (int userId);
//    List<Transactions> getBuyHistory(int portfolioId);
//    List<Transactions> getSellHistory(int portfolioId);
}
