package ds;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import cmd.XData;

public class DS_Xml implements DS 
{
	File file = null;

	public DS_Xml(File file) 
	{
		this.file = file;
	}

	@Override
	public void save(ArrayList<XData> d) throws IOException
	{
		XMLEncoder ee = new XMLEncoder(new FileOutputStream(file));
		ee.writeObject(d);
		ee.flush();
		ee.close();
	}

	@Override
	public ArrayList<XData> load() throws IOException
	{
		ArrayList<XData> ret = null;

		XMLDecoder de = new XMLDecoder(new FileInputStream(file));
		ret = (ArrayList<XData>) de.readObject();
		de.close();

		return ret;
	}
}
