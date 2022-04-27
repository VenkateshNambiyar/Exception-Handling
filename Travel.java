package com.bus;

import java.util.*;

public class Travel {
	private Scanner destination = new Scanner(System.in);
	
	private int passengers;
	private double amountPaid;
	private double balance;
	private final double minimumDestinationLimit = 1.0;
	private final double minimumPassengerLimit = 1.0;
	private final double maximumDestinationLimit = 5.0;
	private double baseTicketPrice;
	private int booking;
	private double totalPrice;
	
	private final void passengersOnBoard() {
		while (true) {
			try {
				busticket();
				break;
			} catch (InputMismatchException e) {
				destination.nextLine();
			}
		}
	}
	
	private final void showSelection() {
		System.out.println("\n   DESTINATION    1.)Tuticorin \t 2.)Madurai \t 3.)Nagercoil \t 4.)Tenkasi");
		System.out.print("Select A Destination : \t\t ");
		booking = destination.nextInt();
		
		check();
	}
	
	private final void check() {
		if ((booking >= maximumDestinationLimit ) || (booking < minimumDestinationLimit)) {
			throw new IncorrectDetailsException("Invalid Entry So Kindly Retry..");
		}
	}
	
	private final void passengerDetails() {
		System.out.print( " Enter a passengersDetails :  \t");
		passengers = destination.nextInt();
		
		validatePassenger();
	}
	
	private final void validatePassenger() {
		if (passengers < minimumPassengerLimit) {
			throw new IncorrectDetailsException("Invalid Transacation So Kindly Retry..");
		}
	}
	
	private final void ticketAmount() {
		System.out.print( " Enter a Base TicketPrice : \t " );
		baseTicketPrice = destination.nextDouble();
	}
	
	private final void showPayment() {
		totalPrice = passengers * baseTicketPrice;
		
		System.out.println( " Total Price of the Ticket : \t " + totalPrice );
	}
	
	private final void payment() {
		System.out.print( " Passenger Amount Paid : \t " );
		amountPaid = destination.nextDouble();
	
		validatePayment();
	}
	
	private final void validatePayment() {
		if (amountPaid < totalPrice) {
			throw new IncorrectDetailsException("Invalid Transacation So Kindly Retry..\n");
		}
	}
	
	private final void billing() {
		balance = amountPaid - totalPrice;
		
		System.out.println( " Passenger Balance Amount: \t " + balance );
	}
	
	private final void busticket() throws RuntimeException {
		showSelection();
	
		switch (booking) {
		case 1:
			System.out.println(" Bus No : 1212 Departs at 00.10 From Tirunelveli To Tuticorin ");
			break;
		case 2:
			System.out.println(" Bus No : 2602 Departs at 00.20 From Tirunelveli To Madurai ");
			break;
		case 3:
			System.out.println(" Bus No : 2207 Departs at 00.30 From Tirunelveli To Nagercoil ");
			break;
		case 4:
			System.out.println(" Bus No : 2907 Departs at 00.40 From Tirunelveli To Tenkasi ");
			break;
		default:
			System.out.println("Thank YOu");
		}
		
		passengerDetails();
		ticketAmount();
		showPayment();
		payment();
		billing();
	}
	
	public static void main(String[] args) {
		Travel bus = new Travel();
		
		bus.passengersOnBoard();
	}
}