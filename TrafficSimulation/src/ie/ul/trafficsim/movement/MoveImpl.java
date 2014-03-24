package ie.ul.trafficsim.movement;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vehicles.Vehicle;

public class MoveImpl implements Move {

	@Override
	public void moveForward(Place place, Vehicle vehicle) {
		place.getNextPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getNextPlace());
	}

	@Override
	public void moveBackward(Place place, Vehicle vehicle) {
		place.getPreviousPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getPreviousPlace());
	}

	@Override
	public void moveRight(Place place, Vehicle vehicle) {
		place.getRightPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getRightPlace());
	}

	@Override
	public void moveLeft(Place place, Vehicle vehicle) {
		place.getLeftPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getLeftPlace());
	}
}
