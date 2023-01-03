package com.john.grabcar.schedule;

public class Schedule {
	private String carId, number, userId, userName;
	private char startPos, destPos;
	private int kmTotal, cost;

	public Schedule(String carId, String number, String userId, String userName, char startPos, char destPos,
			int kmTotal, int cost) {
		this.carId = carId;
		this.number = number;
		this.userId = userId;
		this.userName = userName;
		this.startPos = startPos;
		this.destPos = destPos;
		this.kmTotal = kmTotal;
		this.cost = cost;
	}

	public String getCarId() {
		return carId;
	}

	public String getNumber() {
		return number;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public char getStartPos() {
		return startPos;
	}

	public char getDestPos() {
		return destPos;
	}

	public int getKmTotal() {
		return kmTotal;
	}

	public int getCost() {
		return cost;
	}

	public void showInfo() {
		System.out.println("[Schedule: " + carId + "]");
		System.out.println("Number: " + number);
		System.out.println("User id: " + userId);
		System.out.println("User name: " + userName);
		System.out.println("From: " + startPos);
		System.out.println("To: " + destPos);
		System.out.println("Total km:" + kmTotal);
	}
}
