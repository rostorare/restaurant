package wt.restaurant.gericht;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//service contains businesslogic
@Service
public class GerichtService {

    private final GerichtRepository gerichtRepository;

    public GerichtService(GerichtRepository gerichtRepository) {
        this.gerichtRepository = gerichtRepository;
    }

    public List<Gericht> findAll(){
        List<GerichtEntity> gerichte = gerichtRepository.findAll();
        return gerichte.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Gericht findById(Long id){
        //findbyId return optional gerichtentity also entweder gerichtentity oder null, deswegen
        //muss man beim retun prüfen ob es eine entity is odwer nicht und if ya dann transform else null
        var gerichtEntity = gerichtRepository.findById(id);
        return gerichtEntity.isPresent()? transformEntity(gerichtEntity.get()):null;
        //return gerichtEntity.map(this::transformEntity).orElse(null);
    }

    public Gericht create(GerichtEditRequest request){
        var gerichtEntity = new GerichtEntity(request.getName(),request.getBeschreibung(),request.getPreis());
        gerichtEntity = gerichtRepository.save(gerichtEntity);
        return transformEntity(gerichtEntity);

    }
    private Gericht transformEntity(GerichtEntity gerichtEntity){
        return new Gericht(
                gerichtEntity.getId(),
                gerichtEntity.getName(),
                gerichtEntity.getBeschreibung(),
                gerichtEntity.getPreis()
        );

    }

    public Gericht update(Long id,GerichtEditRequest request) {
        var gerichtEntityOptional = gerichtRepository.findById(id);
        if (gerichtEntityOptional.isEmpty()) {
            return null;
        }
        var gerichtEntity = gerichtEntityOptional.get();
        gerichtEntity.setName(request.getName());
        gerichtEntity.setBeschreibung(request.getBeschreibung());
        gerichtEntity.setPreis(request.getPreis());
        gerichtEntity = gerichtRepository.save(gerichtEntity);

        return transformEntity(gerichtEntity);
    }

    public boolean deleteById(long id){
        if(!gerichtRepository.existsById(id)){
            return false;
        }
        gerichtRepository.deleteById(id);
        return true;
    }
}
