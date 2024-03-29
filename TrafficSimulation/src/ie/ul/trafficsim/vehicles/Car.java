package ie.ul.trafficsim.vehicles;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.movement.Move;
import ie.ul.trafficsim.road.Place;

public class Car implements Vehicle, Runnable {

	private Place place;
	private Driver driver;
	private String image;
	private Move move;
	private boolean isOvertaking;

	@Override
	public void run() {
		while (true) {
			move();
		}
	}

	@Override
	public synchronized void move() {
		int rand = (int) (Math.random() * 100);
		int randMod = (int) (Math.random() * 5) + 1;

		if (rand % randMod == 0) {
			if (place.hasLeftPlace() && driver.lookLeft(place)) {
				move.turnLeft(place, this);
			}
		}

		if (!isOvertaking && driver.lookForward(place, 1)) {
			move.forward(place, this);
		}

		else if (!isOvertaking
				&& driver.checkLeftPath(place.getNextPlace().getNextPlace(), 3)
				&& driver.checkRightPath(place.getRightPlace(), 7)
				&& driver.checkLeftPath(place.getRightPlace(), 7)) {

			move.startOvertaking(place, this);

		} else if (isOvertaking) {
			move.continueOvertaking(place, this, driver);
		}

		try {
			Thread.sleep((int) ((driver.getSpeed() * Math.random()) + 250));
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

	@Override
	public void setOvertaking(boolean b) {
		this.isOvertaking = b;
	}

	@Override
	public Place getPlace() {
		return place;
	}
}
