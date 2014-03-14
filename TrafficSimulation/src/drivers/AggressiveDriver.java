package drivers;

public class AggressiveDriver implements Driver {

	private int placesMoved = 2;
	
	@Override
	public int getSpeed() {
		return placesMoved;
	}
}
