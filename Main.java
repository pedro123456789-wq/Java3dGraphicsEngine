import javax.swing.JFrame;


//TODO:
//-> Fix bubble sort for edge creation
//-> Carry on with video 13 by adding rotation vector 


public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	static JFrame frame = new Main();
	Screen screenObj = new Screen();

	public Main() {
		add(screenObj);
		setSize(Constants.screenSize);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("3D Graphics Engine");
	}

	public static void main(String[] args) {

	}
}
