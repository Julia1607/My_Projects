package ds;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import cmd.XData;

public class DS_Csv implements DS 
{

	File file = null;

	public DS_Csv(File file) 
	{
		this.file = file;
	}

	@Override
	public void save(ArrayList<XData> d) throws IOException
	{
		CSVWriter writer = new CSVWriter(new FileWriter(file));

		for (XData xd : d) 
		{
			String[] str =(xd.getShape()+";"+xd.getX()+";"+xd.getY()+";"+xd.getW()+";"+xd.getH()).split(";");
			writer.writeNext(str);
		}
		writer.close();
	}


	@Override
	public ArrayList<XData> load() throws IOException
	{
		ArrayList<XData> ret = new ArrayList<XData>();

		CSVReader reader = new CSVReader(new FileReader(file));
		String[] line =null;
		while ((line=reader.readNext())!=null)
		{
			XData xd = new XData();
			xd.setShape(Integer.parseInt(line[0]));
			xd.setX(Integer.parseInt(line[1]));
			xd.setY(Integer.parseInt(line[2]));
			xd.setW(Integer.parseInt(line[3]));
			xd.setH(Integer.parseInt(line[4]));
			ret.add(xd);
		}	
		reader.close();

		return ret;
	}
}
