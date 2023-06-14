package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

	private Properties properties;

	public FileReader(String filePath) {
	        properties = new Properties();
	        try (FileInputStream fis = new FileInputStream(filePath)) {
	            properties.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	public String getBaseUrl() {
		return properties.getProperty("baseUrl");
	}
}
