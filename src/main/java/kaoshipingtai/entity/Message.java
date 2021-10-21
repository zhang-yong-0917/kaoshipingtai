package kaoshipingtai.entity;

import java.util.Date;

public class Message {
    private int Id;
    private String Message;
    private Date DateStart;
    private  Date DateEnd;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date dateStart) {
        this.DateStart = dateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.DateEnd = dateEnd;
    }
}
