package planning;

import road.Place;

public class LookForward implements Look {
	
	@Override
	public boolean look(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			place = place.getNextPlace();
		}
		return place.isFree();
	}
}
