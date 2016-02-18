package view;
//package Ball_class;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import cmd.GCommand;
import cmd.XData;



public class GPanel extends JPanel implements MouseListener, MouseMotionListener
{
	XData xd = null;
	int x=0, x2=0;
	int y=0, y2=0;
	boolean flag = false;
	Shape sh=null;
	public GPanel(GCommand cmd) 
	{
		this.xd = cmd.xd;
		cmd.pp = this;

				
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);

		JButton btnR=new JButton("Rectangle");
		btnR.addActionListener(cmd.aShape);

		JButton btnO=new JButton("Oval");
		btnO.addActionListener(cmd.aShape);

		JButton btnRR=new JButton("Round Rect");
		btnRR.addActionListener(cmd.aShape);

		JPanel pbtn=new JPanel();
		pbtn.setSize(100, 280);
		pbtn.setLocation(550, 0);
		add(pbtn);
		pbtn.add(btnR);
		pbtn.add(btnO);
		pbtn.add(btnRR);
	
	}


	@Override
	public void mousePressed(MouseEvent e) 
	{
		
		flag = true;
		sh=new Shape(xd.shape,e.getPoint());
		add(sh);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			flag=false;
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		Point p1 = sh.getLocation();
		Point p2 = e.getPoint();
		int w = p2.x - p1.x;
		int h = p2.y - p1.y;
		sh.setSize(w, h);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
	public ArrayList<XData> getData()
	{
		ArrayList<XData> pp = new ArrayList<XData>();
		for(Component c : getComponents())
		{
			if (c instanceof Shape)
			{
				Shape sh = (Shape) c;
				pp.add(sh.getData());
			}
		}
		return pp;
	}
	
	public void setData(ArrayList<XData> pp)
	{
		for (XData x : pp) 
		{
			Shape sh = new Shape();
			sh.setData(x);
			add(sh);
		}
	}
	
	
}