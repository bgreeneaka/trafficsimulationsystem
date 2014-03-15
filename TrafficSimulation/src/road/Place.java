package road;

import vehicles.Vehicle;

public interface Place {

	public boolean isFree();
	
	public Vehicle getVehicle();
	
	public void setVehicle(Vehicle vehicle);
	
	public Place getNextPlace();
	
	public Place getPreviousPlace();

	public void setNextPlace(Place place);
	
	public void setPreviousPlace(Place place);
}
