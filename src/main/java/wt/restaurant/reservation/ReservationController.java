package wt.restaurant.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService){this.reservationService=reservationService;}
    private final String api = "/api/v1/reservationen";

    @GetMapping(path = api)
    public ResponseEntity<List<Reservation>> fetchReservationen(){
        return ResponseEntity.ok(reservationService.findAll());

    }
    @GetMapping(path = api+"/{id}")
    public ResponseEntity<Reservation> fetchReservationById(@PathVariable Long id){
        var reservation = reservationService.findById(id);
        //falls nicht gefunden status return 404
        return reservation != null? ResponseEntity.ok(reservation): ResponseEntity.notFound().build();
    }


    @PostMapping(path = api)
    public ResponseEntity<Void> createReservation(@RequestBody ReservationEditRequest request) throws URISyntaxException {
        var reservation = reservationService.create(request);
        URI uri = new URI(api+ reservation.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path =api+"/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id,@RequestBody ReservationEditRequest request){
        var reservation = reservationService.update(id,request);
        return reservation != null? ResponseEntity.ok(reservation): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path =api+"/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        boolean successful = reservationService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
