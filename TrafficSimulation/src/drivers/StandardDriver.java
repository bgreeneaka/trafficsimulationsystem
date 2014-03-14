package drivers;

public class StandardDriver implements Driver {

	private int speed = 250;
	
	@Override
	public int getSpeed() {		
		return speed;
	}
}
