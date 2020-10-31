package cms.permisstion.application.log;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.log4j.PropertyConfigurator;

import cms.permisstion.config.Configuration;

public class SystemLogging {
	
	private static SystemLogging instance = null;

	public static SystemLogging getInstance() {
		if (instance == null) {
			instance = new SystemLogging();
		}
		return instance;
	}

	
	public SystemLogging() {
		Configuration config = Configuration.getInstance();
		System.out.println(config.PATHLOG4J);
		Path filePath = Paths.get(System.getProperty("user.dir").toString(), config.PATHLOG4J);
		Path filePathLog = Paths.get(System.getProperty("user.dir").toString(), config.LOG4JFILENAME);
		System.out.println(filePath);
		PropertyConfigurator.configure(filePath.toString());
	}
	
//	public static Logger logger =  Logger.getLogger(SystemLogging.class);
	
	

}
