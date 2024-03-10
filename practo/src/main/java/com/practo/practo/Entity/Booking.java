package com.practo.practo.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , referencedColumnName = "id")
    private Doctor doctorID;

    private long patientID;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private  boolean morningSlotAvailable;
    @Column(nullable = false)
    private  boolean afternoonSlotAvailable;
    @Column(nullable = false)
    private  boolean eveningSlotAvailable;
}
