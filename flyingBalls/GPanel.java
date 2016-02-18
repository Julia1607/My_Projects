package Ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GPanel extends JPanel implements MouseListener
{
	JTextField txt = null;	
	ArrayList<Ball> bb = null;
	
	public GPanel() 
	{
		setLayout(null);
		txt = new JTextField();
		txt.setBounds(10, 10, 100, 20);
		add(txt);
		bb = new ArrayList<Ball>();
		addMouseListener(this);
		Timer tm = new Timer(50, new MoveAction());
		tm.start();
	}
	
	class MoveAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			txt.setText("Total count: " + bb.size());
			repaint();
		}	
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		Random rr = new Random();

		for( Ball b : bb)
		{
			b.move();
			g2.setColor(new Color(rr.nextInt(255), rr.nextInt(255), rr.nextInt(255)));
			g2.fillOval(b.x, b.y, b.w, b.h);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{		
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			for (Ball b : bb) 
			{
				if( b.checkIn(e.getPoint()) == true)
				{
					bb.remove(b);
					break;
				}
			}
		}
		else
		{
			Ball b = new Ball(this, e.getPoint()); 
			bb.add( b );
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}