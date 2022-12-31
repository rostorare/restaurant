package wt.restaurant.tisch;

;
public class Tisch {
    private long id;
    private int seats;
    private String info;

    public Tisch(long id, int seats,String info) {
        this.id = id;
        this.seats = seats;
        this.info = info;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
