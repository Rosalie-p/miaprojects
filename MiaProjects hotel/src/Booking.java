import java.time.LocalDate;

public class Booking {
    private String visitorName;
    private int roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(String visitorName, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.visitorName = visitorName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
    }

    public String getVisitorName() { return visitorName; }
    public int getRoomNumber() { return roomNumber; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }

    @Override
    public String toString() {
        return "Booking: " + visitorName + " | Room: " + roomNumber + " | From: " + checkInDate + " To: " + checkOutDate;
    }
}



