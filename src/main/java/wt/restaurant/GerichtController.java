package wt.restaurant;

import org.springframework.http.ResponseEntity;
import wt.restaurant.Gericht;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static wt.restaurant.Typ.*;


@RestController
public class GerichtController {

    private List<Gericht> gerichte;

    public GerichtController(){
        gerichte = new ArrayList<>();
        gerichte.add(new Gericht(1,"Fondue","Flüssiger Käse mit Brot & Kartoffeln",HS,19.95));
        gerichte.add(new Gericht(2,"Schwarztee","300ml Schwarztee",GH,3.00));
        gerichte.add(new Gericht(3,"Kuchen","Zitronenkuche",NS,5.20));
    }

    @GetMapping(path = "/api/v1/gerichte")
    public ResponseEntity<List<Gericht>> fetchGerichte(){
        return ResponseEntity.ok(gerichte);
    }
}
