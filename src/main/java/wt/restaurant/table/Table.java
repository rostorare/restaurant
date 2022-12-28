package wt.restaurant.table;

;
public class Table {
    private long id;
    private int seats;

    public Table(long id, int seats) {
        this.id = id;
        this.seats = seats;
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
}
