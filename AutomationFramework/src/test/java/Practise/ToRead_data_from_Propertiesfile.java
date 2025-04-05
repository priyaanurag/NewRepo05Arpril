package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ToRead_data_from_Propertiesfile {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\common.data.properties");
	   Properties prop=new Properties();
	

//		String URL = pop.getProperty("url");
//		String USERNAME = pop.getProperty("username");
//		String PASSWORD = pop.getProperty("password");
//		String BROWSER = pop.getProperty("browser");

//		System.out.println(URL);
//		System.out.println(USERNAME);
//		System.out.println(PASSWORD);
//		System.out.println(BROWSER);
	}

}
