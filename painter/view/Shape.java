package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import cmd.XData;

public class Shape extends JPanel implements MouseListener, MouseMotionListener, FocusListener
{
	XData xd=null;
	private int shape=0;
	Color col=null;
	Color tmp=null;
	Point p=null;
	Point curPos = null;
	int tMove = 0;
	Dimension d=null;
	public Shape()
	{
		init();
	}
	
	public Shape(int shape,Point p1) 
	{
		this.shape=shape;
		p=p1;
		this.col=col;
		setLocation(p1);
		init();
	}
	
	public void init()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		addFocusListener(this);
	}
		
	@Override
	public void paint(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(col);
		switch (shape)
		{ 
		case 2:{ g2.drawRect(2, 2, getWidth()-5, getHeight()-5); 
		
		break;}
		case 3:{ g2.drawOval(2, 2, getWidth()-5, getHeight()-5); 
	
		break;}
		case 4: {g2.drawRoundRect(2, 2, getWidth()-5, getHeight()-5, 20, 20);

		break;}
		case 5:{ g2.drawLine(2, 2, getWidth()-2, getHeight()-2);
	
		}
	}
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		Point tmp = e.getPoint();
		int dx = tmp.x - curPos.x;
		int dy = tmp.y - curPos.y;

		Point p = getLocation();
		Dimension d = getSize();
		if(tMove == 0)
		{
			p.translate(dx, dy);
			setLocation(p);
		}
		else if(tMove == 1)
		{
			d.width = d.width + dx;
			curPos.x = curPos.x + dx;
			setSize(d);
		}
		else if(tMove == 2)
		{
			d.height = d.height+ dy;
			curPos.y = curPos.y + dy;
			setSize(d);
		}
		else if(tMove == 3)
		{
			d.width = d.width + dx;
			d.height = d.height+ dy;
			curPos = tmp;
			setSize(d);
		}
		else if (tMove == 4)
		{
			d.width=d.width-dx;
			setSize(d);
			p.x=p.x+dx;
			setLocation(p);
		}
		else if (tMove == 5)
		{
			d.height=d.height-dy;
			setSize(d);
			p.y=p.y+dy;
			setLocation(p);
		}
			
		else if(tMove == 6)
		{
			p.translate(dx, dy);
			setLocation(p);
			d.width = d.width - dx;
			d.height = d.height - dy;
			setSize(d);
		}
		
		getParent().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) 
	{}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		curPos = e.getPoint();
		if(curPos.x > getWidth()-20)
		{
			tMove = 1;
		}
		if(curPos.y > getHeight()-20)
		{
			tMove = 2;
		}
		if(curPos.x > getWidth()-20 && curPos.y > getHeight()-20)
		{
			tMove = 3;
		}
		if(curPos.x < 20)
		{
			tMove = 4;
		}
		if(curPos.y < 20)
		{
			tMove = 5;
		}
		if(curPos.x < 20 && curPos.y < 20)
		{
			tMove = 6;
		}
		
			
		requestFocus();
	}

	@Override
	public void mouseReleased(MouseEvent e){tMove = 0;}

	@Override
	public void focusGained(FocusEvent arg0)
	{
		
		tmp=col;
		col=Color.red;
		getParent().repaint();
		
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		col=tmp;
		getParent().repaint();
	}	
	
	XData getData()
	{
		XData d = new XData();
		d.shape=shape;
		d.x = getX();
		d.y = getY();
		d.w = getWidth();
		d.h = getHeight();
		return d;
	}
	void setData(XData d)
	{
		setBounds(d.x, d.y, d.w, d.h);
		shape=d.shape;
		repaint();
	}
	
		
}
