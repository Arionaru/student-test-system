package ru.ariona.testingSystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ariona.testingSystem.controller.TestController;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TestController controller = context.getBean(TestController.class);
        controller.startTest();
    }
}
