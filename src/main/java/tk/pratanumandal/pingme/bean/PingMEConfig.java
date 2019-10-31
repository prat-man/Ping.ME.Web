package tk.pratanumandal.pingme.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pingme-config")
@XmlAccessorType(XmlAccessType.FIELD)
public class PingMEConfig {
	
	private int port;
	
	private Credentials credentials;
	
	private String verbose;
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public String getVerbose() {
		return verbose;
	}

	public void setVerbose(String verbose) {
		this.verbose = verbose;
	}

	@XmlRootElement(name="credentials")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Credentials {
		
		@XmlElement(name="credential")
		private List<Credential> credentialList;

		public List<Credential> getCredentialList() {
			return credentialList;
		}

		public void setCredentialList(List<Credential> credentialList) {
			this.credentialList = credentialList;
		}
		
		@XmlRootElement(name="credential")
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Credential {
			
			private String username;
			
			private String password;

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}
			
		}
		
	}

}
