package ie.ul.trafficsim.system;

import ie.ul.trafficsim.drivers.StandardDriver;
import ie.ul.trafficsim.frontend.Gui;
import ie.ul.trafficsim.road.CreateRoad;
import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.road.Road;
import ie.ul.trafficsim.vehicles.Car;
import ie.ul.trafficsim.vehicles.VehicleBuilder;
import ie.ul.trafficsim.vehicles.VehicleBuilderImpl;

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
			
			southLeftRoad[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver()).withColour("red_car.jpg").build());
			southLeftRoad[0].getVehicle().setPlace(southLeftRoad[0]);
			
			new Thread((Runnable) southLeftRoad[0].getVehicle()).start();
			
			southRightRoad[0].setVehicle((Car) builder.withVehicle(new Car())
					.withDriver(new StandardDriver()).withColour("red_car.jpg").build());
			southRightRoad[0].getVehicle().setPlace(southRightRoad[0]);
			
			new Thread((Runnable) southRightRoad[0].getVehicle()).start();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
	@Override
	public Place[] getWestLeftRoad() {
		return westLeftRoad;
	}

	@Override
	public Place[] getWestRightRoad() {
		return westRightRoad;
	}
	
	
	@Override
	public Place[] getSouthLeftRoad() {
		return southLeftRoad;
	}
	
	@Override
	public Place[] getSouthRightRoad() {
		return southRightRoad;
	}
	
}
