package wt.restaurant.tisch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;


@Entity(name = "tische")
public class TischEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "seats", nullable = false)
    private int seats;
    @Column(name ="info")
    private String info;

    protected TischEntity(){};

    public TischEntity(int seats,String info) {

        this.seats = seats;
        this.info=info;
    }

    public long getId() {
        return id;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
