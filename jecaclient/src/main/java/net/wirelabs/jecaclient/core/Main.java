package net.wirelabs.jecaclient.core;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import net.wirelabs.jecaclient.gui.swing.MainGuiFrame;

public class Main  {
	
	private final static String DEFAULT_HOST = "localhost";
	private final static int DEFAULT_PORT = 2868;
	private final static String DEFAULT_PATH = "/usr/bin/ecasound";
	private final static boolean DEFAULT_SPAWN = false;
	private final static String DEFAULT_LOGFILE = "ecasound-log-file.log";
	
	public static void main(String[] args) throws IOException, ConfigurationException {
		
		
		XMLConfiguration config = new XMLConfiguration("eca.xml");
		Object prop = config.getProperty("eca_instances.eca_instance.name");
		List <Ecasound> instancje = new LinkedList<Ecasound>();
		
		
		
		if(prop instanceof Collection)
		{		
				for (int i=0; i < ((Collection<?>) prop).size(); i++) {
					
					String name = config.getString("eca_instances.eca_instance(" + i + ").name");
					String host = config.getString("eca_instances.eca_instance(" + i + ").server_host",DEFAULT_HOST);
					int port =  config.getInt("eca_instances.eca_instance(" + i + ").server_port",DEFAULT_PORT);
					String logfile = config.getString("eca_instances.eca_instance(" + i + ").logfile",DEFAULT_LOGFILE);
					String path = config.getString("eca_instances.eca_instance(" + i + ").path",DEFAULT_PATH);
					boolean spawn = config.getBoolean("eca_instances.eca_instance(" + i + ").spawn_server",DEFAULT_SPAWN);
					
					Ecasound e = new Ecasound(name,host,port,path,logfile,spawn);
					instancje.add(e);
					//System.out.println(config.getProperty("eca_instances.eca_instance(" + i + ").name"));
					//System.out.println(config.getProperty("eca_instances.eca_instance(" + i + ").server_host"));		
				}
		        //System.out.println("Number of tables: " + ((Collection<?>) prop).size());
		} else {
			
			String name = config.getString("eca_instances.eca_instance(0).name");
			String host = config.getString("eca_instances.eca_instance(0).server_host",DEFAULT_HOST);
			int port =  config.getInt("eca_instances.eca_instance(0).server_port",DEFAULT_PORT);
			String logfile = config.getString("eca_instances.eca_instance(0).logfile",DEFAULT_LOGFILE);
			String path = config.getString("eca_instances.eca_instance(0).path",DEFAULT_PATH);
			boolean spawn = config.getBoolean("eca_instances.eca_instance(0).spawn_server",DEFAULT_SPAWN);
			
			Ecasound e = new Ecasound(name,host,port,path,logfile,spawn);
			instancje.add(e);
		}
		
		

		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainGuiFrame frame = new MainGuiFrame(instancje);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
