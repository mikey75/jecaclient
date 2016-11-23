package net.wirelabs.jecaclient.gui.swing;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import net.wirelabs.jecaclient.core.Conf;
import net.wirelabs.jecaclient.core.Ecasound;
import net.wirelabs.jecaclient.core.Utils;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MainWindow extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private SessionsPanel panel;
	private EcaSessionsPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	List<Ecasound> sessions;
	public static String ecasoundbinary;
	
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		
		
		Conf c = null;
		
		try {
			
			c = load_config();
			sessions = c.getSessions();
			ecasoundbinary = c.getPath();
			
		} catch (JAXBException e) {
			
			Utils.ErrorMsg(e.getCause().toString());
		}
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			Utils.setFullScreen(this);
			getContentPane().setLayout(new MigLayout("", "[::15%,grow][grow]", "[grow][grow][grow]"));
			
			
			
		
			 
			panel = new SessionsPanel(sessions);
			getContentPane().add(panel, "cell 0 0 1 3,grow");
			
			panel_1 = new EcaSessionsPanel(sessions);
			
//			TableModel m = panel_1.getTable().getModel();
//			
//			for (Ecasound s : sessions) {
//				  Object[] o = new Object[4];
//				  o[0] = s.getInstanceName();
//				  o[1] = s.getServer_host();
//				  o[2] = s.getServer_port();
//				  o[3] = s.spawnServer();
//				  ((DefaultTableModel) m).addRow(o);
//				  
//				}
//			
//			
//			
//			panel_1.getTable().setModel(m);
			
			getContentPane().add(panel_1, "cell 1 0,grow");
			
			panel_2 = new LadspaPluginsPanel(sessions.get(2));
			getContentPane().add(panel_2, "cell 1 1,grow");
			
			panel_3 = new BuiltinOperatorsPanel(sessions.get(2));
			getContentPane().add(panel_3, "cell 1 2,grow");
			
		}
		
		
		
	
	
	private Conf load_config() throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Conf.class);
		Unmarshaller u = jc.createUnmarshaller();
		Conf c = (Conf)u.unmarshal(new File("ecaclient.xml"));
		return c;
	}
}
