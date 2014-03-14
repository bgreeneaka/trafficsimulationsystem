package vehicles;

import drivers.Driver;
import system.Place;

public interface Vehicle {

	public void move();
	
	public void setPlace(Place place);
	
	public void setDriver(Driver driver);
}
