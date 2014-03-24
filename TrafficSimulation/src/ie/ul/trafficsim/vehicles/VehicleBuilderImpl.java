package ie.ul.trafficsim.vehicles;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.movement.MoveImpl;
import ie.ul.trafficsim.planning.CheckPathImpl;
import ie.ul.trafficsim.planning.LookImpl;
import ie.ul.trafficsim.route.Route;

public class VehicleBuilderImpl implements VehicleBuilder {

	private Vehicle vehicle;

	@Override
	public VehicleBuilder withVehicle(Vehicle vehicle) {
		vehicle.setMove(new MoveImpl());
		this.vehicle = vehicle;
		return this;
	}

	@Override
	public VehicleBuilder withDriver(Driver driver) {
		driver.setLook(new LookImpl());
		driver.setCheckPath(new CheckPathImpl(new LookImpl()));
		this.vehicle.setDriver(driver);
		return this;
	}

	@Override
	public VehicleBuilder withColour(String image) {
		this.vehicle.setImage(image);
		return this;
	}

	@Override
	public VehicleBuilder withRoute(Route route) {
		return this;
	}

	@Override
	public Vehicle build() {
		return vehicle;
	}
}
