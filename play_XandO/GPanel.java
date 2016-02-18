import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GPanel extends JPanel implements MouseListener
{
	JButton btn;
	Graphics2D g=null;
	int x1, x2, x3;
	int y1, y2, y3;
	XandO play=null;
	Random rnd=null;
	public GPanel() 
	{
		addMouseListener(this);
		play=new XandO();
		rnd=new Random();
		btn=new JButton("Begin");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				setUp((Graphics2D) getGraphics());

			}
		}	);
		add(btn);
	}

	public void setUp(Graphics2D g)
	{
		x1=GPanel.this.getWidth()/3;
		x2=2*(GPanel.this.getWidth()/3);
		x3=GPanel.this.getWidth();
		y1=GPanel.this.getHeight()/3;
		y2=2*(GPanel.this.getHeight()/3);
		y3=GPanel.this.getHeight();
		g.drawLine(x1, 0, x1, y3);
		g.drawLine(x2, 0, x2, y3);
		g.drawLine(0, y1, x3, y1);
		g.drawLine(0, y2, x3, y2);

	}

	public int chosenQuater(int x, int y)
	{
		int q=-1;
		if ( x<x1 && y<y1) q=0;
		else if ( x>x1 && x<x2 && y<y1) q=1;
		else if (x>x2 && y<y1) q=2;
		else if (x<x1 && y>y1 && y<y2) q=3;
		else if (x>x1 && x<x2 && y>y1 && y<y2) q=4;
		else if (x>x2 && y>y1 && y<y2) q=5;
		else if (x<x1 && y>y2) q=6;
		else if (x>x1 && x<x2 && y>y2) q=7;
		else if (x>x2 && y>y2) q=8;
		return q;
	}

	public void drawX(Graphics2D g, int quater)
	{
		switch (quater)
		{
		case 0: {
			g.drawLine(x1/3, y1/3, 2*x1/3, 2*y1/3);
			g.drawLine(2*x1/3, y1/3, x1/3, 2*y1/3);	
			break;
		} 
		case 1: {
			g.drawLine((x2-2*x1/3), y1/3, (x2-x1/3), 2*y1/3);
			g.drawLine((x2-2*x1/3), 2*y1/3, (x2-x1/3), y1/3);
			break;
		}
		case 2: {
			g.drawLine((x2+2*x1/3), y1/3, (x2+x1/3), 2*y1/3);
			g.drawLine((x2+2*x1/3), 2*y1/3, (x2+x1/3), y1/3);
			break;
		}
		case 3: {
			g.drawLine(x1/3, y1+y1/3, 2*x1/3, y1+2*y1/3);
			g.drawLine(2*x1/3, y1+y1/3, x1/3, y1+2*y1/3);
			break;
		}
		case 4: {
			g.drawLine((x1+x1/3), y1+y1/3, (x1+2*x1/3), y1+2*y1/3);
			g.drawLine((x1+x1/3), y1+2*y1/3, (x1+2*x1/3),y1+y1/3);
			break;
		}
		case 5: {
			g.drawLine((x2+x1/3), y1+y1/3, (x2+2*x1/3), y1+2*y1/3);
			g.drawLine((x2+x1/3), y1+2*y1/3, (x2+2*x1/3),y1+ y1/3);
			break;
		}
		case 6: {
			g.drawLine(x1/3, y2+y1/3, 2*x1/3, y2+2*y1/3);
			g.drawLine(x1/3, y2+2*y1/3, 2*x1/3,y2+y1/3);
			break;
		}
		case 7: {
			g.drawLine((x1+x1/3), y2+y1/3, (x1+2*x1/3), y2+2*y1/3);
			g.drawLine((x1+x1/3), y2+2*y1/3, (x1+2*x1/3), y2+y1/3);
			break;
		}
		case 8: {
			g.drawLine((x2+x1/3), y2+y1/3, (x2+2*x1/3), y2+2*y1/3);
			g.drawLine((x2+x1/3), y2+2*y1/3, (x2+2*x1/3),y2+y1/3);
			break;
		}
		}
	}

	public void drawO(Graphics2D g, int quater)
	{
		switch (quater)
		{
		case 0: {
			g.drawOval(x1/3, y1/3, 60, 60);
			break;
		} 
		case 1: {
			g.drawOval(x1+x1/3, y1-2*y1/3, 60, 60);
			break;
		}
		case 2: {
			g.drawOval(x2+x1/3, y1-2*y1/3, 60, 60);
			break;
		}
		case 3: {
			g.drawOval(x1/3, y1+y1/3, 60, 60);
			break;
		}
		case 4: {
			g.drawOval(x1+x1/3, y1+y1/3, 60, 60);
			break;
		}
		case 5: {
			g.drawOval(x2+x1/3, y2-2*y1/3, 60, 60);
			break;
		}
		case 6: {
			g.drawOval(x1/3, y2+y1/3, 60, 60);
			break;
		}
		case 7: {
			g.drawOval(x1+x1/3, y2+y1/3, 60, 60);
			break;
		}
		case 8: {
			g.drawOval(x2+x1/3, y2+y1/3, 60, 60);
			break;
		}
		}
}
	@Override
	public void mousePressed(MouseEvent e)
	{
		int x=e.getX();
		int y=e.getY();
		int i=chosenQuater(x,y);
		g=(Graphics2D) getGraphics();

		if (play.get(i)==4)
		{
			drawX(g,i);
			play.set(i, 1);
			play.checkOfWinner();
			if (!play.winnerExist())
			{
				boolean fl=true;
				while (fl)
				{
					int r=rnd.nextInt(8);
					if (play.get(r)==4)
					{
						drawO(g,r);
						play.set(r, 0);
						play.checkOfWinner();
						fl=false;
						break;
					}
				}	
			}
		}	
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}