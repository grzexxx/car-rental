package pl.code.accademy.gui;

import pl.code.accademy.database.UserRepository;
import pl.code.accademy.engine.AppEngine;
import pl.code.accademy.model.reservation.Reservation;
import pl.code.accademy.model.users.User;

import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.strip;

public class UserGUI {

    private static Scanner scanner = new Scanner(System.in);

    public static User register() {
        while (true) {
            System.out.println("Login: ");
            String login = scanner.nextLine();

            System.out.println("Password: ");
            String password = scanner.nextLine();

            System.out.println("Repeat password: ");
            String repeatPassword = scanner.nextLine();

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Surname: ");
            String surname = scanner.nextLine();

            System.out.println("PESEL: ");
            String PESEL = scanner.nextLine();

            if (password.equals(repeatPassword) && isNumeric(PESEL)) {
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                user.setStatus("u");
                user.setName(name);
                user.setSurname(surname);
                user.setPESEL(PESEL);
                System.out.println("Correct data");

                return user;
            } else if (!password.equals(repeatPassword)) {
                System.out.println("Password does not match");
            } else {
                System.out.println("Wrong PESEL number");
            }
        }
    }

    public static Reservation reservation() {
        while (true) {
            System.out.println("Enter car id: ");
            String carID = scanner.nextLine();

            System.out.println("Enter your login: ");
            String login = scanner.nextLine();

            System.out.println("Enter year of reservation: ");
            String year = scanner.nextLine();

            System.out.println("Enter month of reservation: ");
            String month = scanner.nextLine();

            System.out.println("Enter day of reservation: ");
            String day = scanner.nextLine();

            User user = new User();
            user.setLogin(login);

            if (isNumeric(carID) && isNumeric(year) && isNumeric(month) && isNumeric(day) && UserRepository.checkExistUser(user)) {
                String dateString = AppEngine.dateToString(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

                Reservation reservation = new Reservation();
                reservation.setCarId(Integer.parseInt(carID));
                reservation.setLogin(login);
                reservation.setDate(dateString);
                reservation.setUserId(UserRepository.getUserId(login));

                return reservation;
            } else {
                System.out.println("Add correct data");
            }
        }
    }

    public static int userMenu() {
        while (true) {
            System.out.println("1. See available vehicles");
            System.out.println("2. Book your car by car id");
            System.out.println("3. End application");

            String choiceString = scanner.nextLine();

            if (isNumeric(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                if (choice == 1 || choice == 2 || choice == 3) {
                    return choice;
                } else {
                    System.out.println("Wrong choice, write correct number: ");
                }
            } else {
                System.out.println("These is not a number, enter correct number: ");
            }
        }
    }


}
