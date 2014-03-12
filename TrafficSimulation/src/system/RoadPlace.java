package system;

import vehicles.Vehicle;

public class RoadPlace implements Place {

	Vehicle vehicle;
	Place nextPlace;

	@Override
	public boolean isFree() {
		return null == vehicle ? true : false;
	}

	@Override
	public Vehicle getVehicle() {
		return vehicle;
	}

	@Override
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public Place getNextPlace() {
		return nextPlace;
	}

	@Override
	public void setNextPlace(Place place) {
		this.nextPlace = place;
	}
}
