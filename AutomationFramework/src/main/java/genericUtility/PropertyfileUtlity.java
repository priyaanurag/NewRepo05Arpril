package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class PropertyfileUtlity {
	
	/**
	 * @return 
	 * @throws IOException 
	 * 
	 */
	
	
	public String toreaddatafromproperyfile(String key) throws IOException
	
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\common.data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
		
	}

}
