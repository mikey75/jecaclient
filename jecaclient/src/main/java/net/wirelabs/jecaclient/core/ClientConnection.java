package net.wirelabs.jecaclient.core;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import net.wirelabs.jecaclient.gui.swing.MainWindow;

public class ClientConnection {
	

	
	private InetAddress address;
	private Socket socket;
	
	
	

	public ClientConnection(Ecasound el) {
		/*
		 * if this eca instance is spawn_local -> spawn local server and connect to it
		 */
		if (el.spawnServer() && !el.isSpawned()) {
			
			if (!spawn_local_server(el)) {
				System.exit(1);
			}
			
		}
		
		/*
		 * otherwise just connect to instance-declared server
		 */
		try {
			
			System.out.println("Opening connection: " + el.getInstanceName() + " " + el.getServer_host() +":" +el.getServer_port());
			address = InetAddress.getByName(el.getServer_host());
			socket = new Socket(address, el.getServer_port());
			socket.setKeepAlive(true);
			
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
		
		ProcessBuilder processbuilder = new ProcessBuilder(MainWindow.getConf().getPath(),"-c","--server","--server-tcp-port=" + el.getServer_port()); 
		processbuilder.redirectErrorStream(true);
		processbuilder.redirectOutput(new File(MainWindow.getConf().getLogfile()));
		
		System.out.println("Spawning ecasound process: " + MainWindow.getConf().getPath());

		try {
	
			Process p = processbuilder.start();
			
			// wait for process to spawn
			while (!p.isAlive()) {};
			el.setSpawned(true);
			// no way to check if server is ready TODO:
			Utils.sleep(2);
			
		
			return true;
			
			

		} catch (IOException e) {
			System.out.println("Ecasound was not started!");
			return false;
		}
	}
}
