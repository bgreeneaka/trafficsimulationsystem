package ie.ul.trafficsim.vehicles;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.route.Route;

public interface VehicleBuilder {

	public VehicleBuilder withVehicle(Vehicle vehicle);
	
	public VehicleBuilder withDriver(Driver driver);
	
	public VehicleBuilder withRoute(Route route);
	
	public VehicleBuilder withColour(String image);
	
	public Vehicle build();
}
