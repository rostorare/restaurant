package wt.restaurant.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Entity(name = "reservationen")
public class ReservationEntity {

        @jakarta.persistence.Id
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
        @Column(name = "info")
        private String info;
        @Column(name = "mail")
        private String mail;
        @Column(name = "tableIdFk")
        private int tableIdFk;
        @Column(name = "guests")
        private int guests;
       @Column(name= "bookedFrom")
          private LocalDateTime bookedFrom;


    protected ReservationEntity(){};
    public ReservationEntity(String info, String mail, int tableIdFk, int guests, LocalDateTime bookedFrom) {
        this.info = info;
        this.mail = mail;
        this.tableIdFk = tableIdFk;
        this.guests = guests;
        this.bookedFrom = bookedFrom;

    }

    public long getId() {
            return id;
        }


        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public int getTableIdFk() {
            return tableIdFk;
        }

        public void setTableIdFk(int tableIdFk) {
            this.tableIdFk = tableIdFk;
        }

        public int getGuests() {
            return guests;
        }

        public void setGuests(int guests) {
            this.guests = guests;
        }



        public LocalDateTime getBookedFrom() {
            return bookedFrom;
        }

        public void setBookedFrom(LocalDateTime bookedFrom) {
            this.bookedFrom = bookedFrom;
        }
    }


