package gericht;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import wt.restaurant.gericht.GerichtEntity;

public class GerichtEntityTest {
    @Test
    void testGerichtEntity() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEntity gericht = new GerichtEntity(name, description, price);

        assertEquals(name, gericht.getName());
        assertEquals(description, gericht.getBeschreibung());
        assertEquals(price, gericht.getPreis());
    }
    @Test
    void testSetName() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEntity gericht = new GerichtEntity(name, description, price);
        gericht.setName("Pizza Margherita");
        assertEquals("Pizza Margherita", gericht.getName());
    }

    @Test
    void testSetBeschreibung() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEntity gericht = new GerichtEntity(name, description, price);
        gericht.setBeschreibung("Thin crust pizza with tomato sauce and mozzarella cheese");
        assertEquals("Thin crust pizza with tomato sauce and mozzarella cheese", gericht.getBeschreibung());
    }

    @Test
    void testSetPreis() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEntity gericht = new GerichtEntity(name, description, price);
        gericht.setPreis(15.99);
        assertEquals(15.99, gericht.getPreis());
    }
}
