package project_test_methods;

public class PaymentEvenLogger implements PaymentListener {


   private void logEvent(){
       System.out.println("Payment received!");
   }



    @Override
    public void paymentMade() {
        logEvent();

    }
}
