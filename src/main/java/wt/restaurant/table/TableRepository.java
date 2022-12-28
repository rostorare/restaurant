package wt.restaurant.table;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TableRepository extends JpaRepository<TableEntity, Long> {
    List<TableEntity> findAllById(Long id);
 //   List<TableEntity> findAllBySeats(int seats);
}
