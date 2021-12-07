package crypto.service;

import crypto.dao.InvestmentDao;
import crypto.dao.PortfolioDao;
import crypto.dao.TransactionDao;
import crypto.dao.UsersDao;
import crypto.dto.Crypto;
import crypto.entity.Investment;
import crypto.entity.Portfolio;
import crypto.entity.Transaction;
import crypto.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
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
    public Portfolio inputNonInvestedBalance(int userId, double deposit) {
       Portfolio user = portfolioDao.getPortfolio(userId);
       BigDecimal currentBal = user.getNonInvestedBalance();
        if(deposit > 0){
            BigDecimal update = currentBal.add(BigDecimal.valueOf(deposit));
            user.setNonInvestedBalance(update);
        }
            return portfolioDao.updatePortfolioBalance(user);
    }

    @Override
    public Portfolio withdrawFromNonInvBal(int userId, double amount) {
        Portfolio user = portfolioDao.getPortfolio(userId);
        BigDecimal currentBal = user.getNonInvestedBalance();
        if(amount > 0){

            //we should check if currentBal - amount not less than 0 ?
            BigDecimal update = currentBal.subtract(BigDecimal.valueOf(amount));
            user.setNonInvestedBalance(update);
        }
        return portfolioDao.updatePortfolioBalance(user);

    }

    @Override
    public Portfolio getPortfolio(int userId) {
        try {
            return portfolioDao.getPortfolio(userId);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Transaction> getTransactionByPortfolioId(int portfolioId) {

        try {
            return transactionDao.getTransactionsForPortfolio(portfolioId);
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public List<Investment> getInvestmentsByPortfolioId(int portfolioId) {
        try {
            return investmentDao.getAllInvestments(portfolioId);
        }catch (DataAccessException ex){
            return null;
        }

    }

    @Override
    public Transaction addTransaction(int portfolioId,Transaction transaction) {
       try {
           Portfolio portfolio=portfolioDao.getPortfolioById(portfolioId);
           if(portfolio.getNonInvestedBalance().compareTo(transaction.getTransactionAmount())>=0) {
               transaction.setPortfolioId(portfolioId);
               transaction.setTimestamp(LocalDateTime.now());

               Crypto crypt = rateForCrypto(transaction.getCryptoName());
               BigDecimal convertBalanceToShare = transaction.getTransactionAmount()
                       .divide(crypt.getRate(), 8, RoundingMode.HALF_DOWN);
               transaction.setShares(convertBalanceToShare);

               transactionDao.addTransaction(transaction);
               BigDecimal newInvestedTotalBalance = portfolio.getInvestedTotalBalance().add(transaction.getTransactionAmount());
               BigDecimal newNonInvestedBalance = portfolio.getNonInvestedBalance().subtract(transaction.getTransactionAmount());
               portfolio.setInvestedTotalBalance(newInvestedTotalBalance);
               portfolio.setNonInvestedBalance(newNonInvestedBalance);
               portfolioDao.updatePortfolioBalance(portfolio);
               return transaction;
           }
          return null;
       }catch (DataAccessException | NullPointerException ex ){
           return null;
       }
    }

    private Crypto rateForCrypto(String symbol) {
        String url = "https://rest.coinapi.io/v1/exchangerate/" + symbol + "/USD";

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("X-CoinAPI-Key", "8099D6E8-EBCA-4742-B47D-639A52B6207B")
                .build();

        Crypto response = webClient.get()
                .retrieve()
                .bodyToMono(Crypto.class)
                .block();

        return response;
    }

}
