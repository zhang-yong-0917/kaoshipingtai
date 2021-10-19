package kaoshipingtai.entity;

public class Teacher {
private  int TeacherId;
private  String TeacherName;
private String TeacherPassword;

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        this.TeacherId = teacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        this.TeacherName = teacherName;
    }

    public String getTeacherPassword() {
        return TeacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.TeacherPassword = teacherPassword;
    }
}
