package system;

import road.Place;

public interface TrafficSimulationSystem {

	public void begin();
	
	public Place[] getLeftRoad();
	
	public Place[] getRightRoad();
}
