package ie.ul.trafficsim.movement;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vehicles.Vehicle;

public interface Move {

	public void moveForward(Place place, Vehicle vehicle);
	
	public void moveBackward(Place place, Vehicle vehicle);
	
	public void moveRight(Place place, Vehicle vehicle);
	
	public void moveLeft(Place place, Vehicle vehicle);
}
