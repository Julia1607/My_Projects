package Ball;
import javax.swing.JFrame;

public class GFrame extends JFrame 
{
	public GFrame() 
	{
		setTitle("My First GUI APP");
		setBounds(200, 200, 500, 400);
	
		add(new GPanel());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}