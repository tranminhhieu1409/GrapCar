package com.john.grabcar.user;

import java.util.ArrayList;
import com.john.grabcar.IfindAndMoveListener;
import com.john.grabcar.car.Car;
import com.john.grabcar.schedule.Schedule;

public class User {
	private String userId, pass, userName;
	private ArrayList<Schedule> listSchedule;
	private IfindAndMoveListener findAndMoveListener;
		
	public User(String userId, String pass, String userName) {
		this.userId = userId;
		this.pass = pass;
		this.userName = userName;
		listSchedule = new ArrayList<Schedule>();
	}

	public String getUserId() {
		return userId;
	}
	
	public String getPass() {
		return pass;
	}

	public String getUserName() {
		return userName;
	}
	
	public void showInfo(){
		System.out.println("User: " + userId);
		System.out.println("User name:" + userName);		
	}
	//call back
	public void addFindAndMoveListener(IfindAndMoveListener event){		
		findAndMoveListener = event;
	}
	
	public void findCar(char startPos, char destPos, String typePos){	
		if (findAndMoveListener != null) {
			Car car = findAndMoveListener.find(startPos, destPos, typePos);
			if(car!= null){
				car.showInfo();			
				car.drive(startPos, destPos, userId, userName);	
				Schedule schedule = findAndMoveListener.move(startPos, destPos, car.getCarId(), userName, userId);
				schedule.showInfo();
				if(schedule != null){
					listSchedule.add(schedule);
				}
			}
		}else {
			System.out.println("Car manager ");
		}		
	}	
	
	public void showAllSchedule(){
		int totalCost = 0;
		for (int i = 0; i < listSchedule.size(); i++) {
			listSchedule.get(i).showInfo();
			totalCost+= listSchedule.get(i).getCost();
		}
		System.out.println("Total amount paid: "+ totalCost);
	}
}
