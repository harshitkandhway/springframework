package springframework.day2.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("springframework.day2.scope");
        HotelGuestService hotelGuestService = applicationContext.getBean(HotelGuestService.class);
        System.out.println(hotelGuestService);
        HotelGuestService hotelGuestService1 = applicationContext.getBean(HotelGuestService.class);
        System.out.println(hotelGuestService1);
        //hotelGuestService.create(new HotelGuestEntry("ram",123456789));
    }
}
