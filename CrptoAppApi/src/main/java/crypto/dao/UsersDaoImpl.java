package crypto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsersDaoImpl implements UsersDao{
    @Autowired
    JdbcTemplate jdbc;
}
