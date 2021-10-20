package kaoshipingtai.dao;

import kaoshipingtai.serviceimpl.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserScore implements ScoreService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findByName(String name) {
        return 0;
    }
}
