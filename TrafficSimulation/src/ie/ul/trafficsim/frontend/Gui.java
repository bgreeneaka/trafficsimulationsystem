package ie.ul.trafficsim.frontend;

import ie.ul.trafficsim.road.Place;
import ie.ul.trafficsim.system.TrafficSimulationSystem;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
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
	
	private GridLayout outerLayout = new GridLayout(3, 1);
	private GridLayout northSouthContainer = new GridLayout(1, 3);
	private GridLayout eastWestGrid = new GridLayout(2, 2);
	private GridLayout northSouthGird = new GridLayout(1, 2);
	private JPanel topPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel topMiddlePanel = new JPanel();
	private JPanel bottomMiddlePanel = new JPanel();

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
		mainPanel.setLayout(outerLayout);
		
		topPanel.setLayout(northSouthContainer);
		topPanel.add(new JLabel());
		topMiddlePanel.setLayout(northSouthGird);
		topMiddlePanel.add(northLeftRoadPanel);
		topMiddlePanel.add(northRightRoadPanel);
		topPanel.add(topMiddlePanel);
		topPanel.add(new JLabel());
		
		bottomPanel.setLayout(northSouthContainer);
		bottomPanel.add(new JLabel());
		bottomMiddlePanel.setLayout(northSouthGird);
		bottomMiddlePanel.add(southLeftRoadPanel);
		bottomMiddlePanel.add(southRightRoadPanel);
		bottomPanel.add(bottomMiddlePanel);
		bottomPanel.add(new JLabel());
		
		middlePanel.setLayout(eastWestGrid);
		middlePanel.add(westLeftRoadPanel);
		middlePanel.add(eastLeftRoadPanel);
		middlePanel.add(westRightRoadPanel);
		middlePanel.add(eastRightRoadPanel);
		
		mainPanel.add(topPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(bottomPanel);
//		mainPanel.setLayout(new GridLayout(6, 2));
//		mainPanel.add(northLeftRoadPanel);
//		mainPanel.add(new JLabel("North Left Road"));
//		mainPanel.add(northRightRoadPanel);
//		mainPanel.add(new JLabel("North Right Road"));
//		mainPanel.add(westLeftRoadPanel);
//		mainPanel.add(eastLeftRoadPanel);
//		mainPanel.add(westRightRoadPanel);
//		mainPanel.add(eastRightRoadPanel);
//		mainPanel.add(new JLabel("South Left Road", JLabel.RIGHT));
//		mainPanel.add(southLeftRoadPanel);
//		mainPanel.add(new JLabel("South Right Road", JLabel.RIGHT));
//		mainPanel.add(southRightRoadPanel);

		for (JPanel panel : roadPanels) {
			panel.setLayout(roadGridLayout);
		}
		
		northLeftRoadPanel.setLayout(new GridLayout(25, 1));
		northRightRoadPanel.setLayout(new GridLayout(25, 1));
		
		southLeftRoadPanel.setLayout(new GridLayout(50, 1));
		southRightRoadPanel.setLayout(new GridLayout(50, 1));

		setSize(1600, 1000);
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
