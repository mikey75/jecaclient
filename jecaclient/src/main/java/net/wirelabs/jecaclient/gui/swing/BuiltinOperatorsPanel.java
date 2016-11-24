package net.wirelabs.jecaclient.gui.swing;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.Ecasound;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

import java.util.Vector;

import javax.swing.JList;

public class BuiltinOperatorsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JList<String> list;

	
	public BuiltinOperatorsPanel(Ecasound eca) {
		
		
		list = new JList<>();
		
		setBorder(new TitledBorder(null, eca.getInstanceName() + " - Built-in chain operators", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		scrollPane.setViewportView(list);
		
		eca.command("map-cop-list");
		
		String[] linie = eca.response().split("\n");
		
		Vector<String> v = new Vector<>();
		
		for (int i=0;i<linie.length;i++) {
			String[] pola = linie[i].split(",");
			v.add(pola[1]);
			list.setListData(v);
		}
		

	}

}
