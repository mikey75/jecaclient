package net.wirelabs.jecaclient.gui.swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.ClientConnection;
import net.wirelabs.jecaclient.core.EcaCommand;
import net.wirelabs.jecaclient.core.Ecasound;
import net.wirelabs.jecaclient.core.ladspa.LadspaPlugin;
import net.wirelabs.jecaclient.core.ladspa.LadspaPluginOperator;

public class LadspaPluginsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	private JList list;
	private List<LadspaPlugin> plugins = new ArrayList();
	
	public LadspaPluginsPanel() {
		this(null);
	}
	
	
	public LadspaPluginsPanel(Ecasound eca) {
		
		String instanceName;
		ClientConnection e;
		
		if (eca != null) {
			instanceName = eca.getInstanceName();
			 e = eca.getConnection();
		} else {
			instanceName = "NULL";
			e = null;
		}
		
		setBorder(new TitledBorder(null, instanceName +" - Registered LADSPA Plugins", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		
		
		if (EcaCommand.send(e, "map-ladspa-list")) {
		
			String[] linie = EcaCommand.output.toString().split("\n");
		
		
			Vector v = new Vector();
		
			for (int i=0;i<linie.length;i++) {
			
				LadspaPlugin plugin = new LadspaPlugin(linie[i]);
				plugins.add(plugin);
			
				v.add(plugin.getLabel());
				list.setListData(v);
			}
		System.out.println(linie.length);
		}
		//System.out.println(EcaCommand.output.toString());

	}

}
