package net.wirelabs.jecaclient.boot;

import java.awt.EventQueue;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.wirelabs.jecaclient.core.Utils;
import net.wirelabs.jecaclient.gui.swing.Application;

/**
 * Main thread invoker - reads config and instantiates MainWindow;
 * Everything else is in there ...
 * 
 * @author Michał Szwaczko
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// TODO: it would be nice to let user specify client.xml file on commandline perhaps
		EventQueue.invokeLater(new Runnable() {
			

			@Override
			public void run() {

				try {
					
					Utils.setLook("Metal", 10);
					Conf conf = load_config();
					Application frame = new Application(conf);
					frame.setVisible(true);
										
				} catch (JAXBException e) {
					Utils.ErrorMsgExit("ecaclient.xml parse error");
				}
			}

			private Conf load_config() throws JAXBException {
				JAXBContext jc = JAXBContext.newInstance(Conf.class);
				Unmarshaller u = jc.createUnmarshaller();
				Conf c = (Conf) u.unmarshal(new File("ecaclient.xml"));
				return c;
			}
		});

	}

}
