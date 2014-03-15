package ie.ul.trafficsim.drivers;

import ie.ul.trafficsim.planning.Look;
import ie.ul.trafficsim.road.Place;

public class StandardDriver implements Driver {

	private int speed = 250;
	private Look lookForward;
	private Look lookBackward;
	
	@Override
	public int getSpeed() {		
		return speed;
	}

	@Override
	public boolean lookForward(Place place, int numberOfPlaces) {
		return lookForward.look(place, numberOfPlaces);
	}

	@Override
	public boolean lookBackward(Place place, int numberOfPlaces) {
		return lookBackward.look(place, numberOfPlaces);
	}

	@Override
	public void setLookForward(Look look) {
		this.lookForward = look;
	}

	@Override
	public void setLookBackward(Look look) {
		this.lookBackward = look;
	}
}
