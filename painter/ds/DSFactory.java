package ds;

import java.io.File;

public class DSFactory 
{
	public static DS getI(File file)
	{
		DS ds = null;
		String str = file.getName();
		String ext = str.substring(str.lastIndexOf(".")+1).toLowerCase();
		switch (ext)
		{
			case "json": ds = new DS_Json(file); break;
			case "csv":  ds = new DS_Csv(file);  break;
			case "xml":  ds = new DS_Xml(file);  break;
			default: throw new IllegalArgumentException();
		}
		return ds;
	}
}
