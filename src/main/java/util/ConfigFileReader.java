package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigFileReader {
	
	public Map<String,String> getPropertiesFileContents()
	{
		Properties prop = new Properties();
		Map<String,String> propFileMap = new HashMap<String,String>();
		InputStream is = null;
		try
		{
			is = new FileInputStream("//Users//rashmikanduluvavikraman//selenium-workspace//AutomationProject1//src//main//java//config//config.properties");
			prop.load(is);
			for(Object s: prop.keySet())
			{
				String key = (String)s;
				//System.out.println(key+ " " + prop.getProperty(key));
				propFileMap.put(key,prop.getProperty(key));
			}
		}
		catch(FileNotFoundException fx)
		{
			fx.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				is.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		//System.out.println(propFileMap);
		return propFileMap;
	}
	
	//To test
	/*
	public static void main(String[] args)
	{
		ConfigFileReader pfh = new ConfigFileReader();
		Map<String,String> m=pfh.getPropertiesFileContents();
		System.out.println(m);
	}
	*/
}
