package wt.restaurant.reservation;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int tableIdFk;
    private int guests;
    private String name;
    private String mail;
    private String phone;
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedUntil;


}
