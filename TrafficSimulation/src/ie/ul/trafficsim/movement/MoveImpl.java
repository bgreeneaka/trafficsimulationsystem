package ie.ul.trafficsim.movement;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vehicles.Vehicle;

public class MoveImpl implements Move {

	@Override
	public void forward(Place place, Vehicle vehicle) {
		place.getNextPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getNextPlace());
	}

	@Override
	public void backward(Place place, Vehicle vehicle) {
		place.getPreviousPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getPreviousPlace());
	}

	@Override
	public void switchLane(Place place, Vehicle vehicle) {
		place.getRightPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getRightPlace());
	}

	@Override
	public void turnLeft(Place place, Vehicle vehicle) {
		place.getLeftPlace().setVehicle(vehicle);
		place.setVehicle(null);
		vehicle.setPlace(place.getLeftPlace());
	}
	
	@Override
	public void startOvertaking(Place place, Vehicle vehicle) {
		System.out.println("starting overtaking");
		vehicle.setOvertaking(true);
		switchLane(place, vehicle);
		backward(vehicle.getPlace(), vehicle);
	}
	
	@Override
	public void continueOvertaking(Place place, Vehicle vehicle, Driver driver) {
		System.out.println("continuing to overtake");
		driver.setSpeed(150);

		if (!driver.checkRightPath(vehicle.getPlace().getPreviousPlace(), 7)) {
			System.out.println("slowing down");
			driver.setSpeed(666);
		}

		if (driver.lookBackward(place, 1)) {
			backward(vehicle.getPlace(), vehicle);
		}

		if (driver.lookRight(vehicle.getPlace())) {
			switchLane(vehicle.getPlace(), vehicle);
			vehicle.setOvertaking(false);
			System.out.println("normal speed");
			driver.setSpeed(333);
		}
	}
}
