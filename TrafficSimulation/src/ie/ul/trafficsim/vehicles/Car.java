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
			move.forward(place, this);

		} else if (!isOvertaking
				&& driver.checkLeftPath(place.getNextPlace().getNextPlace(), 3)
				&& driver.checkRightPath(place.getRightPlace(), 7)
				&& driver.checkLeftPath(place.getRightPlace(), 7)) {

			startOvertaking();

		} else if (isOvertaking) {
			continueOvertaking();
		}

		try {
			Thread.sleep((int) ((driver.getSpeed() * Math.random()) + 250));
		} catch (InterruptedException e) {
		}
	}

	private void startOvertaking() {
		System.out.println("starting overtaking");
		isOvertaking = true;
		move.right(place, this);
		move.backward(place, this);
	}

	private void continueOvertaking() {
		System.out.println("continuing to overtake");
		driver.setSpeed(150);

		if (!driver.checkRightPath(place.getPreviousPlace(), 7)) {
			System.out.println("slowing down");
			driver.setSpeed(666);
		}

		if (driver.lookBackward(place, 1)) {
			move.backward(place, this);
		}

		if (driver.lookRight(place)) {
			move.right(place, this);
			isOvertaking = false;
			System.out.println("normal speed");
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
