import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ariona.testingSystem.domain.Student;
import ru.ariona.testingSystem.service.StudentService;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class StudentServiceTest {

    private StudentService studentService;

    @Before
    public void getService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
         studentService = context.getBean(StudentService.class);
    }
    @Test
    public void newStudent() {
        Student student = studentService.getByName("Katya");
        assertNotNull(student);
    }

    @Test
    public void getPoint() {
        Student student = studentService.getByName("Katya");
        assertEquals(0,student.getPoint());
    }

    @Test
    public void incPoint() {
        Student student = studentService.getByName("Katya");
        for (int i = 0; i < 5; i++) {
            student.incrementPoint();
        }
        assertEquals(5,student.getPoint());
    }

    @Test
    public void getStudent() {
        Student student = studentService.getByName("Petya");
        assertNotNull(student);
    }



}
