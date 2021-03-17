package surf.manga.backend.events;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.protocol.Packet;


public abstract class DataHandler {

	private EventName en;
	
	public DataHandler(EventName en) {
		this.en = en;
	}
	
	public EventName getEventName() {
		return en;
	}
	
	public abstract void handleData(SocketIOClient client, Object data, AckRequest ackSender);
	
}