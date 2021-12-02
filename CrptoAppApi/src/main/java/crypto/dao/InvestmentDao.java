package crypto.dao;

import crypto.entity.Investment;

import java.util.List;

public interface InvestmentDao {
    List<Investment> getAllInvestments();
}
