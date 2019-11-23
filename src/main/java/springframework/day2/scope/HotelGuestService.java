package springframework.day2.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class HotelGuestService {
    @Autowired
    private CheckinManager checkinManager;

    public void create(HotelGuestEntry hotelGuestEntry){
        if(checkinManager.hasCheckedIn(hotelGuestEntry.getName()))
            System.out.println("Welcome "+hotelGuestEntry.getName()+" ...!");
        else
            System.out.println("Guest has not checked in...!");
    }
}
