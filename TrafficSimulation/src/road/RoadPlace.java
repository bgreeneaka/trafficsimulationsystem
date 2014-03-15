package road;

import vehicles.Vehicle;

public class RoadPlace implements Place {

	Vehicle vehicle;
	Place nextPlace;
	Place previousPlace;

	@Override
	public boolean isFree() {
		return null == vehicle ? true : false; 	// ternary operator
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

	@Override
	public Place getPreviousPlace() {
		return previousPlace;
	}

	@Override
	public void setPreviousPlace(Place place) {
		this.previousPlace = place;
	}
}
