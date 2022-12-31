package wt.restaurant.tisch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TischRepository extends JpaRepository<TischEntity, Long> {
    List<TischEntity> findAllByInfo(String info);
 //   List<TischEntity> findAllBySeats(int seats);
}
