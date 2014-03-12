package drivers;

public class StandardDriver implements Driver {

	private int placesMoved = 1;
	
	@Override
	public int getPlacesMoved() {		
		return placesMoved;
	}
}
