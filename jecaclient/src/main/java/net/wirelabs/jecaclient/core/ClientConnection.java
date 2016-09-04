package net.wirelabs.jecaclient.core;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientConnection {
	

	
	private InetAddress address;
	private Socket socket;
	
	
	public ClientConnection(String host, int port)  {
	
		System.out.println("Connecting: " + host +" :" + port);
		try {
			address = InetAddress.getByName(host);
			setSocket(new Socket(address, port));
		} catch (IOException e) {
			System.out.println("Client connection failed");
		} 
		
	
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket connection) {
		this.socket = connection;
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
}
