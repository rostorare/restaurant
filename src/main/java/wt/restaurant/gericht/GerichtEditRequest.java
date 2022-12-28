package wt.restaurant.gericht;

public class GerichtEditRequest {

    private String name;
    private String beschreibung;
    private double preis;


    public GerichtEditRequest(String name, String beschreibung, double preis) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
