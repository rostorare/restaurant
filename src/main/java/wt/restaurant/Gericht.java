package wt.restaurant;
enum Typ {VS,HS,NS,GK,GH,GA};
public class Gericht {
    private long id;
    private String name;
    private String beschreibung;
    private Typ typ;
    //Vorspeise, Hauptspeise, Nachspeise, Getränke Kalt, Getränke Heiss, Getränke Alkohol
    private double preis;

    public Gericht(long id, String name, String beschreibung,Typ typ, double preis) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.typ = typ;
        this.preis = preis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public void setName(String name) {
        name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        beschreibung = beschreibung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        preis = preis;
    }
}
