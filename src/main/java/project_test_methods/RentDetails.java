package project_test_methods;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    private String startDate;
    @Column
    private String stopDate;
    @Column
    private int pricePerDay;
}
