
package net.wirelabs.jecaclient.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement(name="session")
@XmlAccessorType (XmlAccessType.FIELD)

public class Ecasound {
	@XmlElement(name="instance_id")
	private String instanceId;
	private String instanceName;
	private int serverPort;
	private String serverHost;
	private boolean spawnServer;
	@XmlTransient
	private boolean spawned;
	@XmlTransient
	private ClientConnection connection;
	
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
		return spawnServer;
	}

	public int getServerPort() {
		return serverPort;
	}

	public String getServerHost() {
		return serverHost;
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

	public String getInstanceId() {
		return instanceId;
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return instanceName;
	}


	
	
	
	
	
}
