package cms.category.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.ini4j.Wini;

public class SetupConfig {
	private static SetupConfig instance = null;

	public static SetupConfig getInstance() {
		if (instance == null) {
			instance = new SetupConfig();
		}
		return instance;
	}

	private static String OS = System.getProperty("os.name").toLowerCase();
	//TODO: config 
	public static boolean isWindows() throws IOException {
		return (OS.indexOf("win") >= 0);
	}

	private Wini getConfig() {
		Wini ini = new Wini();
		try {
			if (isWindows()) {
				Path filePath = Paths.get(System.getProperty("user.dir").toString(), "config.ini");
				ini.load(new File(filePath.toString()));
				return ini;
			} else {
				Path filePath = Paths.get(System.getProperty("user.dir").toString(), "config.ini");
				ini.load(new File(filePath.toString()));
				return ini;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ini;
	}

	public static Integer getInteger(String section, String option) {
		try {
			return SetupConfig.getInstance().getConfig().get(section, option, Integer.class);
		} catch (Exception e) {
			return -1;
		}
	}

	public static String getString(String section, String option) {
		try {
			return SetupConfig.getInstance().getConfig().get(section, option, String.class);
		} catch (Exception e) {
			return "";
		}
	}

	public static Long getLong(String section, String option) {
		try {
			return SetupConfig.getInstance().getConfig().get(section, option, Long.class);
		} catch (Exception e) {
			return -1L;
		}
	}

}
