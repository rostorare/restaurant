package wt.restaurant.gericht;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GerichtRepository extends JpaRepository<GerichtEntity,Long> {

    List<GerichtEntity> findAllByName(String name);

}
