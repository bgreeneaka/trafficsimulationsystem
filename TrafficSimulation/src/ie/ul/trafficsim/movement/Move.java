package ie.ul.trafficsim.movement;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vehicles.Vehicle;

public interface Move {

	public void forward(Place place, Vehicle vehicle);
	
	public void backward(Place place, Vehicle vehicle);
	
	public void switchLane(Place place, Vehicle vehicle);
	
	public void turnLeft(Place place, Vehicle vehicle);

	public void startOvertaking(Place place, Vehicle vehicle);

	public void continueOvertaking(Place place, Vehicle vehicle, Driver driver);
}
