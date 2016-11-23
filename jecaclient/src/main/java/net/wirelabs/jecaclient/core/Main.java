package net.wirelabs.jecaclient.core;

import java.awt.EventQueue;

import net.wirelabs.jecaclient.gui.swing.MainWindow;

public class Main  {
	
	
	public static void main(String[] args) {
	
		
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
						
//						
//						JAXBContext jc = JAXBContext.newInstance(Conf.class);
//				        Unmarshaller u = jc.createUnmarshaller();
//				        Conf c = (Conf)u.unmarshal(new File("eca2.xml"));
//				       
				        
//					JAXBContext context = JAXBContext.newInstance(Conf.class);
//			        Marshaller m = context.createMarshaller();
//			        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			        Conf c = new Conf();
//			        
//			        for (int i = 0; i<10;i++) {
//			        	Ecasound object = new Ecasound("kaka","localhost",2323,"/var/blabla","/var/log.log",true);
//			        	c.getSessions().add(object);
//			        	
//			        	
//			        }
//			        m.marshal(c, System.out);
//			        
			       // System.exit(1);
					
					Utils.setLook("Metal", 10);

					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
