package ie.ul.trafficsim.vehicles;

import ie.ul.trafficsim.drivers.Driver;
import ie.ul.trafficsim.movement.Move;
import ie.ul.trafficsim.road.Place;

public interface Vehicle {

	public void move();
	
	public void setPlace(Place place);
	
	public void setDriver(Driver driver);
	
	public void setMove(Move move);
	
	public void setImage(String image);
	
	public String getImage();
}
