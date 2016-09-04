package net.wirelabs.jecaclient.core;

import java.io.File;
import java.io.IOException;

public class Ecasound {
	
	// defaults
	private static String DEFAULT_PATH ="/usr/bin/ecasound";
	private String logfile = "ecasound-daemon.log";	
	private int port;
	private String host;
	
	private Process process; 
	
	
	public Ecasound(int port) {
		this.host = "localhost";
		this.port = port;
	}
	
	public Ecasound(String host, int port)  {
		this.port = port;
		this.host = host;		
	}

	
	public boolean spawn_local_server() {
		
		
		
		ProcessBuilder processbuilder = new ProcessBuilder(DEFAULT_PATH,"-c","--server","--server-tcp-port="+this.port); 
		processbuilder.redirectErrorStream(true);
		processbuilder.redirectOutput(new File(logfile));
		
		
		try {
			System.out.println("Spawning ecasound process");
			process = processbuilder.start();
			return true;
	
		} catch (IOException e) {
			System.out.println("Ecasound was not started!");
			return false;
		}
	}
	
	
	public Process getProcess() {
		return process;
	}

	public int getPort() {
		return port;
	}

	public String getHost() {
		return host;
	}

	
	
	
	
}
