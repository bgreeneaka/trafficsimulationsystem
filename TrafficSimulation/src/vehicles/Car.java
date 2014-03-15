package vehicles;

import drivers.Driver;
import road.Place;

public class Car implements Vehicle, Runnable {

	Place place;
	Driver driver;
	String image;

	int count;

	@Override
	public void run() {
		while (true) {
			move();
		}
	}

	@Override
	public synchronized void move() {
//		if (count == 5) {
//			place.getRightPlace().setVehicle(this);
//			place.setVehicle(null);
//			place = place.getRightPlace();
//		}
//
//		if (count >= 5) {
//			place.getPreviousPlace().setVehicle(this);
//			place.setVehicle(null);
//			place = place.getPreviousPlace();
//			count++;
//		} 
//		
//		else
			
	//		if (place.getNextPlace().isFree()) {
		
		if (driver.lookForward(place, 1)) {
			place.getNextPlace().setVehicle(this);
			place.setVehicle(null);
			place = place.getNextPlace();
		}

		try {
			Thread.sleep((int) (Math.random() * driver.getSpeed()));
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void setPlace(Place place) {
		this.place = place;
	}

	@Override
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String getImage() {
		return image;
	}
}
