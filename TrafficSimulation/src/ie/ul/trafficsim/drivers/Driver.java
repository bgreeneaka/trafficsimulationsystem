package ie.ul.trafficsim.drivers;

import ie.ul.trafficsim.planning.CheckPath;
import ie.ul.trafficsim.planning.Look;
import ie.ul.trafficsim.road.Place;

public interface Driver {

	public int getSpeed();
	
	public boolean lookForward(Place place, int numberOfPlaces);
	
	public boolean lookBackward(Place place, int numberOfPlaces);
	
	public boolean checkLeftPath(Place place, int numberOfPlaces);
	
	public boolean checkRightPath(Place place, int numberOfPlaces);
	
	public void setLookForward(Look look);
	
	public void setLookBackward(Look look);
	
	public void setCheckPath(CheckPath checkPath);
}
