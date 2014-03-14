package system;

import planning.DirectRoute;
import vehicles.Car;
import vehicles.VehicleBuilder;
import vehicles.VehicleBuilderImpl;
import drivers.StandardDriver;
import frontend.Gui;

public class TrafficSimulationSystemImpl implements TrafficSimulationSystem {

	Place[] road = new Place[100];

	@Override
	public void begin() {
		setupRoad();
		
		new Thread(new Gui(this)).start();
		
		setupVehicles();
	}

	public static void main(String[] args) {
		TrafficSimulationSystem system = new TrafficSimulationSystemImpl();		
		system.begin();		
	}

	private void setupVehicles() {
		VehicleBuilder builder = new VehicleBuilderImpl();

		for (int i = 0; i < 25; i++) {
			
			road[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver())
					.withRoute(new DirectRoute()).build());
			road[0].getVehicle().setPlace(road[0]);

			
			new Thread((Runnable) road[0].getVehicle()).start();
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}

	private void display() {
		for (int i = 0; i < road.length; i++) {
			if (road[i].isFree()) {
				System.out.print("_");
			} else {
				System.out.print("X");
			}
		}
		System.out.println("\n");
	}

	private void setupRoad() {
		road[0] = new RoadPlace();
		road[1] = new RoadPlace();

		road[0].setNextPlace(road[1]);

		for (int i = 2; i < road.length; i++) {
			road[i] = new RoadPlace();
			road[i - 1].setNextPlace(road[i]);
		}

		road[road.length - 1].setNextPlace(road[0]);
	}
	
	public Place[] getState() {
		return road;
	}
}
