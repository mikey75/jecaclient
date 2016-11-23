package net.wirelabs.jecaclient.gui.swing;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.Ecasound;

public class SessionsPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTree tree;

	public SessionsPanel() {
		this(null);
	}
	/**
	 * Create the panel.
	 */
	public SessionsPanel(List<Ecasound> engines) {
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ecasound Sessions", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		tree = new JTree(new SessionsTreeModel(new DefaultMutableTreeNode("kaka")));
	
		
		
		
		//tree.setRootVisible(false);
		
		scrollPane.setViewportView(tree);

	}
	
	

}
