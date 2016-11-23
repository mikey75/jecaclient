package net.wirelabs.jecaclient.core;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import net.wirelabs.jecaclient.gui.swing.MainWindow;

public class ClientConnection {
	

	
	private InetAddress address;
	private Socket socket;
	
	
	

	public ClientConnection(Ecasound el) {
		/*
		 * if spawn_local -> spawn local server and connect to it
		 */
		if (el.spawnServer() && !el.isSpawned()) {
			
			if (!spawn_local_server(el)) {
				System.exit(1);
			}
			
			Utils.sleep(2);
			el.setSpawned(true);
		}
		
		/*
		 * otherwise just connect to existing server
		 */
		try {
			System.out.println("Opening connection: " + el.getInstanceName() + " " + el.getServer_host() +":" +el.getServer_port());
			address = InetAddress.getByName(el.getServer_host());
			socket = new Socket(address, el.getServer_port());
			socket.setKeepAlive(true);
			
		} catch (IOException e) {
			System.out.println("Client connection failed");
		} 
		
	}

	public Socket getSocket() {
		return socket;
	}

	
	public void close() {
		try {
			
			if (socket != null) {
			socket.close();
			}
		} catch (IOException e) {
			System.out.println("Error closing connection!!");
		}
	}
	
	public boolean spawn_local_server(Ecasound el) {
		
		ProcessBuilder processbuilder = new ProcessBuilder(MainWindow.ecasoundbinary,"-c","--server","--server-tcp-port=" + el.getServer_port()); 
		processbuilder.redirectErrorStream(true);
		//processbuilder.redirectOutput(new File(el.getLogfile()));
	//	
		System.out.println("Spawning ecasound process: " + MainWindow.ecasoundbinary);

		try {
	
			Process process = processbuilder.start();
			
			return true;

		} catch (IOException e) {
			System.out.println("Ecasound was not started!");
			return false;
		}
	}
}
