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

	Place[] leftRoad;
	Place[] rightRoad;

	@Override
	public void begin() {
		Road road = new CreateRoad();
		road.create();
		leftRoad = road.getLeftRoad();
		rightRoad = road.getRightRoad();

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

			leftRoad[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver()).withColour("black_car.jpg").build());
			leftRoad[0].getVehicle().setPlace(leftRoad[0]);

			new Thread((Runnable) leftRoad[0].getVehicle()).start();

			rightRoad[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver()).withColour("red_car.jpg").build());
			rightRoad[0].getVehicle().setPlace(rightRoad[0]);

			new Thread((Runnable) rightRoad[0].getVehicle()).start();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

	private void display() {
		for (int i = 0; i < rightRoad.length; i++) {
			if (rightRoad[i].isFree()) {
				System.out.print("_");
			} else {
				System.out.print("X");
			}
		}
		System.out.println("\n");
	}

	public Place[] getLeftRoad() {
		return leftRoad;
	}

	@Override
	public Place[] getRightRoad() {
		return rightRoad;
	}
}
