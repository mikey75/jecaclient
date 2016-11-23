package net.wirelabs.jecaclient.gui.swing;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.ClientConnection;
import net.wirelabs.jecaclient.core.EcaCommand;
import net.wirelabs.jecaclient.core.Ecasound;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

import java.util.Vector;

import javax.swing.JList;

public class BuiltinOperatorsPanel extends JPanel {
	private JScrollPane scrollPane;
	private JList list;

	
	public BuiltinOperatorsPanel(Ecasound eca) {
		
		String instanceName;
		
		if (eca != null) {
			instanceName = eca.getInstanceName();
		} else {
			instanceName = "NULL";
		}
		
		setBorder(new TitledBorder(null, instanceName + " - Built-in chain operators", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		ClientConnection e = eca.getConnection();
		EcaCommand.send(e, "map-cop-list");
		
		String[] linie = EcaCommand.output.toString().split("\n");
		Vector v = new Vector();
		
		//for (int i=0;i<linie.length;i++) {
		//	String[] pola = linie[i].split(",");
		//	v.add(pola[1]);
		//	list.setListData(v);
		//}
		

	}

}
