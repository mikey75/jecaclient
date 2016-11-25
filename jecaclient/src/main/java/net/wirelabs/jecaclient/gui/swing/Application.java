package net.wirelabs.jecaclient.gui.swing;



import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.boot.Conf;
import net.wirelabs.jecaclient.core.Ecasound;
import net.wirelabs.jecaclient.core.Utils;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	private SessionsPanel panel;
	private EcaSessionsPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	private static Conf conf;
	private static Logger logger;

	/**
	 * Create the frame.
	 * 
	 * @param conf
	 *            - configuration from ecaclient.xml
	 */
	public Application(Conf conf) {

		Application.conf = conf;
		Application.logger =  LoggerFactory.getLogger(Application.class);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	

		setLayout(new MigLayout("", "[::15%,grow][grow]", "[grow][grow][grow]"));

		
		
		
		try {
			
			Ecasound e = conf.findDefaultSession();
			
			panel = new SessionsPanel(conf.getSessions());
			panel_1 = new EcaSessionsPanel(conf.getSessions());
			panel_2 = new LadspaPluginsPanel(e); //conf.getSessions().get(2));
			panel_3 = new BuiltinOperatorsPanel(e);//conf.getSessions().get(2));

			add(panel, "cell 0 0 1 3,grow");
			add(panel_1, "cell 1 0,grow");
			add(panel_2, "cell 1 1,grow");
			add(panel_3, "cell 1 2,grow");
		
			Utils.setFullScreen(this);
		} catch (IllegalArgumentException ex) {
			//System.out.println("ex");
			Utils.ErrorMsgExit(ex.getMessage());
			
		}
		

	}

	public static Conf getConf() {
		return conf;
	}

	public static Logger getLogger() {
		return logger;
	}

}
