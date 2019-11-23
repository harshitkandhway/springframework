package springframework.day2.scope;

public class HotelGuestEntry {
    private String name;
    private int phone;

    public HotelGuestEntry(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }
}
