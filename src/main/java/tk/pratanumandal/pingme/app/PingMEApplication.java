package tk.pratanumandal.pingme.app;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import tk.pratanumandal.pingme.util.PingMEConstants;

@SpringBootApplication
@ComponentScan(basePackages={"tk.pratanumandal.pingme"})
public class PingMEApplication {

	public static void main(String[] args) {
		if (args.length > 0) {
			PingMEConstants.CONFIG_FILE = new File(args[0]).getAbsolutePath();
		}
		
		SpringApplication.run(PingMEApplication.class);
	}
	
	@Bean
	public Logger getLogger() {
		return LoggerFactory.getLogger(PingMEApplication.class);
	}

}
