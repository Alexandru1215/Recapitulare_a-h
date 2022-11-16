package project_test_methods;

import lombok.extern.java.Log;
import modJSlider.SliderDemo;
import modVisual.ProgressBarDemo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
;

public class Main {

    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public static void insertTableInDatabase(Car... cars) {
        try (Session session = sessionFactory.openSession()) {
            Transaction trx = session.beginTransaction();
            Arrays.stream(cars).forEach(session::persist);
            trx.commit();
        }
    }

    public static void insertCars() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Car c1 = new Car();
            c1.setModel("Audi");
            c1.setType("A6 S-Line");
            c1.setGearBox("Automatic");
            c1.setCheckAvailability(CheckAvailability.AVAILABLE);

            session.persist(c1);

            Car c2 = new Car();
            c2.setModel("BMW");
            c2.setType("Seria 3 x-Drive");
            c2.setGearBox("Automatic");
            c2.setCheckAvailability(CheckAvailability.UNAVAILABLE);


            Car c3 = new Car();
            c3.setModel("Ford");
            c3.setType("Mustang Shelby");
            c3.setGearBox("Automatic");
            c3.setCheckAvailability(CheckAvailability.RENTED);


            session.persist(c1);
            session.persist(c2);
            session.persist(c3);

            session.getTransaction().commit();
        }
    }

    public static void insertRentDetails() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            RentDetails rd1 = new RentDetails();
            rd1.setPricePerDay(90);
            rd1.setStartDate("10-10-2022");
            rd1.setStopDate("10-11-2022");

            RentDetails rd2 = new RentDetails();
            rd2.setPricePerDay(100);
            rd2.setStartDate("12-10-2022");
            rd2.setStopDate("20-11-2022");

            RentDetails rd3 = new RentDetails();
            rd3.setPricePerDay(55);
            rd3.setStartDate("10-11-2022");
            rd3.setStopDate("16-11-2022");


            session.persist(rd1);
            session.persist(rd2);
            session.persist(rd3);

            session.getTransaction().commit();
        }
    }

    public static void insertClientDetails() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Client client19 = new Client();
            client19.setName("Marius");
            client19.setEmail("Bam@yahoo.com");
            client19.setPhoneNr("0764xxxxxx");
//
//            Client client5 = new Client();
//            client5.setName("Aurel Grigore");
//            client5.setEmail("speranta@yahoo.com");
//            client5.setPhoneNr("07449933");
//
//            Client client6 = new Client();
//            client6.setName("Alin TheFin");
//            client6.setEmail("martie@gmail.com");
//            client6.setPhoneNr("07666223");

            PaymentEvent paymentEvent =  new PaymentEvent();
            PaymentListener paymentListener =  new PaymentEvenLogger();
            LogPage logPage = new LogPage();
            logPage.notificationHasBeenSent(client19);
//            logPage.notificationHasBeenSent(client5);
//            logPage.notificationHasBeenSent(client6);

            ManagerNotification managerNotification = new ManagerNotification();
            managerNotification.notificationHasBeenSent(client19);
//            managerNotification.notificationHasBeenSent(client5);
//            managerNotification.notificationHasBeenSent(client6);

            PayPoint payPoint = new PayPoint();
//            payPoint.notificationHasBeenSent(client7);
//            payPoint.notificationHasBeenSent(client5);
            payPoint.notificationHasBeenSent(client19);
            payPoint.paymentMade();

            session.persist(client19);
//            session.persist(client5);
//            session.persist(client6);

            session.getTransaction().commit();

        }
    }

    public static void inserPayDetails() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();


            session.beginTransaction().commit();
        }
    }

    public static Car  getCarByID(int id){
        try(Session session = sessionFactory.openSession()){
            Transaction trx= session.beginTransaction();

            return session.get(Car.class,id);


        }
    }
    public static void main(String[] args) {
        System.out.println("Sit back, relax, ejoy the  show!");

//        insertTableInDatabase();
//        insertCars();
//        insertRentDetails();
//        insertClientDetails();
//         inserPayDetails();
        //System.out.println(getCarByID(303));


        //insertClientDetails();



                    //TODO Login - user - pass
      //  WelcomePage wl =  new WelcomePage(getCarByID(303));
        IDandPass iDandPass = new IDandPass();
        LoginPage loginPage = new LoginPage(iDandPass.getLoginIfo());

        // test de primire a platii -  notificare design pattern
        // TODO  -  vreau   sa mi trimita notificare cand clientul plateste  si se confirma;
        //  TODO - vreau sa mi afiseze cand Clientul se aboneaza la notificari
        // TODO vreau  sa ma anunte cand Clientul are user si pass pentur Logare .
        // TODO - vreau sa ii afiseze Client ului lista de maisni 'AVAILABLE ' cand LOGGIIN este executat cu user si pass
        // TODO - vreau sa i trimit notificare Clientului care este inregistrat cu USER SI PASS.


//        Client c =  new Client();
//        Client c1 = new Client();
//        c1.setName("Alex");
//        c1.setEmail("5togo@gmail.com");
//        // obiectul cu care notific
//        PaymentEvent paymentEvent = new PaymentEvent();   // pasul 1
//
//        //folosesc metoda din  interfata Payment Listener
//        // paymentEvent.registerPaymentListener(()->System.out.println(" Test1 "));
//
//        // am creat o abonare la notificare pt p1
//       PaymentListener p1 = new PaymentEvenLogger();     // pas 2
//        // metoda prin care sunt anuanti de primirea platii
//        // paymentEvent.registerPaymentListener(p1);   // pas 3
//       // paymentEvent.registerPaymentListener(p1);
//
//        // dezabonez p1 de la notificare
//        // paymentEvent.unregisterPaymentListener(p1);
//
//
//       // PaymentListener p2 = new PaymentEvenLogger();
////        paymentEvent.registerPaymentListener(p2);
////        paymentEvent.pay();
//        //paymentEvent.registerPaymentListener(p2);
//
//        // notificarea asta imi afiseaza ca s a creat contul
//        LogPage lp = new LogPage();
//        lp.notificationHasBeenSent(c1);
//        lp.notificationHasBeenSent(c);
//
//        // ma anunta ca se proceseaza apoi urm metoda ca sa produs,
//        // dar ideea este ca trbuie vazut cum sa actionam metoda, in functie de ce factor
//        // adica de plata.
//            PayPoint pp =  new PayPoint();
//            pp.notificationHasBeenSent(c);
//            pp.notificationHasBeenSent(c1);
//            pp.paymentMade();
//            pp.paymentMade();
//// metoda prin care sunt anuanti de primirea platii
//        //paymentEvent.registerPaymentListener(p1);  // pas 4
//
//        //paymentEvent.registerPaymentListener(p2);
//        //pp.paymentMade();
//        paymentEvent.pay();
//
//
//
//        ManagerNotification mn = new ManagerNotification();
//        mn.notificationHasBeenSent(c1);
//        mn.notificationHasBeenSent(c);
//       // mn.notificationHasBeenSent();
//
////        paymentEvent.registerPaymentListener(mn::notificationHasBeenSent);
//
////        c.getManagerNotification();
//        //System.out.println(c.getManagerNotification());

    }

}
