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

	private TrafficSimulationSystem system;
	private Place[] leftRoad;
	private Place[] rightRoad;

	private GridLayout westLayout = new GridLayout(1, 100);
	private JPanel mainPanel = new JPanel();
	private JPanel leftRoadPanel = new JPanel();
	private JPanel rightRoadPanel = new JPanel();

	public Gui(TrafficSimulationSystem system) {
		this.system = system;
		
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(2, 2));
		mainPanel.add(leftRoadPanel);
		mainPanel.add(rightRoadPanel);
		
		leftRoadPanel.setLayout(westLayout);
		rightRoadPanel.setLayout(westLayout);
		
		setSize(1600, 75);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		while (true) {
			leftRoad = system.getLeftRoad();
			rightRoad = system.getRightRoad();
			
			leftRoadPanel.removeAll();
			rightRoadPanel.removeAll();
			
			for (Place p : leftRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle().getImage()));
					leftRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					leftRoadPanel.add(label);
				}
			}
			
			for (Place p : rightRoad) {
				if (!p.isFree()) {
					JLabel label = new JLabel(new ImageIcon(p.getVehicle().getImage()));
					rightRoadPanel.add(label);
				} else {
					JLabel label = new JLabel();
					rightRoadPanel.add(label);
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
