package wt.restaurant.tisch;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")
public class TischController {

    private final String apiV1 = "/api/v1/tische";
    private final TischService tischService;

    public TischController(TischService tischService) {
        this.tischService = tischService;
    }

    @GetMapping(path = apiV1)
    public ResponseEntity<List<Tisch>> fetchTischs(){
        return ResponseEntity.ok(tischService.findAll());}

    @GetMapping(path = "/api/v1/tische/{id}")
    public ResponseEntity<Tisch> fetchTischById(@PathVariable Long id){
        var tisch = tischService.findById(id);
        return tisch != null? ResponseEntity.ok(tisch):ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/tische")
    public ResponseEntity<Void> createTisch(@RequestBody TischEditRequest tischEditRequest) throws URISyntaxException {
    var tisch = tischService.create(tischEditRequest);
    URI uri = new URI("api/v1/tische/" + tisch.getId());
    return ResponseEntity.created(uri).build();
}

    @PutMapping(path = apiV1+"/{id}")
    public ResponseEntity<Tisch> updateTisch(@PathVariable Long id,@RequestBody TischEditRequest tischEditRequest){
        var tisch = tischService.update(id,tischEditRequest);
        return tisch != null? ResponseEntity.ok(tisch): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = apiV1+"/{id}")
    public  ResponseEntity<Void> deleteTisch(@PathVariable long id){
        boolean succesful = tischService.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }




}
