
package net.wirelabs.jecaclient.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement(name="session")
@XmlAccessorType (XmlAccessType.FIELD)

public class Ecasound {
	
	
	private String instanceName;
	private int server_port;
	private String server_host;
	private boolean spawn_server;
	@XmlTransient
	private boolean spawned;
	@XmlTransient
	private ClientConnection connection;
	
	public Ecasound(){
		
	}
		
	public Ecasound(String name, String host, int port, boolean spawn)  {
		
		this.instanceName = name;
		this.server_host = host;
		this.server_port = port;
		this.spawn_server = spawn;
		
	}	
	
	/*public ClientConnection getConnection() {
		
		return connection;
	}*/
	
	public boolean command(String cmd) {
		
		if (connection == null ) {
			connection = new ClientConnection(this);
		}
		
		return EcaCommand.send(connection, cmd);
	}
	
	public String response() {
		return EcaCommand.output.toString();
	}

	public boolean spawnServer() {
		return spawn_server;
	}

	public int getServer_port() {
		return server_port;
	}

	public String getServer_host() {
		return server_host;
	}

	

	public String getInstanceName() {
		return instanceName;
	}

	public boolean isSpawned() {
		return spawned;
	}

	public void setSpawned(boolean spawned) {
		this.spawned = spawned;
	}
	
	
	



	
	
	
	
	
}
