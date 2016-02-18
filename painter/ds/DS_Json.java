package ds;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cmd.XData;



public class DS_Json implements DS 
{
	File file = null;

	public DS_Json(File file) 
	{
		this.file = file;
	}

	@Override
	public void save(ArrayList<XData> d) throws IOException
	{				
		FileWriter fw = new FileWriter(file);
		Gson gs = new Gson();
		String str = gs.toJson(d);
		fw.write( str );
		fw.flush();
		fw.close();
	}

	@Override
	public ArrayList<XData> load() throws IOException
	{	
		ArrayList<XData> ret = null;

		Scanner sc = new Scanner(file);
		String str = sc.nextLine();
		Gson gs = new Gson();
		ret = gs.fromJson(str, new TypeToken<ArrayList<XData>>(){}.getType() );

		return ret;
	}
}


