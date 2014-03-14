package drivers;

public class AggressiveDriver implements Driver {

	private int speed = 100;
	
	@Override
	public int getSpeed() {
		return speed;
	}
}
