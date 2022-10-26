package BusRes_Mini;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of Passenger:");
		passengerName = sc.next();
		System.out.println("Enter bus no:");
		busNo = sc.nextInt();
		System.out.println("Enter Date dd-mm-yyyy:");
		String dateinput = sc.next();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	try {
		date = dateFormat.parse(dateinput);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> buses) {
		int capacity = 0;
		for(Bus bus:buses) {
			if(bus.getBusNo() == busNo)
				capacity = bus.getCapacity();
		}
		int booked = 0;
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		return booked<capacity?true:false;
	}
}
