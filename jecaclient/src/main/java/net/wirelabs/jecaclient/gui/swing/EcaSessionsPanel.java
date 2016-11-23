package net.wirelabs.jecaclient.gui.swing;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.Ecasound;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class EcaSessionsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAddNew;

	/**
	 * Create the panel.
	 * @param sessions 
	 */
	public EcaSessionsPanel(List<Ecasound> sessions) {
		setBorder(new TitledBorder(null, "Configured ecasound servers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Name", "Address", "Port", "Spawn"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Boolean.class
			};
			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		TableModel m = table.getModel();
		
				
		
		for (Ecasound s : sessions) {
			  Object[] o = new Object[4];
			  o[0] = s.getInstanceName();
			  o[1] = s.getServer_host();
			  o[2] = s.getServer_port();
			  o[3] = s.spawnServer();
			  ((DefaultTableModel) m).addRow(o);
			  
			}
		
		
		
		table.setModel(m);
		
		scrollPane.setViewportView(table);
		
		btnAddNew = new JButton("Add new");
		
		btnAddNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("add_new_instance");
				new AddNewInstance().show();
			}
		});
		
		add(btnAddNew, "cell 0 1");

	}

	public JTable getTable() {
		return table;
	}
}
