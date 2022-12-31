package wt.restaurant.tisch;

public class TischEditRequest {
    private int seats;
    private String info;

    public TischEditRequest(int seats,String info)
    {
        this.seats = seats;
        this.info = info;
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
