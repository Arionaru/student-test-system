package ru.ariona.testingsystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ariona.testingsystem.controller.TestController;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TestController controller = context.getBean(TestController.class);
        controller.startTest();
    }
}
