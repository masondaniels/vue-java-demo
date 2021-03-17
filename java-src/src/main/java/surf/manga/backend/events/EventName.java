package surf.manga.backend.events;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public enum EventName {

	
	REQUEST_NEW_MANGA;

	// EventData handles all data for that specific type.
	// Allows for registry of events.
	
	private DataHandler dataHandler;
	
	// You don't have to touch this.
	private void registerEvents(SocketIOServer server) {
		if (dataHandler == null) {
			throw new RuntimeException("DataHanlder is not registered to " + this.toString() + "!");
		}
		server.addEventListener(this.name(), Object.class, new DataListener<Object>() {
			public void onData(SocketIOClient client, Object data, AckRequest ackSender) throws Exception {
				dataHandler.handleData(client, data, ackSender);
			}
		});
	}
	
	public static void register(SocketIOServer server) {
		
		// Register data handler.
		REQUEST_NEW_MANGA.dataHandler = new MangaRequestHandler();
		
		for (int i = 0; i < EventName.values().length; i++) {
			EventName.values()[i].registerEvents(server);
		}
	}
	

}