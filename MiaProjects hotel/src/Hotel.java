

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.locks.*;

public class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings;
    private final ReentrantLock lock = new ReentrantLock();

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // Add a new room to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room " + room.getRoomNumber() + " added successfully.");
    }

    // Check room availability for a given date range
    public boolean checkAvailability(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        for (Booking booking : bookings) {
            if (booking.getRoomNumber() == roomNumber &&
                (checkIn.isBefore(booking.getCheckOutDate()) && checkOut.isAfter(booking.getCheckInDate()))) {
                return false; // Room is already booked for the given dates
            }
        }
        return true;
    }

    // Book a room if it's available
    public void bookRoom(String visitorName, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        lock.lock(); // Ensure thread safety
        try {
            if (checkAvailability(roomNumber, checkIn, checkOut)) {
                bookings.add(new Booking(visitorName, roomNumber, checkIn, checkOut));
                for (Room room : rooms) {
                    if (room.getRoomNumber() == roomNumber) {
                        room.setBooked(true);
                        break;
                    }
                }
                System.out.println("Room " + roomNumber + " successfully booked for " + visitorName);
            } else {
                System.out.println("Room " + roomNumber + " is not available for the selected dates.");
            }
        } finally {
            lock.unlock();
        }
    }

    // Display all bookings
    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("\nCurrent Bookings:");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}



