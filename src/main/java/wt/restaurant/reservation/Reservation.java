package wt.restaurant.reservation;

import jakarta.persistence.*;

import java.time.LocalDateTime;


public class Reservation {

    private long id;
    private String info;
    private String mail;
    private int tableIdFk;
    private int guests;
    private LocalDateTime bookedFrom;



    public Reservation(Long id,String info, String mail, int tableIdFk, int guests, LocalDateTime bookedFrom) {
        this.id = id;
        this.info = info;
        this.mail = mail;
        this.tableIdFk = tableIdFk;
        this.guests = guests;
        this.bookedFrom = bookedFrom;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTableIdFk() {
        return tableIdFk;
    }

    public void setTableIdFk(int tableIdFk) {
        this.tableIdFk = tableIdFk;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }


    public LocalDateTime getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDateTime bookedFrom) {
        this.bookedFrom = bookedFrom;
    }
}
