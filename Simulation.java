import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
public class Simulation extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private Thread t1;
	private boolean running;
	private World world;
	private MouseInput mi;
	public void initalize() {
		world = new World(getWidth(),getHeight(),10 );
		mi = new MouseInput(world);
		setFocusable(true);
		addMouseListener(mi);
		addMouseMotionListener(mi);
		addMouseListener(mi);
	}
	public void start() {
		if(running)
			return;
		running = true;
		t1 = new Thread(this);
		t1.start();
	}
	@Override
	public void run() {
		initalize();
		while(running) {
			update();
			render();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void update() {
		world.update();
	}
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D)bs.getDrawGraphics();
		g.fillRect(0,0,getWidth(),getHeight());
		world.render(g);
		g.dispose();
		bs.show();
	}
	public MouseInput getInput() {
		return mi;
	}
}
