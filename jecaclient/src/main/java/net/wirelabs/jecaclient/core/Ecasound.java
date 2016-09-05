package net.wirelabs.jecaclient.core;

public class Ecasound {
	
	
	private boolean spawn_server;
	private int server_port;
	private String server_host;
	private String path;
	private String logfile;	
 	private String instanceName;
	public boolean spawned = false;
	private ClientConnection connection;
		
	public Ecasound(String name, String host, int port, String path, String logfile, boolean spawn)  {
		
		this.instanceName = name;
		this.server_host = host;
		this.server_port = port;
		this.logfile = logfile;
		this.path = path;
		this.spawn_server = spawn;
		
	}	
	
	public ClientConnection getConnection() {
		if (connection == null || connection.getSocket() == null) {
			connection = new ClientConnection(this);
		}
		return connection;
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

	public String getPath() {
		return path;
	}

	public String getLogfile() {
		return logfile;
	}

	public String getInstanceName() {
		return instanceName;
	}
	
	
	



	
	
	
	
	
}
