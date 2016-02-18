package view;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import cmd.GCommand;

public class GFrame extends JFrame
{
	public GFrame() 
	{
		setTitle("My First GUI APP");
		setBounds(100, 50, 700, 500);

		GCommand cmd = new GCommand();
		GPanel p = new GPanel(cmd);
		add(p);


		setJMenuBar( new GMenu(cmd));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
