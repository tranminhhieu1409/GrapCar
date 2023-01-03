package com.john.grabcar.car;
import com.john.grabcar.schedule.Schedule;

public class Car {
	private String carId, name, number, term, typePos;
	private int price, kmTotal, costTotal;
	private char startPos, destPos;
	//int km = Math.abs((int)destPos - (int)startPos)
	
	public Car(String carId, String name, String number, String term, String typePos, int price) {
		this.carId = carId;
		this.name = name;
		this.number = number;
		this.term = term;
		this.typePos = typePos;
		this.price = price;
	}

	public String getCarId() {
		return carId;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getTerm() {
		return term;
	}

	public String getTypePos() {
		return typePos;
	}

	public int getPrice() {
		return price;
	}

	public int getKmTotal() {
		return kmTotal;
	}

	public int getCostTotal() {
		return costTotal;
	}

	public char getStartPos() {
		return startPos;
	}

	public char getDestPos() {
		return destPos;
	}

	public void showInfo() {
		System.out.println("[Car-" + carId + "]");		
		System.out.println("Driver name: " + name);
		System.out.println("Truck number: " + number);
		System.out.println("Car term: " + term);
		System.out.println("Type position: " + typePos);
		System.out.println("Price: " + price);
		System.out.println("Total km: " + kmTotal);
	}

	public int showCost() {
		System.out.println("Price/1km: " + price);
		System.out.println("Total km: " + kmTotal);
		System.out.println("Current total cost: " + costTotal);
		return costTotal;
	}

	public Schedule drive(char startPos1, char destPos1, String userId, String userName) {
		startPos = startPos1;
		destPos = destPos1;
		int kmNumber = (int)destPos - (int)startPos;
		kmTotal += kmNumber;
		costTotal += kmNumber * price;
		System.out.println("Amount paid by the customer from " + startPos + " to " + destPos + " is: " + kmNumber * price);
		System.out.println("From " + startPos + " to " + destPos + ": " + kmTotal + " km");

		Schedule schedule = new Schedule(carId, number, userId, userName, startPos1, destPos1, kmNumber, kmNumber * price);
		return schedule;
	}
	
	@Override
	public boolean equals(Object obj) {
		Car car2 = (Car)obj;		
		return carId == car2.getCarId();
	}
}
