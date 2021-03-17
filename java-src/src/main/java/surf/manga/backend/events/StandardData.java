package surf.manga.backend.events;

import com.corundumstudio.socketio.protocol.Packet;

public class StandardData extends Packet {

	private String string;
	
	public StandardData(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
}