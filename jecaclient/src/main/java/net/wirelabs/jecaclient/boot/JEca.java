package net.wirelabs.jecaclient.boot;

import java.awt.EventQueue;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wirelabs.jecaclient.core.Utils;
import net.wirelabs.jecaclient.gui.swing.MainWindow;

/**
 * Main thread invoker - reads config and instantiates MainWindow;
 * Everything else is in there ...
 * 
 * @author Michał Szwaczko
 *
 */
public class JEca {
	
	public static Logger logger =  LoggerFactory.getLogger(MainWindow.class);
	public static Conf configuration = new Conf(); 

	public static void main(String[] args) {
		
		
		
		// TODO: it would be nice to let user specify client.xml file on commandline perhaps
		EventQueue.invokeLater(new Runnable() {
			

			@Override
			public void run() {
				
				
				
				
				Utils.setLook("Metal", 10);
			
				logger.info("Starting application");
				
				try {
						
					 
					Unmarshaller u = JAXBContext.newInstance(Conf.class).createUnmarshaller();
					configuration = (Conf) u.unmarshal(new File("ecaclient.xml"));
					
					
						
				} catch (JAXBException ex) {
						
					logger.debug("Config file is unreadable or failed parsing, application will start in a default state");
					
				
				} 
					
				MainWindow frame = new MainWindow();
				frame.setVisible(true);
				logger.info("Application started");						
				
			}
						
		});

	}
	
}
