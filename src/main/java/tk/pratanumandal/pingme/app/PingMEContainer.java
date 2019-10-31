package tk.pratanumandal.pingme.app;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

import tk.pratanumandal.pingme.bean.PingMEConfig;
import tk.pratanumandal.pingme.util.PingMEConstants;
import tk.pratanumandal.pingme.util.PingMEConfigLoader;

@Component
public class PingMEContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Autowired
	private Logger logger;
	
	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		
		File file = new File(PingMEConstants.CONFIG_FILE);
		
		if (file.exists()) {
			PingMEConfig config;
			try {
				config = PingMEConfigLoader.load(file);
				
				if (config.getPort() > 0) {
					PingMEConstants.PORT = config.getPort();
				}
				factory.setPort(PingMEConstants.PORT);
				
				if (config.getCredentials() != null) {
					PingMEConstants.CREDENTIALS = config.getCredentials().getCredentialList();
				}
				
				if (config.getVerbose() != null) {
					if (config.getVerbose().equalsIgnoreCase("true")) {
						PingMEConstants.VERBOSE = true;
					}
					else if (config.getVerbose().equalsIgnoreCase("false")) {
						PingMEConstants.VERBOSE = false;
					}
					else {
						throw new InvalidParameterException("Element 'verbose' can only be 'true' or 'false'. Unrecognized value: " + config.getVerbose());
					}
				}
				
				logger.info("Configuration file loaded");
			} catch (JAXBException | InvalidParameterException e) {
				logger.error("An error occurred when trying to load configuration file");
				e.printStackTrace();
			}
		}
		else {
			logger.warn("Configuration file not found");
		}
		
	}

}
