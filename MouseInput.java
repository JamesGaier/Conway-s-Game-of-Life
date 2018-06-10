import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener,MouseMotionListener{
	private World simWorld;
	public MouseInput(World simWorld) {
		this.simWorld = simWorld;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
/*
 *,  
					,  
					
					world[x][y-1], 
 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getX()/simWorld.getScale() >= 0 && e.getY()/simWorld.getScale() >= 0) {
			simWorld.getWorld()[e.getX()/simWorld.getScale()+1][e.getY()/simWorld.getScale()+1].setActive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()+1][e.getY()/simWorld.getScale()-1].setActive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()-1][e.getY()/simWorld.getScale()+1].setActive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()-1][e.getY()/simWorld.getScale()-1].setActive(true);
			
			simWorld.getWorld()[e.getX()/simWorld.getScale()][e.getY()/simWorld.getScale()+1].setActive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()+1][e.getY()/simWorld.getScale()].setActive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()-1][e.getY()/simWorld.getScale()].setActive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()][e.getY()/simWorld.getScale()-1].setActive(true);
			
			simWorld.getWorld()[e.getX()/simWorld.getScale()][e.getY()/simWorld.getScale()].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()+1][e.getY()/simWorld.getScale()+1].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()+1][e.getY()/simWorld.getScale()-1].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()-1][e.getY()/simWorld.getScale()+1].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()-1][e.getY()/simWorld.getScale()-1].setAlive(true);
			
			simWorld.getWorld()[e.getX()/simWorld.getScale()][e.getY()/simWorld.getScale()+1].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()+1][e.getY()/simWorld.getScale()].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()-1][e.getY()/simWorld.getScale()].setAlive(true);
			simWorld.getWorld()[e.getX()/simWorld.getScale()][e.getY()/simWorld.getScale()-1].setAlive(true);
		}
		//System.out.println(e.getX());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.printf("%d %d\n",e.getX()/simWorld.getScale(),e.getY()/simWorld.getScale());
	}
	
}
