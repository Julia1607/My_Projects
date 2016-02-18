package view;


import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cmd.GCommand;

public class GMenu extends JMenuBar 
{
	public GMenu(GCommand cmd) 
	{
		Font font = new Font("Verdana", Font.PLAIN, 11);

		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(font);

		JMenuItem mnuLoad=new JMenuItem("Load");
		mnuLoad.setFont(font);
		mnuLoad.addActionListener(cmd.aLoad);
		fileMenu.add(mnuLoad);
		
		JMenuItem mnuSave=new JMenuItem("Save");
		mnuSave.setFont(font);
		mnuSave.addActionListener(cmd.aSave);
		fileMenu.add(mnuSave);
		
	
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setFont(font);
		exitItem.addActionListener( cmd.aExit );
		fileMenu.add(exitItem);
		
		
		JMenu shapeMenu = new JMenu("Shape");
		shapeMenu.setFont(font);

				
		JMenuItem rect = new JMenuItem("Rectangle");
		rect.setFont(font);
		rect.addActionListener( cmd.aShape);
		shapeMenu.add(rect);
		
		JMenuItem oval = new JMenuItem("Oval");
		oval.setFont(font);
		oval.addActionListener( cmd.aShape);
		shapeMenu.add(oval);
		
		JMenuItem roundrect = new JMenuItem("Round Rect");
		roundrect.setFont(font);
		roundrect.addActionListener( cmd.aShape);
		shapeMenu.add(roundrect);
		
			
		
		add(fileMenu);
		add(shapeMenu);
		
	}
}
