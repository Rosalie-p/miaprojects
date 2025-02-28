
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String[] args) {
        Hotel myhotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d"); // allows single digit months and days
        while (true) {
            System.out.println("\nHotel Booking System");
            System.out.println("1. Add Room");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Book Room");
            System.out.println("4. Display Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Room Type (Single/Double): ");
                    String type = scanner.nextLine();
                    myhotel.addRoom(new Room(roomNumber, type));
                    break;
                case 2:
                    System.out.print("Enter Room Number: ");
                    int checkRoom = scanner.nextInt();
                    System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.next());
                    System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.next());
                    boolean available = myhotel.checkAvailability(checkRoom, checkIn, checkOut);
                    System.out.println(available ? "Available" : "Not Available");
                    break;
                case 3:
                    System.out.print("Enter Visitor Name: ");
                    scanner.nextLine();
                    String visitorName = scanner.nextLine();
                    System.out.print("Enter Room Number: ");
                    int bookRoom = scanner.nextInt();
                    System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
                    LocalDate bookIn = LocalDate.parse(scanner.next());
                    System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
                    LocalDate bookOut = LocalDate.parse(scanner.next());
                    myhotel.bookRoom(visitorName, bookRoom, bookIn, bookOut);
                    break;
                case 4:
                    myhotel.displayBookings();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static LocalDate readDate(Scanner scanner , DateTimeFormatter formatter , String prompt){
        while (true) {
            try {
                System.out.print(prompt);
                String dateInput = scanner.next();
                return LocalDate.parse(dateInput , formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format.Please enter the date as YYYY-MM-DD.");
            }
            
        }
    }
}
