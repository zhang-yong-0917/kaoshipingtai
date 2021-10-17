package dao;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao implements UserService {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public int create(String username,String password) {
            return jdbcTemplate.update("insert into user(username,password)values (?,?)",username,password);
        }

        public User findByName(String name) {
            final User user = new User();
            String sql = "SELECT username FROM user WHERE username=?";
            jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    user.setUsername(resultSet.getString(1));
                }
            });
            return user;
        }

        @Override
        public User findByNameAndPassword(String username, String password) {
            final User user = new User();
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            jdbcTemplate.query(sql, new Object[]{username, password}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    user.setUsername(resultSet.getString(1));
                    user.setPassword(resultSet.getString(2));
                }
            });
            return user;
        }
    }

