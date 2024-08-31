import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Reservation {
    String trainNumber;
    String trainName;
    String classType;
    String dateOfJourney;
    String from;
    String to;

    Reservation(String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Train Number: " + trainNumber + ", Train Name: " + trainName + ", Class: " + classType +
               ", Date of Journey: " + dateOfJourney + ", From: " + from + ", To: " + to;
    }
}

public class OnlineReservationSystem{
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        users.add(new User("admin", "admin123")); // Adding a default user

        System.out.println("Welcome to the Online Reservation System");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login Successful!");
            while (true) {
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        makeReservation(scanner);
                        break;
                    case 2:
                        cancelReservation(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private static boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter Train Number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter Class Type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter Date of Journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter From: ");
        String from = scanner.nextLine();
        System.out.print("Enter To: ");
        String to = scanner.nextLine();

        Reservation reservation = new Reservation(trainNumber, trainName, classType, dateOfJourney, from, to);
        reservations.add(reservation);
        System.out.println("Reservation Successful: " + reservation);
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter Train Number to Cancel: ");
        String trainNumber = scanner.nextLine();

        for (Reservation reservation : reservations) {
            if (reservation.trainNumber.equals(trainNumber)) {
                reservations.remove(reservation);
                System.out.println("Reservation Cancelled: " + reservation);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
}

