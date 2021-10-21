package test;

import kaoshipingtai.ExamApplication;
import kaoshipingtai.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = ExamApplication.class)
class ExamApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void test() {
       userDao.create("aa","111");

    }

}
