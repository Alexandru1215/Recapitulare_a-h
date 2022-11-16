package project_test_methods;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String model;
    @Column
    private String type;
    @Column
    private String gearBox;

    @Enumerated(EnumType.STRING)
    private CheckAvailability checkAvailability;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
