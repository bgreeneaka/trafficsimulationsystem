package ie.ul.trafficsim.system;

import ie.ul.trafficsim.road.Place;

public interface TrafficSimulationSystem {

	public void begin();

	public Place[] getWestLeftRoad();

	public Place[] getWestRightRoad();

	public Place[] getSouthLeftRoad();

	public Place[] getSouthRightRoad();
}
