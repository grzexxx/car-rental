package pl.code.accademy.gui;

import pl.code.accademy.database.UserRepository;
import pl.code.accademy.engine.AppEngine;
import pl.code.accademy.model.car.Car;
import pl.code.accademy.model.users.User;


import java.util.Scanner;


import static org.apache.commons.lang3.StringUtils.isNumeric;

public class GUI {

    static Scanner scanner = new Scanner(System.in);

    public static int helloMenu() {
        while (true) {
            System.out.println("1. Register.");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            String choiceString = scanner.nextLine();
            if (isNumeric(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                if (choice == 1 || choice == 3 || choice == 2) {

                    return choice;
                } else {
                    System.out.println("Wrong choice, write correct number: ");
                }
            } else {
                System.out.println("These is not a number, enter correct number: ");
            }
        }
    }


    private static User login() {
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        User userToCheck = new User();
        userToCheck.setLogin(login);
        userToCheck.setPassword(password);

        return userToCheck;
    }


    public static void appController() {

        while (true) {
            int choice = helloMenu();
            switch (choice) {

                case 1:
                    User user = UserGUI.register();

                    if (!UserRepository.checkExistUser(user)) {
                        UserRepository.addUserToDB(user);
                        System.out.println("added");
                    }
                    break;
                case 2:
                    User userToCheck = login();
                    String isInDatabaseAndStatus = UserRepository.authenticateUserAndCheckStatus(userToCheck);


                    if (isInDatabaseAndStatus.equals("admin")) {
                        boolean logout = false;
                        while (!logout) {
                            System.out.println("You are Admin, what do you want to do now");
                            int adminChoice = AdminGUI.adminMenu();

                            switch (adminChoice) {

                                case 1:
                                    Car car = AdminGUI.addNewCar();
                                    UserRepository.addCarToDB(car);
                                    System.out.println("added");
                                    break;
                                case 2:
                                    AppEngine.carInStockPrint();
                                    break;
                                case 3:
                                    AppEngine.usersInDBPrint();
                                    break;
                                case 4:
                                    AppEngine.reservationsFromBDPrint();
                                    break;
                                case 5:
                                    logout = true;
                            }
                        }


                    } else if (isInDatabaseAndStatus.equals("user")) {
                        boolean logout = false;
                        while (!logout) {
                            System.out.println("You are User, what do you want do to now: ");
                            int userChoice = UserGUI.userMenu();
                            switch (userChoice) {
                                case 1:
                                    AppEngine.carInStockPrint();

                                    break;

                                case 2:
                                    UserRepository.addReservation(UserGUI.reservation());
                                    break;

                                case 3:
                                    logout = true;

                            }
                        }

                    } else {
                        System.out.println("There is no user with these login");
                    }
                    break;

                case 3:
                    return;

            }

        }

    }
}
