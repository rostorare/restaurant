package gericht;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wt.restaurant.gericht.*;

class GerichtServiceTest {


    @Mock
    private GerichtRepository gerichtRepository;

    private GerichtService gerichtService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        gerichtService = new GerichtService(gerichtRepository);
    }

    @Test
    void testFindAll() {
        // Arrange no entity
        GerichtEntity gerichta = new GerichtEntity("Spaghetti Bolognese", "Spaghetti with a delicious meat sauce", 12.99);
        gerichta.setId(1L);
        GerichtEntity gerichtb = new GerichtEntity("Pizza Margherita", "Thin crust pizza with tomato sauce and mozzarella cheese", 15.99);
        gerichtb.setId(2L);
        when(gerichtRepository.findAll()).thenReturn(List.of(gerichta, gerichtb));

        // Act
        List<Gericht> gerichte = gerichtService.findAll();

        // Assert
        assertEquals(2, gerichte.size());
        Gericht gericht1 = gerichte.get(0);
        assertEquals(1L, gericht1.getId());
        assertEquals("Spaghetti Bolognese", gericht1.getName());
        assertEquals("Spaghetti with a delicious meat sauce", gericht1.getBeschreibung());
        assertEquals(12.99, gericht1.getPreis());
        Gericht gericht2 = gerichte.get(1);
        assertEquals(2L, gericht2.getId());
        assertEquals("Pizza Margherita", gericht2.getName());
        assertEquals("Thin crust pizza with tomato sauce and mozzarella cheese", gericht2.getBeschreibung());
        assertEquals(15.99, gericht2.getPreis());
    }



}
