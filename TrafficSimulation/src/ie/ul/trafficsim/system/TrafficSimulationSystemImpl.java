package ie.ul.trafficsim.system;

import java.util.HashMap;
import java.util.Map;

import ie.ul.trafficsim.drivers.StandardDriver;
import ie.ul.trafficsim.frontend.Gui;
import ie.ul.trafficsim.road.CreateRoad;
import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.road.Road;
import ie.ul.trafficsim.vehicles.Car;
import ie.ul.trafficsim.vehicles.VehicleBuilder;
import ie.ul.trafficsim.vehicles.VehicleBuilderImpl;

public class TrafficSimulationSystemImpl implements TrafficSimulationSystem {

	private Place[] westLeftRoad;
	private Place[] westRightRoad;
	private Place[] eastLeftRoad;
	private Place[] eastRightRoad;
	private Place[] southLeftRoad;
	private Place[] southRightRoad;
	private Place[] northLeftRoad;
	private Place[] northRightRoad;

	Map<String, Place[]> roadLayout;

	@Override
	public void begin() {
		setupRoads();
		setupRoadLinks();
		setupRoadLayoutMap();

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
					.withDriver(new StandardDriver())
					.withColour("black_car.jpg").build());

			westLeftRoad[0].getVehicle().setPlace(westLeftRoad[0]);

			new Thread((Runnable) westLeftRoad[0].getVehicle()).start();

			westRightRoad[westRightRoad.length - 1].setVehicle((Car) builder
					.withVehicle(new Car()).withDriver(new StandardDriver())
					.withColour("red_car.jpg").build());

			westRightRoad[westRightRoad.length - 1].getVehicle().setPlace(
					westRightRoad[westRightRoad.length - 1]);

			new Thread(
					(Runnable) westRightRoad[westRightRoad.length - 1]
							.getVehicle()).start();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}

	private void setupRoads() {
		Road road = new CreateRoad();

		road.create();
		westLeftRoad = road.getLeftRoad();
		westRightRoad = road.getRightRoad();

		road.create();
		eastLeftRoad = road.getLeftRoad();
		eastRightRoad = road.getRightRoad();

		road.create();
		southLeftRoad = road.getLeftRoad();
		southRightRoad = road.getRightRoad();

		road.create();
		northLeftRoad = road.getLeftRoad();
		northRightRoad = road.getRightRoad();
	}

	private void setupRoadLayoutMap() {
		roadLayout = new HashMap<>();
		roadLayout.put("westLeftRoad", westLeftRoad);
		roadLayout.put("westRightRoad", westRightRoad);
		roadLayout.put("eastLeftRoad", eastLeftRoad);
		roadLayout.put("eastRightRoad", eastRightRoad);
		roadLayout.put("southLeftRoad", southLeftRoad);
		roadLayout.put("southRightRoad", southRightRoad);
		roadLayout.put("northLeftRoad", northLeftRoad);
		roadLayout.put("northRightRoad", northRightRoad);
	}

	private void setupRoadLinks() {
		// West East Road Links
		westLeftRoad[westLeftRoad.length - 1].setNextPlace(eastLeftRoad[0]);
		eastLeftRoad[0].setPreviousPlace(westLeftRoad[westLeftRoad.length - 1]);

		westLeftRoad[0].setPreviousPlace(eastLeftRoad[eastLeftRoad.length - 1]);
		eastLeftRoad[eastLeftRoad.length - 1].setNextPlace(westLeftRoad[0]);

		westRightRoad[0].setNextPlace(eastRightRoad[eastRightRoad.length - 1]);
		eastRightRoad[eastRightRoad.length - 1]
				.setPreviousPlace(westRightRoad[0]);

		westRightRoad[westRightRoad.length - 1]
				.setPreviousPlace(eastRightRoad[0]);
		eastRightRoad[0].setNextPlace(westRightRoad[westRightRoad.length - 1]);
	}

	@Override
	public Map<String, Place[]> getRoadLayout() {
		return roadLayout;
	}
}
