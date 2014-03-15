package ie.ul.trafficsim.planning;

import ie.ul.trafficsim.road.Place;

public class LookBackward implements Look {

	@Override
	public boolean look(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			place = place.getPreviousPlace();
		}
		return place.isFree();
	}
}
