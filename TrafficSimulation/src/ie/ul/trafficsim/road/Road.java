package ie.ul.trafficsim.road;

public interface Road {

	public void create();
	
	public Place[] getLeftRoad();
	
	public Place[] getRightRoad();
}
