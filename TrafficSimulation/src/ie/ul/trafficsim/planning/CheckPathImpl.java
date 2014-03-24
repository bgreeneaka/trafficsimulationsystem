package ie.ul.trafficsim.planning;

import ie.ul.trafficsim.road.Place;

public class CheckPathImpl implements CheckPath {

	Look look;

	public CheckPathImpl(Look look) {
		this.look = look;
	}

	@Override
	public boolean checkRightPath(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			if (!look.backward(place, i)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLeftPath(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			if (!look.forward(place, i)) {
				return false;
			}
			place = place.getNextPlace();
		}
		return true;
	}
}
