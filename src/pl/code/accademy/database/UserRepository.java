package pl.code.accademy.database;

import pl.code.accademy.model.car.Car;
import pl.code.accademy.model.reservation.Reservation;
import pl.code.accademy.model.users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static Connection connection = null;

    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            UserRepository.connection = DriverManager.getConnection("jdbc:mysql://localhost/car_rent?user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Wrong connection! shut down");
            System.exit(0);
        }
    }

    public static List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String sql = "SELECT * FROM tuser";

        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setStatus(resultSet.getString("status"));
                user.setPESEL(resultSet.getString("pesel"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));

                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public static void addUserToDB(User user) {
        String sql = "INSERT INTO tuser(name, surname, pass, pesel,  login) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPESEL());
            ps.setString(5, user.getLogin());
            System.out.println("added");

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addReservation(Reservation reservation) {

        String sql = "INSERT INTO treservations (date, car_id, user_id, login) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);

            ps.setString(1, reservation.getDate());
            ps.setInt(2, reservation.getCarId());
            ps.setInt(3, reservation.getUserId());
            ps.setString(4, reservation.getLogin());

            System.out.println("added reservation");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addCarToDB(Car car) {
        String sql = "INSERT INTO tcar(brand, model, production_date, colour, engine_power, fuel_type, mileage, engine_capacity, type) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);
            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getProductionDate());
            ps.setString(4, car.getColour());
            ps.setInt(5, car.getEnginePower());
            ps.setString(6, car.getFuelType());
            ps.setInt(7, car.getMileage());
            ps.setInt(8, car.getEngineCapacity());
            ps.setString(9, car.getCarType());
            System.out.println("added");

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkExistUser(User user) {
        String sql = "SELECT * FROM tuser WHERE login =?";

        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                System.out.println("There is the same login");
                return true;
            } else {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }

    }

    public static List<Reservation> getAllReservations() {
        List<Reservation> reservationsList = new ArrayList<>();
        String sql = "SELECT * FROM treservations";

        try {


            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setUserId(resultSet.getInt("user_id"));
                reservation.setDate(resultSet.getString("date"));
                reservation.setLogin(resultSet.getString("login"));
                reservation.setCarId(resultSet.getInt("car_id"));
                reservation.setBookId(resultSet.getInt("book_id"));

                reservationsList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservationsList;
    }

    public static List<Car> getAllCars() {
        List<Car> carsList = new ArrayList<>();
        String sql = "SELECT * FROM tcar";

        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();

                car.setCarId(resultSet.getInt("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setProductionDate(resultSet.getInt("production_date"));
                car.setColour(resultSet.getString("colour"));
                car.setEnginePower(resultSet.getInt("engine_power"));
                car.setEngineCapacity(resultSet.getInt("engine_capacity"));
                car.setFuelType(resultSet.getString("fuel_type"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setCarType(resultSet.getString("type"));

                carsList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carsList;
    }

    public static int getUserId(String login) {
        String sql = "SELECT * FROM tuser WHERE login = ?";
        try {

            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                return user_id;
            }
            return 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean isCarNotAvailable(int carId, String dateToCheck) {
        String sql = "SELECT * FROM treservations WHERE car_id = ?";
        try {
            PreparedStatement ps = UserRepository.connection.prepareStatement(sql);
            ps.setInt(1, carId);

            ResultSet resultSet = ps.executeQuery();
            System.out.println(dateToCheck);

            if (resultSet.next()) {
                String dateFromDB = resultSet.getString("date");
                System.out.println(dateFromDB);
                if (dateToCheck.equals(dateFromDB)) {
                    System.out.println("car is booked");
                    return false;
                }
            }
            System.out.println("car is not booked");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("car");
        return false;
    }


    public static String authenticateUserAndCheckStatus(User user) {

        String sql = "SELECT * FROM tuser WHERE login = ?";
        try {
            PreparedStatement preparedStatement = UserRepository.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String userPasswordFromDB = resultSet.getString("pass");
                String userStatusFromDB = resultSet.getString("status");

                if (user.getPassword().equals(userPasswordFromDB)) {
                    if (userStatusFromDB.equals("a")) {
                        return "admin";

                    }
                    if (userStatusFromDB.equals("u")) {
                        return "user";
                    }
                } else {
                    return "fail";
                }
            } else {
                return "fail";
            }

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            return "fail";
        }
        return "fail";
    }


}