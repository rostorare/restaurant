package gericht;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import wt.restaurant.gericht.GerichtEditRequest;

class GerichtEditRequestTest {

    @Test
    void testGerichtEditRequest() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEditRequest request = new GerichtEditRequest(name, description, price);

        assertEquals(name, request.getName());
        assertEquals(description, request.getBeschreibung());
        assertEquals(price, request.getPreis());
    }
    @Test
    void testSetName() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEditRequest request = new GerichtEditRequest(name, description, price);
        request.setName("Pizza Margherita");
        assertEquals("Pizza Margherita", request.getName());
    }

    @Test
    void testSetBeschreibung() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEditRequest request = new GerichtEditRequest(name, description, price);
        request.setBeschreibung("Thin crust pizza with tomato sauce and mozzarella cheese");
        assertEquals("Thin crust pizza with tomato sauce and mozzarella cheese", request.getBeschreibung());
    }

    @Test
    void testSetPreis() {
        String name = "Spaghetti Bolognese";
        String description = "Spaghetti with a delicious meat sauce";
        double price = 12.99;
        GerichtEditRequest request = new GerichtEditRequest(name, description, price);
        request.setPreis(15.99);
        assertEquals(15.99, request.getPreis());
    }

}
