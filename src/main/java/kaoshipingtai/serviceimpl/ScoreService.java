package kaoshipingtai.serviceimpl;

import kaoshipingtai.entity.Course;

public interface ScoreService {
    /**
     *  通过用户名查询成绩
     * */
    Course findByName(String name);
}
