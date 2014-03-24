package ie.ul.trafficsim.planning;

import ie.ul.trafficsim.road.Place;

public class LookImpl implements Look {
	
	@Override
	public boolean forward(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			place = place.getNextPlace();
		}
		return place.isFree();
	}

	@Override
	public boolean backward(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			place = place.getPreviousPlace();
		}
		return place.isFree();
	}
	
	@Override
	public boolean right(Place place) {
		return place.getRightPlace().isFree();
	}
}
