package wt.restaurant.table;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class TableService {

    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Table> findAll(){
        List<TableEntity> tables = tableRepository.findAll();
        return tables.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Table findById(Long id){
        var tableEntity = tableRepository.findById(id);
        return tableEntity.isPresent()? transformEntity(tableEntity.get()):null;
    }

    public Table create( TableEditRequest tableEditRequest ){
        var tableEntity = new TableEntity(tableEditRequest.getSeats());
        tableEntity = tableRepository.save(tableEntity);
        return transformEntity(tableEntity);

    }

    // gets id to return table object from tableentity
    private Table transformEntity(TableEntity tableEntity){
        return new Table(
                tableEntity.getId(),
                tableEntity.getSeats()
        );

    }



    public Table update(Long id, TableEditRequest tableEditRequest){
        var tableEntityOptional = tableRepository.findById(id);
        if (tableEntityOptional.isEmpty()){
            return null;
        }
        var tableEntity = tableEntityOptional.get();
        tableEntity.setSeats(tableEditRequest.getSeats());
        tableEntity = tableRepository.save(tableEntity);

        return transformEntity(tableEntity);
    }



    // true if deleted false if doesnt exist
    public boolean deleteById(long id){
        if(!tableRepository.existsById(id)){
            return false;
        }
        tableRepository.deleteById(id);
        return true;
    }
}
