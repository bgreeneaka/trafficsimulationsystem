package ie.ul.trafficsim.movement;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vehicles.Vehicle;

public interface Move {

	public void onePlace(Place place, Vehicle vehicle);
	
	public void overtake(Place place, Vehicle vehicle);
}
