package vehicles;

import drivers.Driver;
import road.Place;

public class Car implements Vehicle, Runnable {

	Place place;
	Driver driver;

	@Override
	public void run() {
		while (true) {
			move();
		}
	}

	@Override
	public synchronized void move() {
		if (place.getNextPlace().isFree()) {
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
}
