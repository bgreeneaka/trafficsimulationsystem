package system;

import road.CreateRoad;
import road.Place;
import road.Road;
import vehicles.Car;
import vehicles.VehicleBuilder;
import vehicles.VehicleBuilderImpl;
import drivers.StandardDriver;
import frontend.Gui;

public class TrafficSimulationSystemImpl implements TrafficSimulationSystem {

	Place[] westLeftRoad;
	Place[] westRightRoad;
	Place[] southLeftRoad;
	Place[] southRightRoad;

	@Override
	public void begin() {
		Road road = new CreateRoad();
		
		road.create();
		westLeftRoad = road.getLeftRoad();
		westRightRoad = road.getRightRoad();
		
		road.create();
		southLeftRoad = road.getLeftRoad();
		southRightRoad = road.getRightRoad();

		new Thread(new Gui(this)).start();

		setupVehicles();
	}

	public static void main(String[] args) {
		TrafficSimulationSystem system = new TrafficSimulationSystemImpl();
		system.begin();
	}

	private void setupVehicles() {
		VehicleBuilder builder = new VehicleBuilderImpl();

		for (int i = 0; i < 10; i++) {

			westLeftRoad[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver()).withColour("black_car.jpg").build());
			westLeftRoad[0].getVehicle().setPlace(westLeftRoad[0]);

			new Thread((Runnable) westLeftRoad[0].getVehicle()).start();

			westRightRoad[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver()).withColour("red_car.jpg").build());
			westRightRoad[0].getVehicle().setPlace(westRightRoad[0]);

			new Thread((Runnable) westRightRoad[0].getVehicle()).start();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}

	public Place[] getLeftRoad() {
		return westLeftRoad;
	}

	@Override
	public Place[] getRightRoad() {
		return westRightRoad;
	}
}
