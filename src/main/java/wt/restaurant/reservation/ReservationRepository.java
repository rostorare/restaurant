package wt.restaurant.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {
    List<ReservationEntity> findAllByMail(String mail);

}
