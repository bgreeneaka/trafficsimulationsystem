package frontend;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import road.Place;
import system.TrafficSimulationSystem;

@SuppressWarnings("serial")
public class Gui extends JFrame implements Runnable {

	private TrafficSimulationSystem system;
	private Place[] leftRoad;
	private Place[] rightRoad;

	private GridLayout layout = new GridLayout(1, 100);
	private JPanel mainPanel = new JPanel();
	private JPanel leftRoadPanel = new JPanel();
	private JPanel rightRoadPanel = new JPanel();

	public Gui(TrafficSimulationSystem system) {
		this.system = system;
		
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(2, 1));
		mainPanel.add(leftRoadPanel);
		mainPanel.add(rightRoadPanel);
		
		leftRoadPanel.setLayout(layout);
		rightRoadPanel.setLayout(layout);
		
		setSize(1600, 75);
		setVisible(true);
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
					JButton button = new JButton(new ImageIcon("car.jpg"));
					leftRoadPanel.add(button);
				} else {
					JButton button = new JButton();
					leftRoadPanel.add(button);
				}
			}
			
			for (Place p : rightRoad) {
				if (!p.isFree()) {
					JButton button = new JButton(new ImageIcon("car.jpg"));
					rightRoadPanel.add(button);
				} else {
					JButton button = new JButton();
					rightRoadPanel.add(button);
				}
			}
			
			validate();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
}
