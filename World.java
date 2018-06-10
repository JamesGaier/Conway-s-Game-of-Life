import java.awt.Graphics2D;
import java.util.Random;
public class World {
	private Creature[][] world;
	private int scale;
	public World(int width,int height,int scale) {
		this.scale = scale;
		world = new Creature[width/(scale)][height/(scale)];
		initalize();
	}
	private void initalize() {
		for(int i = 0; i < world.length; i++) {
			for(int j = 0; j < world[i].length; j++) {
				world[i][j] = new Creature(i,j,scale);
			}
		}
		for(int i = 0;i < world.length; i++) {
			for(int j = 0; j < world[0].length; j++) {
				//world[i][j].setActive(true);
				if(new Random().nextInt(100) == 1) {
					//world[i][j].setAlive(true);
				}
			}
		}
	}
	public void update() {
		for(Creature[] c : world) {
			for(Creature c1 : c) {
				c1.update(world);
			}
		}
	}
	public void render(Graphics2D g) {
		for(Creature[] c : world) {
			for(Creature c1 : c) {
				c1.render(g);
			}
		}
	}
	public Creature[][] getWorld(){
		return world;
	}
	public int getScale() {
		return scale;
	}
}
