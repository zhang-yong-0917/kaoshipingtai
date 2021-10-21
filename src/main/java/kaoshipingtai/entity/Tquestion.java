package kaoshipingtai.entity;

public class Tquestion {
    private  int TquestionId;
    private  String TquestionOption;
    private  String TquestionTopic;

    public int getTquestionId() {
        return TquestionId;
    }

    public void setTquestionId(int tquestionId) {
        this.TquestionId = tquestionId;
    }

    public String getTquestionOption() {
        return TquestionOption;
    }

    public void setTquestionOption(String tquestionOption) {
        this.TquestionOption = tquestionOption;
    }

    public String getTquestionTopic() {
        return TquestionTopic;
    }

    public void setTquestionTopic(String tquestionTopic) {
        this.TquestionTopic = tquestionTopic;
    }
}
