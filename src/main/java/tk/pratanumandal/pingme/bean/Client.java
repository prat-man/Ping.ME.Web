package tk.pratanumandal.pingme.bean;

import java.awt.Color;

public class Client {

	private String username;
	private String IPAddress;
	private Color color;
	
	public Client(String username, String iPAddress) {
		this(username, iPAddress, null);
	}
	
	public Client(String username, String iPAddress, Color color) {
		super();
		this.username = username;
		IPAddress = iPAddress;
		this.color = color;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getIPAddress() {
		return IPAddress;
	}
	
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IPAddress == null) ? 0 : IPAddress.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (IPAddress == null) {
			if (other.IPAddress != null)
				return false;
		} else if (!IPAddress.equals(other.IPAddress))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [username=" + username + ", IPAddress=" + IPAddress + ", color=" + color + "]";
	}
	
}
