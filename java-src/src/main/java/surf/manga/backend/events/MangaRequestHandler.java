package surf.manga.backend.events;

import java.util.HashMap;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;

public class MangaRequestHandler extends DataHandler {

	public MangaRequestHandler() {
		super(EventName.REQUEST_NEW_MANGA);
	}

	private static HashMap<String, Integer> pressed = new HashMap<String, Integer>();
	
	@Override
	public void handleData(SocketIOClient client, Object data, AckRequest ackSender) {
		System.out.println("Client says: " + ((String) data) );
		String thing = client.getHandshakeData().getAddress().getHostName();
		pressed.put(thing, getNewVal(thing));
		StandardData _data;
		
		if (pressed.get(thing).intValue() == 0)
			_data = new StandardData("First packet received! It was hell setting up this demo because of CORs!");
		else
			_data = new StandardData("You have pressed the button " + (pressed.get(thing).intValue()+1) + " times.");
		
		client.sendEvent(getEventName().name(), _data);
		
	}
	
	private Integer getNewVal(String thing) {
		if (pressed.containsKey(thing)) {
			return pressed.get(thing).intValue() + 1;
		}
		return 0;
	}

}