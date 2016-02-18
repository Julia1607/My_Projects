package cmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import ds.DSFactory;
import view.GPanel;

public class GCommand 
{
	public ActionSave  aSave  = new ActionSave();
	public ActionLoad  aLoad  = new ActionLoad();
	public ActionExit  aExit  = new ActionExit();
	public ActionShape aShape = new ActionShape();

	public XData xd = new XData();
	public GPanel pp = null;

	class ActionSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				JFileChooser chooser=new JFileChooser();
				int res = chooser.showSaveDialog(null);
				if (res == JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();
					DSFactory.getI(file).save( pp.getData() );
					
				}
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	class ActionLoad implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				JFileChooser chooser=new JFileChooser();
				int res = chooser.showOpenDialog(null);
				if (res == JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();
					ArrayList<XData> dd = DSFactory.getI(file).load();
					pp.setData(dd);
					pp.repaint();
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	class ActionExit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}

	class ActionShape implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getActionCommand().equals("Fossy")) xd.shape=1;
			else if (e.getActionCommand().equals("Rectangle")) xd.shape=2;
			else if (e.getActionCommand().equals("Oval")) xd.shape=3;
			else if (e.getActionCommand().equals("Round Rect")) xd.shape=4;
			else if (e.getActionCommand().equals("Line")) xd.shape=5;

		}
	}
}
