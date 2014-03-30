package ie.ul.trafficsim.frontend;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.system.TrafficSimulationSystem;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Gui extends JFrame implements Runnable {

	private Place[] westLeftRoad;
	private Place[] westRightRoad;
	private Place[] eastLeftRoad;
	private Place[] eastRightRoad;
	private Place[] southLeftRoad;
	private Place[] southRightRoad;
	private Place[] northLeftRoad;
	private Place[] northRightRoad;

	private GridLayout roadGridLayout = new GridLayout(1, 100);

	private JPanel mainPanel = new JPanel();
	private JPanel westLeftRoadPanel = new JPanel();
	private JPanel westRightRoadPanel = new JPanel();
	private JPanel eastLeftRoadPanel = new JPanel();
	private JPanel eastRightRoadPanel = new JPanel();
	private JPanel northLeftRoadPanel = new JPanel();
	private JPanel northRightRoadPanel = new JPanel();
	private JPanel southLeftRoadPanel = new JPanel();
	private JPanel southRightRoadPanel = new JPanel();

	public Gui(TrafficSimulationSystem system) {
		westLeftRoad = system.getRoadLayout().get("westLeftRoad");
		westRightRoad = system.getRoadLayout().get("westRightRoad");
		eastLeftRoad = system.getRoadLayout().get("eastLeftRoad");
		eastRightRoad = system.getRoadLayout().get("eastRightRoad");
		northLeftRoad = system.getRoadLayout().get("northLeftRoad");
		northRightRoad = system.getRoadLayout().get("northRightRoad");
		southLeftRoad = system.getRoadLayout().get("southLeftRoad");
		southRightRoad = system.getRoadLayout().get("southRightRoad");

		add(mainPanel);
		mainPanel.setLayout(new GridLayout(6, 2));
		mainPanel.add(northLeftRoadPanel);
		mainPanel.add(new JLabel("North Left Road"));
		mainPanel.add(northRightRoadPanel);
		mainPanel.add(new JLabel("North Right Road"));
		mainPanel.add(westLeftRoadPanel);
		mainPanel.add(eastLeftRoadPanel);
		mainPanel.add(westRightRoadPanel);
		mainPanel.add(eastRightRoadPanel);
		mainPanel.add(southLeftRoadPanel);
		mainPanel.add(new JLabel("South Left Road"));
		mainPanel.add(southRightRoadPanel);
		mainPanel.add(new JLabel("South Right Road"));

		westLeftRoadPanel.setLayout(roadGridLayout);
		westRightRoadPanel.setLayout(roadGridLayout);
		eastLeftRoadPanel.setLayout(roadGridLayout);
		eastRightRoadPanel.setLayout(roadGridLayout);
		northLeftRoadPanel.setLayout(roadGridLayout);
		northRightRoadPanel.setLayout(roadGridLayout);
		southLeftRoadPanel.setLayout(roadGridLayout);
		southRightRoadPanel.setLayout(roadGridLayout);

		setSize(1600, 150);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		while (true) {
			westLeftRoadPanel.removeAll();
			westRightRoadPanel.removeAll();
			eastLeftRoadPanel.removeAll();
			eastRightRoadPanel.removeAll();
			northLeftRoadPanel.removeAll();
			northRightRoadPanel.removeAll();
			southLeftRoadPanel.removeAll();
			southRightRoadPanel.removeAll();

			for (Place p : westLeftRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					westLeftRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					westLeftRoadPanel.add(label);
				}
			}

			for (Place p : westRightRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					westRightRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					westRightRoadPanel.add(label);
				}
			}

			for (Place p : eastLeftRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					eastLeftRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					eastLeftRoadPanel.add(label);
				}
			}

			for (Place p : eastRightRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					eastRightRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					eastRightRoadPanel.add(label);
				}
			}
			
			for (Place p : northLeftRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					northLeftRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					northLeftRoadPanel.add(label);
				}
			}

			for (Place p : northRightRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					northRightRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					northRightRoadPanel.add(label);
				}
			}

			for (Place p : southLeftRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					southLeftRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					southLeftRoadPanel.add(label);
				}
			}

			for (Place p : southRightRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle()
							.getImage()));
					southRightRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					southRightRoadPanel.add(label);
				}
			}

			validate();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
