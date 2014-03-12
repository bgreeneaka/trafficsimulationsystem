package vehicles;

import system.Place;

public class Car implements Vehicle, Runnable {

	Place place;

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
			Thread.sleep((int) (Math.random()*250));
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void setPlace(Place place) {
		this.place = place;
	}
}
