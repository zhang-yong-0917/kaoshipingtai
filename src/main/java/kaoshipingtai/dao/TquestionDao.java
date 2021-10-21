package kaoshipingtai.dao;

import kaoshipingtai.entity.Tquestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class TquestionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //随机生成试卷
    public ArrayList<Tquestion>  CreatePaper(){
        final  ArrayList<Tquestion> arrayList=new ArrayList<>();
        String sql="";
        jdbcTemplate.query(sql, new Object[]{},new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

            }
        });
        return  arrayList;

    }
    //增加例题
    public   int AddQuestion(String topic,String option){
        String sql="INSERT INTO exam_select (topic,option) VALUES (?,?)";
        return jdbcTemplate.update(sql,topic,option);
    }
    //删除例题
    public   int DeleteQuestion(int id){
        String sql="DELETE FROM exam_select where id=?";
        return jdbcTemplate.update(sql,id);
    }
    //修改例题
    public int  UpdateQuesetion(String topic,String option, int id){
        String sql="UPDATE exam_select SET topic=? , option=? where id=?";
        return  jdbcTemplate.update(sql,topic,option,id);
    }
    //比较答案
    public int CompareAnswer(){
        String sql="";
         jdbcTemplate.query(sql, new Object[]{},new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

            }
        });
        return 0;
    }
}
