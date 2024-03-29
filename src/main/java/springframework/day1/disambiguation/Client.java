package springframework.day1.disambiguation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext injector = new AnnotationConfigApplicationContext("springframework.day1.disambiguation");
        GuestBookServices guestBookServices = injector.getBean(GuestBookServices.class);

        guestBookServices.create(new GuestBookEntry("Harshit","This is content for the message"),"192.168.10.1");
        System.out.println(guestBookServices);

        GuestBookServices guestBookServices2 = injector.getBean(GuestBookServices.class);
        System.out.println(guestBookServices2);
    }
}
