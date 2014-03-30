package ie.ul.trafficsim.frontend;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.system.TrafficSimulationSystem;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

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

	private List<Place[]> roads = new ArrayList<>();
	private List<JPanel> roadPanels = new ArrayList<>();

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
		roadPanels.add(westLeftRoadPanel);
		roadPanels.add(westRightRoadPanel);
		roadPanels.add(eastLeftRoadPanel);
		roadPanels.add(eastRightRoadPanel);
		roadPanels.add(northLeftRoadPanel);
		roadPanels.add(northRightRoadPanel);
		roadPanels.add(southLeftRoadPanel);
		roadPanels.add(southRightRoadPanel);

		westLeftRoad = system.getRoadLayout().get("westLeftRoad");
		westRightRoad = system.getRoadLayout().get("westRightRoad");
		eastLeftRoad = system.getRoadLayout().get("eastLeftRoad");
		eastRightRoad = system.getRoadLayout().get("eastRightRoad");
		northLeftRoad = system.getRoadLayout().get("northLeftRoad");
		northRightRoad = system.getRoadLayout().get("northRightRoad");
		southLeftRoad = system.getRoadLayout().get("southLeftRoad");
		southRightRoad = system.getRoadLayout().get("southRightRoad");
		
		roads.add(westLeftRoad);
		roads.add(westRightRoad);
		roads.add(eastLeftRoad);
		roads.add(eastRightRoad);
		roads.add(northLeftRoad);
		roads.add(northRightRoad);
		roads.add(southLeftRoad);
		roads.add(southRightRoad);

		add(mainPanel);
		mainPanel.setLayout(new GridLayout(6, 2));
		mainPanel.add(new JLabel("North Left Road", JLabel.RIGHT));
		mainPanel.add(northLeftRoadPanel);
		mainPanel.add(new JLabel("North Right Road", JLabel.RIGHT));
		mainPanel.add(northRightRoadPanel);
		mainPanel.add(westLeftRoadPanel);
		mainPanel.add(eastLeftRoadPanel);
		mainPanel.add(westRightRoadPanel);
		mainPanel.add(eastRightRoadPanel);
		mainPanel.add(southLeftRoadPanel);
		mainPanel.add(new JLabel("South Left Road"));
		mainPanel.add(southRightRoadPanel);
		mainPanel.add(new JLabel("South Right Road"));

		for (JPanel panel : roadPanels) {
			panel.setLayout(roadGridLayout);
		}

		setSize(1600, 150);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		while (true) {
			int i = 0;
			for (JPanel panel : roadPanels) {
				panel.removeAll();

				for (Place place : roads.get(i)) {
					if (!place.isFree()) {
						panel.add(new JLabel(new ImageIcon(place.getVehicle().getImage())));
					} else {
						panel.add(new JLabel());
					}
				}
				i++;
			}

			validate();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
}
