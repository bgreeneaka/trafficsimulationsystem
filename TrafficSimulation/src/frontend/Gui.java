package frontend;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import system.Place;
import system.TrafficSimulationSystem;

@SuppressWarnings("serial")
public class Gui extends JFrame implements Runnable {

	private TrafficSimulationSystem system;
	private Place[] road;

	private GridLayout layout = new GridLayout(1, 100);
	private JPanel panel = new JPanel();

	public Gui(TrafficSimulationSystem system) {
		this.system = system;
		add(panel);
		setSize(1600, 50);
		panel.setLayout(layout);
		setVisible(true);
	}

	@Override
	public void run() {
		while (true) {
			road = system.getState();
			panel.removeAll();
			for (Place p : road) {
				if (!p.isFree()) {
					JButton button = new JButton(new ImageIcon("car.jpg"));
					panel.add(button);
				} else {
					JButton button = new JButton();
					panel.add(button);
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
