import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	static JFrame frame = new Main();
	Screen screenObj = new Screen();
	
	public Main() {
		add(screenObj);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3D Graphics Engine");
	}
	
	public static void main(String[] args) {
		
		

	}

}
