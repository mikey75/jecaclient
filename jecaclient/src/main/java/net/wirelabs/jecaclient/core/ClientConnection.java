package net.wirelabs.jecaclient.core;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import net.wirelabs.jecaclient.gui.swing.Application;

public class ClientConnection {
	

	
	private InetAddress address;
	private Socket socket;
	
	public ClientConnection(Ecasound el) {
		
		
		boolean socketready = false;
		
		/*
		 * if this eca instance has spawn_local property and the local server 
		 * is not already spawned -> spawn local server first
		 */
		if (el.spawnServer() && !el.isSpawned()) {
			
			spawnLocalServer(el);
			
		}
		
		/*
		 * connect (retry 5 times) 
		 */
		for (int retries = 0; retries < 5; retries++) {
		
		
			try {
				Application.getLogger().debug("Trying connection: " + el.getInstanceName() + " " + el.getServer_host() +":" +el.getServer_port());
			
				address = InetAddress.getByName(el.getServer_host());
				socket = new Socket(address, el.getServer_port());
				socket.setKeepAlive(true);
				socketready = true;
				break;
				
			} catch (IOException e) {
				Utils.sleepmili(100);	// sleep for 100 ms and retry until none retries left
				
			} 
		
		
		}
		
		if (!socketready) {
			
			Utils.ErrorMsg("Connection failed: socket was not ready. Session will be defunct. Check logfile" );
		}
		
	}




	private void spawnLocalServer(Ecasound el) {
		
		
		String path = Application.getConf().getPath();
		int port = el.getServer_port();
		
		
		ProcessBuilder processbuilder = new ProcessBuilder(path ,"-c","--server","--server-tcp-port=" + port); 
		
		try {
			File logfile  = new File(Application.getConf().getLogfile());
			processbuilder.redirectOutput(logfile);
			processbuilder.redirectErrorStream(true);
		} catch (NullPointerException e) {
			Application.getLogger().debug("ecasound log file creation failed");
		}
		
		Application.getLogger().debug("Spawning ecasound process: " +  processbuilder.command());
		
		try {

			 processbuilder.start();
			 
		} catch (IOException e) {
			Application.getLogger().error("Ecasound was not started!");	
		}
	}



	
	public void close() {
		try {
			
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			Application.getLogger().debug("Error closing connection!!");
		}
	}

	public InetAddress getAddress() {
		return address;
	}


	public Socket getSocket() {
		return socket;
	}


}
