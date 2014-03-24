package ie.ul.trafficsim.planning;

import ie.ul.trafficsim.road.Place;

public interface Look {

	public boolean forward(Place place, int numberOfPlaces);
	
	public boolean backward(Place place, int numberOfPlaces);
	
	public boolean right(Place place);
}
