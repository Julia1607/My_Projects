package Ball;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

public class Ball
{
	int x = 0;
	int y = 0;
	int dx = 5;
	int dy = 3;
	int w = 40;
	int h = 40;
	Color col = Color.red;
	
	JPanel pp = null;
	
	public Ball(JPanel pp, Point p) 
	{
		this.pp = pp;
		x = p.x;
		y = p.y;
	}
	
	public void move()
	{
		Point p = new Point(x, y);
		if(p.x <=0 || p.x+40 >= pp.getWidth() )
		{
			dx = -dx;
		}
		if(p.y <=0 || p.y+40 >= pp.getHeight() )
		{
			dy = -dy;
		}
		p.translate(dx, dy);
		x = p.x;
		y = p.y;
	}
	
	public boolean checkIn(Point p) 
	{
		boolean ret=false;
		if( p.x >= x && p.x <= x+w && p.y >= y && p.y <= y+h)
		{
			ret = true;
		}
		return ret;
	}
}