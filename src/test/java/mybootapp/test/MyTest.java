package mybootapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//import mybootapp.model.Course;
//import mybootapp.repo.CourseRepository;
import mybootapp.web.Starter;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class MyTest {

}
