package kaoshipingtai.serviceimpl;

public interface ScoreService {
    /**
     *  通过用户名查询成绩
     * */
    int findByName(String name);
}
