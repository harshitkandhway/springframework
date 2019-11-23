package springframework.day1.ordering;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext injector = new AnnotationConfigApplicationContext("springframework.day1.ordering");
    }
}
