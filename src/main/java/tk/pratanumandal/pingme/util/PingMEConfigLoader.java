package tk.pratanumandal.pingme.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import tk.pratanumandal.pingme.bean.PingMEConfig;

public class PingMEConfigLoader {
	
	public static PingMEConfig load(File file) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(PingMEConfig.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (PingMEConfig) jaxbUnmarshaller.unmarshal(file);
	}
	
}
