import java.awt.Dimension;

import javax.swing.JFrame;
public class Window {
	private int width,height;
	private static final int DEFAULT_WIDTH = 800, DEFAULT_HEIGHT = 1024;
	public Window(String title, Simulation sim) {
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT,title,sim);
	}
	public Window(int width,int height, String title, Simulation sim) {
		this.width = width;
		this.height = height;
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setMaximumSize(new Dimension(width,height));
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.add(sim);
		frame.setFocusable(true);
		frame.addMouseMotionListener(sim.getInput());
		frame.addMouseListener(sim.getInput());
		frame.setResizable(false);
		frame.setVisible(true);
		sim.start();
	}
}
