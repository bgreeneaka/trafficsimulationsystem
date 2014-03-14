package vehicles;

import planning.Route;
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
		this.vehicle.setDriver(driver);
		return this;
	}

	@Override
	public VehicleBuilder withRoute(Route route) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Vehicle build() {
		// TODO Auto-generated method stub
		return vehicle;
	}
}
