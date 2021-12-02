package crypto.dao;

import crypto.entity.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InvestmentDaoImpl implements InvestmentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static final  class  investmentMapper implements RowMapper<Investment> {
        public Investment mapRow(ResultSet resultSet, int i) throws SQLException {
            Investment investments=new Investment();
            investments.setInvestmentId(resultSet.getInt("investmentId"));
            investments.setPortfolioId(resultSet.getInt("portfolioId"));
            investments.setCryptoName(resultSet.getString("cryptoName"));
            investments.setInvestedAmount(resultSet.getBigDecimal("investedAmount"));
            investments.setShares(resultSet.getInt("shares"));

            return investments;
        }
    }

    @Override
    public List<Investment> getAllInvestments() throws DataAccessException {
        final String SELECT_Investment = "SELECT * FROM Investment";
        return jdbcTemplate.query(SELECT_Investment, new investmentMapper());
    }
}
