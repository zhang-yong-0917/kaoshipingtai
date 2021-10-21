package kaoshipingtai.dao;

import kaoshipingtai.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TeacherDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//查找teacher表，主要实现登录
    public Teacher findByNameAndPassword(String username, String password){
        final Teacher teacher=new Teacher();
        String sql = "SELECT * FROM teacher WHERE id=? AND teacher_password=?";
        jdbcTemplate.query(sql, new Object[]{username, password}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                teacher.setTeacherId(resultSet.getInt(1));
                teacher.setTeacherPassword(resultSet.getString(2));
            }
        });
        return teacher;
    }
//实行注册teacher
    public int RegistryTeacher(String username, String password){
        final Teacher teacher=new Teacher();
        String sql = "INSERT INTO  teacher (teacher_name,teacher_password) values (?,?)";

        return jdbcTemplate.update(sql, new Object[]{username, password});

    }




}
