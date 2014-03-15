package drivers;

import planning.Look;
import road.Place;

public interface Driver {

	public int getSpeed();
	
	public boolean lookForward(Place place, int numberOfPlaces);
	
	public boolean lookBackward(Place place, int numberOfPlaces);
	
	public void setLookForward(Look look);
	
	public void setLookBackward(Look look);
}
