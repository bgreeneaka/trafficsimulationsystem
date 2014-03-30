package ie.ul.trafficsim.system;

import java.util.Map;

import ie.ul.trafficsim.road.Place;

public interface TrafficSimulationSystem {

	public void begin();
	
	public Map<String, Place[]> getRoadLayout();
}
