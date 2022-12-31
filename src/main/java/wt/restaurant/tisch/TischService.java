package wt.restaurant.tisch;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class TischService {

    private final TischRepository tischRepository;

    public TischService(TischRepository tischRepository) {
        this.tischRepository = tischRepository;
    }

    public List<Tisch> findAll(){
        List<TischEntity> tischs = tischRepository.findAll();
        return tischs.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Tisch findById(Long id){
        var tischEntity = tischRepository.findById(id);
        return tischEntity.isPresent()? transformEntity(tischEntity.get()):null;
    }

    public Tisch create( TischEditRequest tischEditRequest ){
        var tischEntity = new TischEntity(tischEditRequest.getSeats(), tischEditRequest.getInfo());
        tischEntity = tischRepository.save(tischEntity);
        return transformEntity(tischEntity);

    }

    // gets id to return tisch object from tischentity
    private Tisch transformEntity(TischEntity tischEntity){
        return new Tisch(
                tischEntity.getId(),
                tischEntity.getSeats(),
                tischEntity.getInfo()
        );

    }



    public Tisch update(Long id, TischEditRequest tischEditRequest){
        var tischEntityOptional = tischRepository.findById(id);
        if (tischEntityOptional.isEmpty()){
            return null;
        }
        var tischEntity = tischEntityOptional.get();
        tischEntity.setSeats(tischEditRequest.getSeats());
        tischEntity = tischRepository.save(tischEntity);

        return transformEntity(tischEntity);
    }



    // true if deleted false if doesnt exist
    public boolean deleteById(long id){
        if(!tischRepository.existsById(id)){
            return false;
        }
        tischRepository.deleteById(id);
        return true;
    }
}
