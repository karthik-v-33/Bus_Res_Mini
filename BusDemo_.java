package BusRes_Mini;
import java.util.Scanner;
import java.util.ArrayList;
public class BusDemo_ {

	public static void main(String[] args) {
		
		ArrayList<Bus> buses = new ArrayList<Bus>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		buses.add(new Bus(1,true,52));
		buses.add(new Bus(2,true,44));
		buses.add(new Bus(3,true,48));
		buses.add(new Bus(4,false,2));
		
		int userOpt =1;
		Scanner sc = new Scanner(System.in);
		
		for(Bus b:buses) {
			b.displayBusInfo();
		}
		
		while(userOpt==1) {
			System.out.println("Enter 1 to Book & 2 to Exit");
			userOpt = sc.nextInt();
			if(userOpt==1) {
				Booking booking = new Booking();
				if(booking.isAvailable(bookings,buses)) {
					bookings.add(booking);
					System.out.println("Your booking is Confirmed");
				}
				else
					System.out.println("Sorry its Full. Try another bus or date");
			}
		}
	}

}
