package ie.ul.trafficsim.vehicles;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.movement.Move;
import ie.ul.trafficsim.road.Place;

public class Car implements Vehicle, Runnable {

	private Place place;
	private Driver driver;
	private String image;
	private Move move;

	int count;

	@Override
	public void run() {
		while (true) {
			move();
		}
	}

	@Override
	public synchronized void move() {
		// if (count == 5) {
		// place.getRightPlace().setVehicle(this);
		// place.setVehicle(null);
		// place = place.getRightPlace();
		// }
		//
		// if (count >= 5) {
		// place.getPreviousPlace().setVehicle(this);
		// place.setVehicle(null);
		// place = place.getPreviousPlace();
		// count++;
		// }
		//
		// else

		// if (place.getNextPlace().isFree()) {

		if (driver.lookForward(place, 1)) {
			move.onePlace(place, this);
		} else if (driver.checkLeftPath(place.getNextPlace(), 6)
				&& driver.checkRightPath(place.getRightPlace(), 6)) {
			System.out.println("Im gonna overtake");
		}

		try {
			Thread.sleep((driver.getSpeed() + (int) (Math.random() * 100)));
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

	@Override
	public void setMove(Move move) {
		this.move = move;
	}
}
