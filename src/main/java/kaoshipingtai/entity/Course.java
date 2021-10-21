package kaoshipingtai.entity;

public class Course {
    private int id;
    private String username;
    private String course;
    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Course(String username, String course, Integer score) {
        this.username = username;
        this.course = course;
        this.score = score;
    }

    public Course() {
    }
}
