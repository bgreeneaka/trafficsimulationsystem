package vehicles;

import drivers.Driver;
import road.Place;

public interface Vehicle {

	public void move();
	
	public void setPlace(Place place);
	
	public void setDriver(Driver driver);
	
	public void setImage(String image);
	
	public String getImage();
}
