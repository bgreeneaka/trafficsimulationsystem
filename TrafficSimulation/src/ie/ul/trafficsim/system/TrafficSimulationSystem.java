package ie.ul.trafficsim.system;

import ie.ul.trafficsim.road.Place;

public interface TrafficSimulationSystem {

	public void begin();
	
	public Place[] getLeftRoad();
	
	public Place[] getRightRoad();
}
