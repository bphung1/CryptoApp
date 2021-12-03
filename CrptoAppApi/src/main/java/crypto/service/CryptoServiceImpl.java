package crypto.service;

import crypto.dao.InvestmentDao;
import crypto.dao.PortfolioDao;
import crypto.dao.TransactionDao;
import crypto.dao.UsersDao;
import crypto.entity.Investment;
import crypto.entity.Portfolio;
import crypto.entity.Transaction;
import crypto.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CryptoServiceImpl implements CryptoService{
    @Autowired
    UsersDao usersDao;

    @Autowired
    PortfolioDao portfolioDao;

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    InvestmentDao investmentDao;

    @Override
    public User login(String username, String password) {
        try {
            return usersDao.getUsers(username, password);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public User createAccount(User user) {
        try {
            User newUser = usersDao.createUsers(user);
            Portfolio newPortfolio = new Portfolio();
            newPortfolio.setUserId(newUser.getUserid());
            newPortfolio.setInvestedTotalBalance(new BigDecimal("0.00"));
            newPortfolio.setNonInvestedBalance(new BigDecimal("0.00"));
            portfolioDao.createPortfolio(newPortfolio);
            return newUser;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Portfolio inputNoninvestedBalance(int portfolioId, double deposit) {
        return null;
    }

    @Override
    public Portfolio withdrawFromNonInvBal(int portfolioId, double amount) {
        return null;
    }

    @Override
    public Portfolio getPortfolio(int userId) {
        return null;
    }

    @Override
    public Transaction getTransactionByPortfolioId(int portfolioId) {
        return null;
    }

    @Override
    public List<Investment> getInvestmentsByPortfolioId(int portfolioId) {
        return null;
    }
}
