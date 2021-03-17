package surf.manga.backend;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

import surf.manga.backend.events.EventName;

public class BackendSocketio {

	private SocketIOServer server;

	// Create and start backend socketio server
	public BackendSocketio(int port) {

		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(port);
		config.setOrigin(null);
		

		server = new SocketIOServer(config);

		// Register events on the socketio server.
		// Maybe I implemented this weird, but I think
		// this is a good way to implement it.
		
		EventName.register(server);
		
		server.addConnectListener(new ConnectListener() {
			
			public void onConnect(SocketIOClient client) {
				System.out.println("CONNECTED");
			}
		});

		server.start();

	}


	public void broadcast(EventName name, Object object) {
		server.getBroadcastOperations().sendEvent(name.toString(), object);
	}

}