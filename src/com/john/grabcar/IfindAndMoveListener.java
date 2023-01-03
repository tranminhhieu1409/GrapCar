package com.john.grabcar;

import com.john.grabcar.car.Car;
import com.john.grabcar.schedule.Schedule;

public interface IfindAndMoveListener {	
	Car find(char startPos, char destPos, String typePos);

	Schedule move(char startPos, char destPos, String carId, String userName, String userId);
}
