package pl.code.accademy.engine;

import pl.code.accademy.database.UserRepository;
import pl.code.accademy.model.car.Car;
import pl.code.accademy.model.reservation.Reservation;
import pl.code.accademy.model.users.User;

import java.text.SimpleDateFormat;
import java.util.List;

public class AppEngine {

    public static String dateToString(int year, int month, int day) {
        String stringDate = year + "-" + month + "-" + day;
        return stringDate;
    }

    public static boolean dateValidator() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        date.setLenient(false);
        return false;
    }

    public static void carInStockPrint() {
        List<Car> cars = UserRepository.getAllCars();
        System.out.println("Available cars sorted by id: ");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public static void usersInDBPrint() {
        List<User> users = UserRepository.getAllUsers();
        System.out.println("Registered users sorted by id: ");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public static void reservationsFromBDPrint() {
        List<Reservation> reservations = UserRepository.getAllReservations();
        System.out.println("Reservations sorted by id: ");
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }

}
