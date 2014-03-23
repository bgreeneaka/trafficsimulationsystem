package ie.ul.trafficsim.movement;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vehicles.Vehicle;

public class MoveImpl implements Move, Runnable {

	@Override
	public void onePlace(Place place, Vehicle vehicle) {
		place.getNextPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getNextPlace());
	}

	@Override
	public void overtake(Place place, Vehicle vehicle) {
		//place.getRightPlace().setVehicle(vehicle);
	}

	@Override
	public void run() {
		
	}
}
