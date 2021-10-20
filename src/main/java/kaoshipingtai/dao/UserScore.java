package kaoshipingtai.dao;

import kaoshipingtai.entity.Course;
import kaoshipingtai.serviceimpl.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserScore implements ScoreService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Course findByName(String name) {
        Course course=new Course();
        String sql= "SELECT score FROM user_score WHERE username=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                course.setCourse(resultSet.getString(3));
            }
        });
        return course;
    }
}
