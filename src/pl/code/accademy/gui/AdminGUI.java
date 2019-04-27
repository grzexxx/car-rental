package pl.code.accademy.gui;

import pl.code.accademy.model.car.Car;
import pl.code.accademy.model.car.Civil;
import pl.code.accademy.model.car.Delivery;
import pl.code.accademy.model.car.OffRoad;

import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class AdminGUI {

    private static Scanner scanner = new Scanner(System.in);

    public static int adminMenu() {
        while (true) {

            System.out.println("1. Add new car.");
            System.out.println("2. Show cars.");
            System.out.println("3. Show users.");
            System.out.println("4. Show bookings");
            System.out.println("5. Log out");

            String choiceString = scanner.nextLine();

            if (isNumeric(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                if (choice > 0 && choice <= 5) {
                    return choice;
                }
            } else {
                System.out.println("Enter appropriate number: ");
            }
        }
    }

    public static Car addNewCar() {

        while (true) {
            System.out.println("Type number (allowed type 1: CIVIL, 2: OFF-ROAD, 3: DELIVERY): ");
            String typeS = scanner.nextLine();

            System.out.println("Brand: ");
            String brand = scanner.nextLine();

            System.out.println("Model: ");
            String model = scanner.nextLine();

            System.out.println("Production date: ");
            String productionDateS = scanner.nextLine();

            System.out.println("Colour: ");
            String colour = scanner.nextLine();

            System.out.println("Engine power: ");
            String enginePowerS = scanner.nextLine();

            System.out.println("Engine capacity (if electric enter 1: ");
            String engineCapacityS = scanner.nextLine();

            System.out.println("Fuel type: ");
            String fuelType = scanner.nextLine();

            System.out.println("Mileage: ");
            String mileageS = scanner.nextLine();

            if (isNumeric(productionDateS) && isNumeric(enginePowerS) && isNumeric(engineCapacityS) && isNumeric(mileageS) && isNumeric(typeS)) {
                int type = Integer.parseInt(typeS);
                int productionDate = Integer.parseInt(productionDateS);
                int enginePower = Integer.parseInt(enginePowerS);
                int engineCapacity = Integer.parseInt(engineCapacityS);
                int mileage = Integer.parseInt(mileageS);

                if (type == 1) {
                    Car civilCar = new Civil(brand, model, productionDate, colour, enginePower, fuelType, mileage, engineCapacity, "CIVIL");
                    return civilCar;
                } else if (type == 2) {
                    Car offRoadCar = new OffRoad(brand, model, productionDate, colour, enginePower, fuelType, mileage, engineCapacity);
                    return offRoadCar;
                } else if (type == 3) {
                    Car deliveryCar = new Delivery(brand, model, productionDate, colour, enginePower, fuelType, mileage, engineCapacity);
                    return deliveryCar;
                } else {
                    System.out.println("Wrong car type");
                }

            } else {
                System.out.println("Wrong car date, correct it");
            }
        }
    }

    public static void userList() {
        //List<User> userFromDB = UserRepository.gerAllUser();
    }

    public static void carList() {
        //todo
    }

    public static void getBookings() {
        //todo
    }
}