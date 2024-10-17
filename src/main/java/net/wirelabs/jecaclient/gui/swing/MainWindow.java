package net.wirelabs.jecaclient.gui.swing;



import java.util.List;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.boot.JEca;
import net.wirelabs.jecaclient.core.Ecasound;
import net.wirelabs.jecaclient.core.Utils;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private SessionsPanel panel;
	private EcaSessionsPanel panel1;
	private JPanel panel2;
	private JPanel panel3;


	
	public MainWindow() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 500);
		getContentPane().setLayout(new MigLayout("", "[::15%,grow][grow]", "[grow][grow][grow]"));

	
			
			Ecasound defaultsession = JEca.configuration.getDefaultSessionObject();
			
			List<Ecasound> sessionlist = JEca.configuration.getSessions();
			panel = new SessionsPanel(sessionlist);
			panel1 = new EcaSessionsPanel(sessionlist);
			panel2 = new LadspaPluginsPanel(defaultsession); //conf.getSessions().get(2));
			panel3 = new BuiltinOperatorsPanel(defaultsession);//conf.getSessions().get(2));

			getContentPane().add(panel, "cell 0 0 1 3,grow");
			getContentPane().add(panel1, "cell 1 0,grow");
			getContentPane().add(panel2, "cell 1 1,grow");
			getContentPane().add(panel3, "cell 1 2,grow");
		
			
		
		
			Utils.setFullScreen(this);
		
		
	}

	
	
	
	
	
}
