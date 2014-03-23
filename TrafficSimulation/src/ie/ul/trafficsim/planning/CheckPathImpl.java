package ie.ul.trafficsim.planning;

import ie.ul.trafficsim.road.Place;

public class CheckPathImpl implements CheckPath {

	Look lookForward;
	Look lookBackward;

	public CheckPathImpl(Look lookForward, Look lookBackward) {
		this.lookForward = lookForward;
		this.lookBackward = lookBackward;
	}

	@Override
	public boolean checkRightPath(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			if (!lookBackward.look(place, i)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLeftPath(Place place, int numberOfPlaces) {
		for (int i = 0; i < numberOfPlaces; i++) {
			if (!lookForward.look(place, i)) {
				return false;
			}
			place = place.getNextPlace();
		}
		return true;
	}
}
