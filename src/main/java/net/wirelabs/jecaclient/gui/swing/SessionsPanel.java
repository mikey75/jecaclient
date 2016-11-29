package net.wirelabs.jecaclient.gui.swing;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.Ecasound;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JLabel;

public class SessionsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTree tree;
	
	private JPanel panel;
	private JLabel IPLabel;
	private JLabel portLabel;
	private JLabel spawnLabel;
	private JLabel IPValue;
	private JLabel portValue;
	private JLabel spawnValue;

	
	/**
	 * Create the panel.
	 */
	public SessionsPanel(List<Ecasound> sessions) {
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ecasound Sessions", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		tree = new JTree(new SessionsTreeModel(new DefaultMutableTreeNode("kaka"),sessions));
		
		
		
		
		
		//tree.setRootVisible(false);
		
		scrollPane.setViewportView(tree);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Session info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[][]", "[][][][]"));
		
		IPLabel = new JLabel("IP Address:");
		panel.add(IPLabel, "cell 0 0");
		
		IPValue = new JLabel("(none)");
		panel.add(IPValue, "cell 1 0");
		
		portLabel = new JLabel("TCP Port:");
		panel.add(portLabel, "cell 0 1");
		
		portValue = new JLabel("(none)");
		panel.add(portValue, "cell 1 1");
		
		spawnLabel = new JLabel("Spawn local:");
		panel.add(spawnLabel, "cell 0 2");
		
		spawnValue = new JLabel("(none)");
		panel.add(spawnValue, "cell 1 2");


		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = 
					       (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				Ecasound session = (Ecasound) selectedNode.getUserObject();
				IPValue.setText(session.getServer_host());
				portValue.setText(String.valueOf(session.getServer_port()));
				spawnValue.setText(String.valueOf(session.spawnServer()));
				
			}
			
		});
	}
	
	

}
