package wt.restaurant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;




@RestController
public class GerichtController {


    private final GerichtService gerichtService;

    public GerichtController(GerichtService gerichtService) {
        this.gerichtService = gerichtService;
    }


    @GetMapping(path = "/api/v1/gerichte")
    public ResponseEntity<List<Gericht>> fetchGerichte(){
        return ResponseEntity.ok(gerichtService.findAll());
    }
    @GetMapping(path = "api/v1/gerichte/{id}")
    public ResponseEntity<Gericht> fetchGerichtById(@PathVariable Long id){
        var gericht = gerichtService.findById(id);
        //falls nicht gefunden status return 404
        return gericht != null? ResponseEntity.ok(gericht): ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/gerichte")
    public ResponseEntity<Void> createGericht(@RequestBody GerichtEditRequest request) throws URISyntaxException {
        var gericht = gerichtService.create(request);
        URI uri = new URI("/api/v1/gerichte/"+ gericht.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path ="/api/v1/gerichte/{id}")
    public ResponseEntity<Gericht> updateGericht(@PathVariable Long id,@RequestBody GerichtEditRequest request){
        var gericht = gerichtService.update(id,request);
        return gericht != null? ResponseEntity.ok(gericht): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path ="/api/v1/gerichte/{id}")
    public ResponseEntity<Void> deleteGericht(@PathVariable Long id){
        boolean successful = gerichtService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
