package tk.pratanumandal.pingme.bean;

public class Message {

	private Client client;
	private String text;
	
	public Message(Client client, String text) {
		super();
		this.client = client;
		this.text = text;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [client=" + client + ", text=" + text + "]";
	}
	
}
