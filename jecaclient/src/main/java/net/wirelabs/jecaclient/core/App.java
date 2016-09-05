package net.wirelabs.jecaclient.core;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class App {

	// defaults 
	private boolean spawn_server = false;
	private int server_port = 2868;
	private String server_host = "localhost";
	
	public static XMLConfiguration config;
	
	public App(){
		
		try
		{
		    config = new XMLConfiguration("jecaclient.xml");
		   
		    // do something with config
		    spawn_server = config.getBoolean("core.spawn_eca_server",false);
			server_port = config.getInt("core.server_port",2868);
			server_host = config.getString("core.server_host","localhost");
		}
		catch(ConfigurationException cex)
		{
			System.out.println("Couldn't parse config - using defaults");
		}
	
		Ecasound el = new Ecasound(server_host,server_port);
		
		if (spawn_server) {
			
			if (!el.spawn_local_server()) {
				System.exit(1);
			}
			Utils.sleep(2);
						
		}
	
	
		// create client connection to the server (local or remote)
		ClientConnection cc = new ClientConnection(server_host,server_port);
	
		if (cc.getSocket()!=null) {
		        
			EcaCommand ecc = new EcaCommand(cc,"int-output-mode-wellformed");
			System.out.println(ecc.getOutput());
			
			EcaCommand ec = new EcaCommand(cc,"status");
			//System.out.println(ec.getStatus());
			System.out.println(ec.getOutput());
			//connection.close();
		}
		cc.close();
	}
	
}
