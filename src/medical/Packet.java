package medical;

import java.io.Serializable;

public class Packet implements Serializable {
	private int id;
	private String message;	

	public Packet(int id,String msg) {
		this.setMessage(msg);
		this.setId(id);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
