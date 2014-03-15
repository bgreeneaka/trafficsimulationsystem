package road;

public class CreateRoad implements Road {

	Place[] leftRoad = new Place[100];
	Place[] rightRoad = new Place[100];

	@Override
	public void create() {
		leftRoad[0] = new RoadPlace();
		leftRoad[1] = new RoadPlace();

		leftRoad[0].setNextPlace(leftRoad[1]);
		leftRoad[1].setPreviousPlace(leftRoad[0]);

		rightRoad[0] = new RoadPlace();
		rightRoad[1] = new RoadPlace();

		rightRoad[0].setPreviousPlace(rightRoad[1]);
		rightRoad[1].setNextPlace(rightRoad[0]);
		
		leftRoad[0].setRightPlace(rightRoad[0]);
		rightRoad[0].setLeftPlace(leftRoad[0]);
		
		leftRoad[1].setRightPlace(rightRoad[1]);
		rightRoad[1].setLeftPlace(leftRoad[1]);

		for (int i = 2; i < leftRoad.length; i++) {
			leftRoad[i] = new RoadPlace();
			leftRoad[i - 1].setNextPlace(leftRoad[i]);
			leftRoad[i].setPreviousPlace(leftRoad[i - 1]);

			rightRoad[i] = new RoadPlace();
			rightRoad[i - 1].setPreviousPlace(rightRoad[i]);
			rightRoad[i].setNextPlace(rightRoad[i - 1]);
			
			leftRoad[i].setRightPlace(rightRoad[i]);
			rightRoad[i].setLeftPlace(leftRoad[i]);
		}

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
