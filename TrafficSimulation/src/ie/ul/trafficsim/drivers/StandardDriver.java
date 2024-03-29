package ie.ul.trafficsim.drivers;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vision.CheckPath;
import ie.ul.trafficsim.vision.Look;

public class StandardDriver implements Driver {

	private int speed = 333;
	private Look look;
	private CheckPath checkPath;

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public boolean lookForward(Place place, int numberOfPlaces) {
		return look.forward(place, numberOfPlaces);
	}

	@Override
	public boolean lookBackward(Place place, int numberOfPlaces) {
		return look.backward(place, numberOfPlaces);
	}
	
	@Override
	public boolean lookRight(Place place) {
		return look.right(place);
	}
	
	@Override
	public boolean lookLeft(Place place) {
		return look.left(place);
	}
	
	@Override
	public boolean checkLeftPath(Place place, int numberOfPlaces) {
		return checkPath.checkLeftPath(place, numberOfPlaces);
	}

	@Override
	public boolean checkRightPath(Place place, int numberOfPlaces) {
		return checkPath.checkRightPath(place, numberOfPlaces);
	}

	@Override
	public void setLook(Look look) {
		this.look = look;
	}

	@Override
	public void setCheckPath(CheckPath checkPath) {
		this.checkPath = checkPath;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
