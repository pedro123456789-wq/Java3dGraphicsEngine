import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ScreenController implements KeyListener{
	private int speed = 5;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			Screen.viewFrom[0] -= this.speed;
		}else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Screen.viewFrom[0] += this.speed;
		}else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Screen.viewFrom[1] -= this.speed;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Screen.viewFrom[1] += this.speed;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
