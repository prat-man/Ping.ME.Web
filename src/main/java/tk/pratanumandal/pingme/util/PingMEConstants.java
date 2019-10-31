package tk.pratanumandal.pingme.util;

import java.io.File;
import java.util.List;

import tk.pratanumandal.pingme.bean.PingMEConfig.Credentials.Credential;

public class PingMEConstants {
	
	public static String CONFIG_FILE = getDefaultConfigLocation();
	
	public static List<Credential> CREDENTIALS = null;
	
	public static int PORT = 8080;
	
	public static boolean VERBOSE = false;
	
	
	private static String getDefaultConfigLocation() {
		return new File("config.xml").getAbsolutePath();
	}
	
}
