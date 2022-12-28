package wt.restaurant.table;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TableController {

    private final String apiV1 = "/api/v1/table/";
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping(path = apiV1)
    public ResponseEntity<List<Table>> fetchTables(){
        return ResponseEntity.ok(tableService.findAll());}

    @GetMapping(path = "/api/v1/table/{id}")
    public ResponseEntity<Table> fetchTableById(@PathVariable Long id){
        var table = tableService.findById(id);
        return table != null? ResponseEntity.ok(table):ResponseEntity.notFound().build();
    }


    @PostMapping(path = apiV1)
    public ResponseEntity<Void> createTable(@RequestBody TableEditRequest tableEditRequest) throws URISyntaxException {
    var table = tableService.create(tableEditRequest);
    URI uri = new URI(apiV1 + table.getId());
    return ResponseEntity.created(uri).build();
}

    @PutMapping(path = apiV1+"{id}")
    public ResponseEntity<Table> updateTable(@PathVariable Long id,@RequestBody TableEditRequest tableEditRequest){
        var table = tableService.update(id,tableEditRequest);
        return table != null? ResponseEntity.ok(table): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = apiV1+"{id}")
    public  ResponseEntity<Void> deleteTable(@PathVariable long id){
        boolean succesful = tableService.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
