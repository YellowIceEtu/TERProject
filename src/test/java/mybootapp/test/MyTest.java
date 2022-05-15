package mybootapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mybootapp.dao.JpaDao;
import mybootapp.model.Formation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//import mybootapp.model.Course;
//import mybootapp.repo.CourseRepository;
import mybootapp.Starter;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class MyTest {
    @Autowired
    JpaDao dao;


    @Test
    public void addFormation(){
        var p1 = new Formation(12, "a", null, null, "a", "a", "a", "a", 1, 1, 1, null);
        dao.addFormation(p1);

        assertEquals(12, p1.getCodeFormation());

    }


}
