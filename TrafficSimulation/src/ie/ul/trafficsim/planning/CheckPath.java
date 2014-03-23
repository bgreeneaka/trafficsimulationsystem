package ie.ul.trafficsim.planning;

import ie.ul.trafficsim.road.Place;

public interface CheckPath {

	public boolean checkLeftPath(Place place, int numberOfPlaces);

	public boolean checkRightPath(Place place, int numberOfPlaces);
}
