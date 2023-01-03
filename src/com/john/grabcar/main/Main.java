package com.john.grabcar.main;

import com.john.grabcar.car.Car;
import com.john.grabcar.car.CarMgr;
import com.john.grabcar.user.User;

public class Main {

	public static void main(String[] args) {
		/*
		 * Viết Main sau để test:
			o Tạo danh sách ô tô trên
			o Hiển thị toàn bộ thông tin trong ds xe vừa tạo 
			o Tạo 1 người dùng:
			- Đăng ký lắng nghe và nhận phản hổi từ CarMgr:
				+ Tìm kiếm xe
				+ Hiển thị toàn bộ danh sách lộ trình đã đi của người dùng 
			o Hiển thị tổng tiền thu được của người quản lý
		 * */
		Car car1 = new Car("Oto1", "Hoang Van Nam", "29B-1145", "Huyndai", "4 cho", 10000);
		Car car2 = new Car("Oto2", "Tran Tinh", "29B-1234", "Toyota", "4 cho", 12000);
		Car car3 = new Car("Oto3", "Dang Nam Anh", "29B-1115", "Audi", "7 cho", 13000);
		Car car4 = new Car("Oto4", "Nguyen Tuan Vu", "29B-3452", "Mercedes", "7 cho", 13000);
		Car car5 = new Car("Oto5", "Tran Duc Duc", "29B-9821", "Huyndai", "4 cho", 8000);
		Car car6 = new Car("Oto6", "Trinh Thi Thuy", "29B-2241", "Huyndai", "7 cho", 14000);	
		
		CarMgr.getInstance().setName("Nguyen Van Thanh");
		CarMgr.getInstance().addCar(car1);
		CarMgr.getInstance().addCar(car2);
		CarMgr.getInstance().addCar(car3);
		CarMgr.getInstance().addCar(car4);
		CarMgr.getInstance().addCar(car5);
		CarMgr.getInstance().addCar(car6);
		
		System.out.println("-------------Show all car information--------------");
		CarMgr.getInstance().showAllCarInfo();
		
		User user1 = new User("id1","1234","Thanh");
		//Đăng ký lắng nghe
		user1.addFindAndMoveListener(CarMgr.getInstance());
		user1.findCar('A','E', "4 cho");		
		user1.findCar('A','F', "7 cho");
		user1.findCar('A','D', "4 cho");
		user1.findCar('A','G', "7 cho");
		System.out.println("-------------Show all user's schedules--------------");
		user1.showAllSchedule();
		System.out.println("-------------Show all car manager's total cost--------------");
		CarMgr.getInstance().showTotalCost();
	}
}
