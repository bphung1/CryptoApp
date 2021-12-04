package crypto.dao;

import crypto.entity.Portfolio;

import java.util.List;

public interface PortfolioDao {
    Portfolio createPortfolio(Portfolio portfolio);
    List<Portfolio> getPortfolio (int userId);
    Portfolio updateNonInvestedBalance(Portfolio portfolio);

//    List<Transactions> getActiveInvestment (int portfolioId);
//    Portfolio getInvestmentBalance (int userId);
//    Portfolio nonInvestmentBalance (int userId);
//    List<Transactions> getBuyHistory(int portfolioId);
//    List<Transactions> getSellHistory(int portfolioId);
}
