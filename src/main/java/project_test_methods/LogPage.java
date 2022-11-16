package project_test_methods;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LogPage implements NotificationListener{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int accountId;
    @Column
    private String user;
    @Column
    private String pass;


//    @Override
//    public void notificationHasBeenSent() {
//        System.out.println("Account has been created! ");
//    }


    @Override
    public void notificationHasBeenSent(Client client) {
        System.out.println("Account has been created! ");
    }
}
