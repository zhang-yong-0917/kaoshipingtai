package kaoshipingtai.dao;

import kaoshipingtai.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MessageDao {
    @Autowired
   private JdbcTemplate jdbcTemplate;

    //展示考试须知
    public Message ShowMesssage(int id){
        final  Message message=new Message();
        String sql="SELECT  FROM exam_message  where id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                message.setMessage(rs.getString(1));
                message.setDateStart(rs.getDate(2));
                message.setDateEnd(rs.getDate(3));
            }
        });
        return message;
    }
    //修改考试须知
    public int  UpdateMessage(String exam_context, Date  exam_start_date, Date exam_end_date,int id){

        String sql = "UPDATE exam_message SET exam_context=? , exam_start_date=?,exam_end_date=? where id=?";
        return jdbcTemplate.update(sql,exam_context,exam_start_date,exam_end_date,id);

    }
    //添加考试须知
    public  int  AddMessage(String exam_context, Date  exam_start_date, Date exam_end_date){

        String sql = "INSERT INTO exam_message (exam_context,exam_start_date,exam_end_date) VALUES (?,?,?)";
        return jdbcTemplate.update(sql,exam_context,exam_start_date,exam_end_date);

    }
    //删除考试须知
    public int  DeleteMessage(int id){

        String sql="DELETE FROM exam_message where id=?";
        return   jdbcTemplate.update(sql,id);
    }
}
