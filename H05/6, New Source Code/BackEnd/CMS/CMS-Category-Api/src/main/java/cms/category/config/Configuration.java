package cms.category.config;

public class Configuration {

	private static Configuration instance = null;

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	SetupConfig config = SetupConfig.getInstance();

	public static String PATHLOG4J;
	public static String LOG4JFILENAME;

	private Configuration() {
		PATHLOG4J = config.getString("log4j", "fileconfig");
		LOG4JFILENAME = config.getString("log4j", "filename");
	}

}
