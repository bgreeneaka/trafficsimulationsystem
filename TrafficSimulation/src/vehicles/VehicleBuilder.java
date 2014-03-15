package vehicles;

import route.Route;
import drivers.Driver;

public interface VehicleBuilder {

	public VehicleBuilder withVehicle(Vehicle vehicle);
	
	public VehicleBuilder withDriver(Driver driver);
	
	public VehicleBuilder withRoute(Route route);
	
	public VehicleBuilder withColour(String image);
	
	public Vehicle build();
}
