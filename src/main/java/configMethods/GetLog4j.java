package configMethods;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class GetLog4j {
	public static Logger logs=Logger.getLogger(GetLog4j.class.getName());
	public static Logger getLog() {
	String conf="D:\\project\\TesttingFrameworks\\Army\\src\\main\\resources\\log4jFiles\\log4j.properties";
	PropertyConfigurator.configure(conf);
	return logs;
	}
}
