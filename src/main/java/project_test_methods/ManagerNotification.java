package project_test_methods;

public class ManagerNotification implements NotificationListener{


    private void sendNotification(){
        System.out.println("New cars available for best costumers! ");
    }
//    @Override
//    public void notificationHasBeenSent() {
//        sendNotification();
//    }


    @Override
    public void notificationHasBeenSent(Client client ) {
        sendNotification();
    }
}
