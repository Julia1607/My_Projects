package ds;

import java.io.IOException;
import java.util.ArrayList;

import cmd.XData;

public interface DS 
{
	void save(ArrayList<XData> d) throws IOException;
	ArrayList<XData> load() throws IOException;
}
