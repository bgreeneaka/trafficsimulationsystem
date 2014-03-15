package ie.ul.trafficsim.drivers;

import ie.ul.trafficsim.planning.Look;
import ie.ul.trafficsim.road.Place;

public class AggressiveDriver implements Driver {

	private int speed = 100;
	
	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public boolean lookForward(Place place, int numberOfPlaces) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lookBackward(Place place, int numberOfPlaces) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLookForward(Look look) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLookBackward(Look look) {
		// TODO Auto-generated method stub
		
	}
}
