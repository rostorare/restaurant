package wt.restaurant.reservation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//service contains businesslogic
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll(){
        List<ReservationEntity> reservatione = reservationRepository.findAll();
        return reservatione.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Reservation findById(Long id){
        //findbyId return optional reservationentity also entweder reservationentity oder null, deswegen
        //muss man beim retun prüfen ob es eine entity is odwer nicht und if ya dann transform else null
        var reservationEntity = reservationRepository.findById(id);
        return reservationEntity.isPresent()? transformEntity(reservationEntity.get()):null;
        //return reservationEntity.map(this::transformEntity).orElse(null);
    }

    public Reservation create(ReservationEditRequest request){
        var reservationEntity = new ReservationEntity(request.getInfo(),request.getMail(),
                request.getTableIdFk(),request.getGuests(),request.getBookedFrom());
        reservationEntity = reservationRepository.save(reservationEntity);
        return transformEntity(reservationEntity);

    }
    private Reservation transformEntity(ReservationEntity reservationEntity){
        return new Reservation(
                reservationEntity.getId(),
                reservationEntity.getInfo(),
                reservationEntity.getMail(),
                reservationEntity.getTableIdFk(),
                reservationEntity.getGuests(),
                reservationEntity.getBookedFrom()

        );

    }

    public Reservation update(Long id,ReservationEditRequest request) {
        var reservationEntityOptional = reservationRepository.findById(id);
        if (reservationEntityOptional.isEmpty()) {
            return null;
        }
        var reservationEntity = reservationEntityOptional.get();
        reservationEntity.setInfo(request.getInfo());
        reservationEntity.setMail(request.getMail());
        reservationEntity.setTableIdFk(request.getTableIdFk());
        reservationEntity.setGuests(request.getGuests());
        reservationEntity.setBookedFrom(request.getBookedFrom());
        reservationEntity = reservationRepository.save(reservationEntity);

        return transformEntity(reservationEntity);
    }

    public boolean deleteById(long id){
        if(!reservationRepository.existsById(id)){
            return false;
        }
        reservationRepository.deleteById(id);
        return true;
    }
}
