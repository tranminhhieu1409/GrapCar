package com.john.grabcar.car;

import java.util.ArrayList;

import com.john.grabcar.IfindAndMoveListener;
import com.john.grabcar.schedule.Schedule;

public class CarMgr implements IfindAndMoveListener {
	private String name;
	private ArrayList<Car> listCar;
	//Singleton - Design pattern	
	private static CarMgr instance;	
	private CarMgr() {
		listCar = new ArrayList<Car>();
	}
	
	public static CarMgr getInstance() {
		if(instance == null) {
			instance = new CarMgr();
		}
		return instance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addCar(Car car){
		if(listCar.indexOf(car) >= 0){
			System.out.println("This car existed!");
			return;
		}
		listCar.add(car);
	}
	
	public void showAllCarInfo(){
		if(listCar != null){
			for (int i = 0; i < listCar.size(); i++) {
				listCar.get(i).showInfo();
			}
		}
	}
	
	public Car findCar(String carId){
		if(listCar != null){
			for (int i = 0; i < listCar.size(); i++) {
				if(listCar.get(i).getCarId().equals(carId)){
					return listCar.get(i);
				}
			}
		}
		return null;
	}
	
	@Override
	public Car find(char startPos, char destPos, String typePos) {
		Car car = listCar.get(0);
		int carCost = 0;
		int distance = 0;
		int minDistance = Math.abs((int)listCar.get(0).getDestPos() - (int)startPos);
		int minCost = (Math.abs((int)destPos - (int)startPos))*listCar.get(0).getPrice();		
		
	    for (int i = 1; i < listCar.size(); i++) {
			if(listCar.get(i).getTypePos().equals(typePos)){
				distance = Math.abs(((int)listCar.get(i).getDestPos() - (int)startPos));
				if(minDistance >= distance){
					minDistance = distance;						
					carCost = (Math.abs((int)destPos - (int)startPos))*listCar.get(i).getPrice();
					if(minCost > carCost){
						minCost = carCost;						
						car = listCar.get(i);
					}
				}
			}		
		}	    
		return car;
	}
	
	@Override
	public Schedule move(char startPos, char destPos, String carId, String userName, String userId) {
		Car car = findCar(carId);
		Schedule schedule = car.drive(startPos, destPos, userId, userName);
		return schedule;
	}
	
	public void showTotalCost(){
		int totalCost = 0;
		for (int i = 0; i < listCar.size(); i++) {
			totalCost+= listCar.get(i).getCostTotal();
		}
		System.out.println("Total cost of all car is: "+ totalCost);
	}
}