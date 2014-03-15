package ie.ul.trafficsim.road;

import ie.ul.trafficsim.vehicles.Vehicle;

public class RoadPlace implements Place {

	Vehicle vehicle;
	Place nextPlace;
	Place previousPlace;
	Place leftPlace;
	Place rightPlace;

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

	@Override
	public Place getLeftPlace() {
		return leftPlace;
	}

	@Override
	public Place getRightPlace() {
		return rightPlace;
	}

	@Override
	public void setLeftPlace(Place place) {
		this.leftPlace = place;
	}

	@Override
	public void setRightPlace(Place place) {
		this.rightPlace = place;
	}
}
