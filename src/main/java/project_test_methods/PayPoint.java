package project_test_methods;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class PayPoint implements PaymentListener , NotificationListener{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payId;
    @Column
    private int cardNr;
    @Column
    private String cardHolderName;
    @Column
    private int issueDate;
    @Column
    private int expirationDate;
    @Column
    private int startDate;
    @Column
    private int  endDate;


    @Enumerated(EnumType.STRING)
    private Price pricePerDay;


    @Override
    public void paymentMade() {
        System.out.println("Payment done!");
    }

//    @Override
//    public void notificationHasBeenSent() {
//        System.out.println("Payment is processing .... ");
//    }

    @Override
    public void notificationHasBeenSent(Client client) {
        System.out.println("Payment is processing .... ");
    }
}
