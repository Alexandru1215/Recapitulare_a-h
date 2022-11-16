package project_test_methods;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;
    @Column
    String email;
    @Column
    String phoneNr;


//    @JoinColumn(name = "notification")
//    private ManagerNotification managerNotification;


}
