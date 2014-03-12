package system;

import vehicles.Vehicle;

public interface Place {

	public boolean isFree();
	
	public Vehicle getVehicle();
	
	public void setVehicle(Vehicle vehicle);
	
	public Place getNextPlace();

	public void setNextPlace(Place place);
}
