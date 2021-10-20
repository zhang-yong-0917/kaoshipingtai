package kaoshipingtai.entity;

public class Course {
    private int id;
    private String course;
    private String score;

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Course(String course, String score) {
        this.course = course;
        this.score = score;
    }

    public Course() {
    }
}
