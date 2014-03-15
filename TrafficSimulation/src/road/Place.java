package road;

import vehicles.Vehicle;

public interface Place {

	public boolean isFree();
	
	public Vehicle getVehicle();
	
	public void setVehicle(Vehicle vehicle);
	
	public Place getNextPlace();
	
	public Place getPreviousPlace();
	
	public Place getLeftPlace();
	
	public Place getRightPlace();

	public void setNextPlace(Place place);
	
	public void setPreviousPlace(Place place);
	
	public void setLeftPlace(Place place);
	
	public void setRightPlace(Place place);
}
