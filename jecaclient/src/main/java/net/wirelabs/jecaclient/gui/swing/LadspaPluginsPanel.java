package net.wirelabs.jecaclient.gui.swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.Ecasound;
import net.wirelabs.jecaclient.core.ladspa.LadspaPlugin;

public class LadspaPluginsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	private JList<String> list; 
	private List<LadspaPlugin> plugins;
	
	
	
	public LadspaPluginsPanel(Ecasound eca) {
		
		
		list = new JList<String>();
		plugins = new ArrayList<>();
		
		setBorder(new TitledBorder(null, eca.getInstanceName() +" - Registered LADSPA Plugins", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		
		scrollPane.setViewportView(list);
		
		
		
		if (eca.command("map-ladspa-list")) {
		
			String[] linie = eca.response().split("\n");
		
		
			Vector<String> v = new Vector<>();
		
			for (int i=0;i<linie.length;i++) {
			
				LadspaPlugin plugin = new LadspaPlugin(linie[i]);
				plugins.add(plugin);
			
				v.add(plugin.getLabel());
				list.setListData(v);
			}
		
		}
		

	}

}
