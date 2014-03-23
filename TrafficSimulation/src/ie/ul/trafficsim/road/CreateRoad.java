package ie.ul.trafficsim.road;

public class CreateRoad implements Road {

	Place[] leftRoad;
	Place[] rightRoad;

	@Override
	public void create() {
		leftRoad = new Place[100];
		rightRoad = new Place[100];

		// Initialize the first 2 places in each side of the road as we need
		// them to bootstrap the process of linking each Place to its neighbours
		leftRoad[0] = new RoadPlace();
		leftRoad[1] = new RoadPlace();

		rightRoad[0] = new RoadPlace();
		rightRoad[1] = new RoadPlace();

		// Link each of the first 2 Places to its neighbours
		leftRoad[0].setNextPlace(leftRoad[1]);
		leftRoad[1].setPreviousPlace(leftRoad[0]);

		rightRoad[0].setPreviousPlace(rightRoad[1]);
		rightRoad[1].setNextPlace(rightRoad[0]);

		leftRoad[0].setRightPlace(rightRoad[0]);
		rightRoad[0].setRightPlace(leftRoad[0]);

		leftRoad[1].setRightPlace(rightRoad[1]);
		rightRoad[1].setRightPlace(leftRoad[1]);

		// Link each Place to its neighbours
		for (int i = 2; i < leftRoad.length; i++) {
			leftRoad[i] = new RoadPlace();
			leftRoad[i - 1].setNextPlace(leftRoad[i]);
			leftRoad[i].setPreviousPlace(leftRoad[i - 1]);

			rightRoad[i] = new RoadPlace();
			rightRoad[i - 1].setPreviousPlace(rightRoad[i]);
			rightRoad[i].setNextPlace(rightRoad[i - 1]);

			leftRoad[i].setRightPlace(rightRoad[i]);
			rightRoad[i].setRightPlace(leftRoad[i]);
		}

		// Setup a link between the first and last Places of each road half so
		// we get infinite looping road
		leftRoad[leftRoad.length - 1].setNextPlace(leftRoad[0]);
		leftRoad[0].setPreviousPlace(leftRoad[leftRoad.length - 1]);

		rightRoad[rightRoad.length - 1].setPreviousPlace(rightRoad[0]);
		rightRoad[0].setNextPlace(rightRoad[rightRoad.length - 1]);
	}

	@Override
	public Place[] getLeftRoad() {
		return leftRoad;
	}

	@Override
	public Place[] getRightRoad() {
		return rightRoad;
	}
}
