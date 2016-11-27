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

public class SessionsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTree tree;

	
	/**
	 * Create the panel.
	 */
	public SessionsPanel(List<Ecasound> sessions) {
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ecasound Sessions", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		tree = new JTree(new SessionsTreeModel(new DefaultMutableTreeNode("kaka"),sessions));
	
		
		
		
		//tree.setRootVisible(false);
		
		scrollPane.setViewportView(tree);

	}
	
	

}
