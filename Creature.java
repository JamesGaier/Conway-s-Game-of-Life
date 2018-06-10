import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Arrays;
/**
 * 
 * @author James
 * 
 */
public class Creature{
	private boolean alive,active;
	private int x,y,scale;
	private Creature[] neighbors;
	private Creature[][] world;
	public Creature(int x, int y, int scale) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		alive = false;
		active = false;
	}
	public void update(Creature[][] world) {
		this.world = world;
		if(x != 0 && y != 0 && x != world.length-1 && y != world[0].length-1 && active) {
			neighbors = new Creature[] {
					world[x-1][y+1], world[x][y+1], 
					world[x+1][y+1], world[x-1][y], 
					world[x+1][y],world[x-1][y-1],
					world[x][y-1], world[x+1][y-1] 
			};
			int aliveCreature = 0;
			for(Creature neighbor : neighbors) {
				if(neighbor.getAlive()) {
					aliveCreature++;
				}
			}
			if(aliveCreature < 2) {
				alive = false;
			}
			else if(aliveCreature >= 2 && aliveCreature <= 3) {
				alive = true;
			}
			else if(aliveCreature == 3 && !alive) {
				alive = true;
			}
			else if(aliveCreature > 3) {
				alive = false;
			}
		}
	}
	public void render(Graphics2D g) {
		g.setColor((alive) ? Color.WHITE : Color.BLACK);
		g.fillRect(x*scale, y*scale, scale*scale, scale*scale);
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean getAlive() {
		return alive;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
