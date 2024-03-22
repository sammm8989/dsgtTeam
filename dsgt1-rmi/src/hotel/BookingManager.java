package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class BookingManager implements Manager {

	private Room[] rooms;

	public BookingManager() {
		this.rooms = initializeRooms();
	}

	public Set<Integer> getAllRooms() {
		Set<Integer> allRooms = new HashSet<Integer>();
		Room[] roomIterator = rooms;
		for (Room room : roomIterator) {
			allRooms.add(room.getRoomNumber());
		}
		return allRooms;
	}

	public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
		//implement this method
		for (Room room : rooms) {
			if (roomNumber.equals(room.getRoomNumber())) {
				List<BookingDetail> bookings = room.getBookings();
				for (BookingDetail booking : bookings) {
					if (date.equals(booking.getDate())) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public void addBooking(BookingDetail bookingDetail) {
		//implement this method
		LocalDate date = bookingDetail.getDate();
		int number = bookingDetail.getRoomNumber();
		if(isRoomAvailable(number,date)){
			for (Room room: rooms){
				if (room.getRoomNumber().equals(number)){
					List<BookingDetail> bookings = room.getBookings();
					bookings.add(bookingDetail);
					room.setBookings(bookings);
				}

			}
		}
	}


	public Set<Integer> getAvailableRooms(LocalDate date) {
		//implement this method
		Set<Integer> available = new HashSet<>();
		for(Room room: rooms){
			if (isRoomAvailable(room.getRoomNumber(), date)){
				available.add(room.getRoomNumber());
			}
		}
		return available;
	}

	private static Room[] initializeRooms() {
		Room[] rooms = new Room[4];
		rooms[0] = new Room(101);
		rooms[1] = new Room(102);
		rooms[2] = new Room(201);
		rooms[3] = new Room(203);
		return rooms;
	}
}
