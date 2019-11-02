import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ariona.testingSystem.service.QuestionService;

import static junit.framework.TestCase.assertNotNull;

public class QuestionServiceTest {
    private QuestionService questionService;

    @Before
    public void before() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        questionService = context.getBean(QuestionService.class);
    }

    @Test
    public void serviceExist() {
        assertNotNull(questionService);
    }

}
