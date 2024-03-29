package ie.ul.trafficsim.drivers;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.vision.CheckPath;
import ie.ul.trafficsim.vision.Look;

public interface Driver {

	public int getSpeed();
	
	public void setSpeed(int speed);
	
	public boolean lookForward(Place place, int numberOfPlaces);
	
	public boolean lookBackward(Place place, int numberOfPlaces);
	
	public boolean lookRight(Place place);
	
	public boolean lookLeft(Place place);
	
	public boolean checkLeftPath(Place place, int numberOfPlaces);
	
	public boolean checkRightPath(Place place, int numberOfPlaces);
	
	public void setLook(Look look);
	
	public void setCheckPath(CheckPath checkPath);
}
