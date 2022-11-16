package project_test_methods;

import java.util.ArrayList;
import java.util.List;

public class PaymentEvent implements PaymentClient {

    private final List<PaymentListener> paymentListeners = new ArrayList<>();


    void pay(){    // note about pay
        //do smth
        paymentListeners.forEach(PaymentListener::paymentMade);
    }

    void registerPaymentListener(PaymentListener paymentL){
        paymentListeners.add(paymentL);
    }

    void unregisterPaymentListener(PaymentListener paymentL){
        paymentListeners.remove(paymentL);
    }

    @Override
    public void unregistredPaymentListener(PaymentListener pp) {

    }
}
