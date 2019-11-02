import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ariona.testingSystem.controller.TestController;

import static junit.framework.TestCase.assertNotNull;

public class TestControllerTest {
    TestController controller;

    @Before
    public void setController() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        controller = context.getBean(TestController.class);
    }

    @Test
    public void controllerExist() {
        assertNotNull(controller);
    }

}
