package net.wirelabs.jecaclient.gui.swing;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class SessionsTreeModel extends DefaultTreeModel {

	
	private static final long serialVersionUID = 1L;

	public SessionsTreeModel(TreeNode root) {
		    super(root);
	
		    //DefaultMutableTreeNode      root = new DefaultMutableTreeNode("JTree");
	        DefaultMutableTreeNode      parent;

	        parent = new DefaultMutableTreeNode("zcolors");
	        ((DefaultMutableTreeNode) root).add(parent);
	        parent.add(new DefaultMutableTreeNode("zblue"));
	        parent.add(new DefaultMutableTreeNode("zviolet"));
	        parent.add(new DefaultMutableTreeNode("zred"));
	        parent.add(new DefaultMutableTreeNode("zyellow"));

	        parent = new DefaultMutableTreeNode("sports");
	        ((DefaultMutableTreeNode) root).add(parent);
	        parent.add(new DefaultMutableTreeNode("basketball"));
	        parent.add(new DefaultMutableTreeNode("soccer"));
	        parent.add(new DefaultMutableTreeNode("football"));
	        parent.add(new DefaultMutableTreeNode("hockey"));

	        parent = new DefaultMutableTreeNode("food");
	        ((DefaultMutableTreeNode) root).add(parent);
	        parent.add(new DefaultMutableTreeNode("hot dogs"));
	        parent.add(new DefaultMutableTreeNode("pizza"));
	        parent.add(new DefaultMutableTreeNode("ravioli"));
	        parent.add(new DefaultMutableTreeNode("bananas"));
	        
	}

}
