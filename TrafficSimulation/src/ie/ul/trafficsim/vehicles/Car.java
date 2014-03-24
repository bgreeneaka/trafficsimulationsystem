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
		if (!isOvertaking && driver.lookForward(place, 1)) {
			move.moveForward(place, this);

		} else if (!isOvertaking
				&& driver.checkLeftPath(place.getNextPlace().getNextPlace(), 5)
				&& driver.checkRightPath(place.getRightPlace(), 6)) {

			startOvertaking();

		} else if (isOvertaking) {
			continueOvertaking();
		}

		try {
			Thread.sleep((int) (driver.getSpeed() * Math.random() + 250));
		} catch (InterruptedException e) {
		}
	}

	private void startOvertaking() {
		isOvertaking = true;
		move.moveRight(place, this);
		move.moveBackward(place, this);
	}

	private void continueOvertaking() {
		driver.setSpeed(200);
		if (driver.lookBackward(place, 1)) {
			move.moveBackward(place, this);
		}

		if (driver.lookRight(place)) {
			move.moveRight(place, this);
			isOvertaking = false;
			driver.setSpeed(333);
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
