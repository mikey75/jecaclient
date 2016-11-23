package net.wirelabs.jecaclient.gui.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.Conf;
import net.wirelabs.jecaclient.core.Utils;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private SessionsPanel panel;
	private EcaSessionsPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	private static Conf conf;

	/**
	 * Create the frame.
	 * 
	 * @param conf
	 *            - configuration from ecaclient.xml
	 */
	public MainWindow(Conf conf) {

		MainWindow.conf = conf;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Utils.setFullScreen(this);

		setLayout(new MigLayout("", "[::15%,grow][grow]", "[grow][grow][grow]"));

		panel = new SessionsPanel(conf.getSessions());
		panel_1 = new EcaSessionsPanel(conf.getSessions());
		panel_2 = new LadspaPluginsPanel(conf.getSessions().get(2));
		panel_3 = new BuiltinOperatorsPanel(conf.getSessions().get(2));

		add(panel, "cell 0 0 1 3,grow");
		add(panel_1, "cell 1 0,grow");
		add(panel_2, "cell 1 1,grow");
		add(panel_3, "cell 1 2,grow");

	}

	public static Conf getConf() {
		return conf;
	}

}
