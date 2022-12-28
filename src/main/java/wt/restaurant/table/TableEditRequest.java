package wt.restaurant.table;

public class TableEditRequest {
    private int seats;

    public TableEditRequest(int seats){
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
