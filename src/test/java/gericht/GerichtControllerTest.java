package gericht;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import wt.restaurant.gericht.Gericht;
import wt.restaurant.gericht.*;
import wt.restaurant.gericht.GerichtEditRequest;
import wt.restaurant.gericht.GerichtService;

@ExtendWith(MockitoExtension.class)
public class GerichtControllerTest {

    @Mock
    private GerichtService gerichtService;

    @InjectMocks
    private GerichtController controller;

    @Test
    void testFetchGerichte() {
        // Arrange
        Gericht gericht1 = new Gericht(1L, "Spaghetti Bolognese", "Spaghetti with a delicious meat sauce", 12.99);
        Gericht gericht2 = new Gericht(2L, "Pizza Margherita", "Thin crust pizza with tomato sauce and mozzarella cheese", 15.99);
        when(gerichtService.findAll()).thenReturn(List.of(gericht1, gericht2));

        // Act
        ResponseEntity<List<Gericht>> response = controller.fetchGerichte();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).containsExactly(gericht1, gericht2);
    }

    @Test
    void testFetchGerichtById_Success() {
        // Arrange
        Gericht gericht1 = new Gericht(1L, "Spaghetti Bolognese", "Spaghetti with a delicious meat sauce", 12.99);
        when(gerichtService.findById(1L)).thenReturn(gericht1);

        // Act
        ResponseEntity<Gericht> response = controller.fetchGerichtById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(gericht1);
    }

    @Test
    void testFetchGerichtById_NotFound() {
        // Arrange
        when(gerichtService.findById(1L)).thenReturn(null);

        // Act
        ResponseEntity<Gericht> response = controller.fetchGerichtById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    void testCreateGericht() throws URISyntaxException {
        // Arrange
        GerichtEditRequest request = new GerichtEditRequest("Spaghetti Bolognese", "Spaghetti with a delicious meat sauce", 12.99);
        Gericht gericht = new Gericht(1L, request.getName(), request.getBeschreibung(), request.getPreis());
        when(gerichtService.create(request)).thenReturn(gericht);

        // Act
        ResponseEntity<Void> response = controller.createGericht(request);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getHeaders().getLocation()).isEqualTo(new URI("/api/v1/gerichte/1"));
    }
}
