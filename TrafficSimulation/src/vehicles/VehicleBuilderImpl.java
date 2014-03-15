package vehicles;

import planning.LookBackward;
import planning.LookForward;
import route.Route;
import drivers.Driver;

public class VehicleBuilderImpl implements VehicleBuilder {

	private Vehicle vehicle;
	
	@Override
	public VehicleBuilder withVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}

	@Override
	public VehicleBuilder withDriver(Driver driver) {
		driver.setLookForward(new LookForward());
		driver.setLookBackward(new LookBackward());
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
