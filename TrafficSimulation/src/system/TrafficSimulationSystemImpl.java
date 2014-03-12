package system;

import planning.DirectRoute;
import drivers.StandardDriver;
import frontend.Gui;
import vehicles.Car;
import vehicles.VehicleBuilder;
import vehicles.VehicleBuilderImpl;

public class TrafficSimulationSystemImpl implements TrafficSimulationSystem {

	Place[] road = new Place[100];

	@Override
	public void run() {
		setupRoad();
		setupVehicles();

		new Thread(new Gui(this)).start();

		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

			}
		}
	}

	public static void main(String[] args) {
		TrafficSimulationSystem system = new TrafficSimulationSystemImpl();		
		system.run();		
	}

	private void setupVehicles() {
		VehicleBuilder builder = new VehicleBuilderImpl();

		for (int i = 0; i < 25; i++) {
			int j = (int) (Math.random() * road.length);

			road[j].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver())
					.withRoute(new DirectRoute()).build());
			road[j].getVehicle().setPlace(road[j]);

			new Thread((Runnable) road[j].getVehicle()).start();
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
