package net.wirelabs.jecaclient.gui.swing;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import net.wirelabs.jecaclient.core.Ecasound;

public class SessionsTreeModel extends DefaultTreeModel {

	
	private static final long serialVersionUID = 1L;

	public SessionsTreeModel(TreeNode root, List<Ecasound> sessions) {
		    super(root);
	
		
	        DefaultMutableTreeNode      parent;

	        for (Ecasound e: sessions) {
	        	parent = new DefaultMutableTreeNode(e.getInstanceName());
	        	((DefaultMutableTreeNode) root).add(parent);
	        	parent.setUserObject(e);
	        	
	        //	parent.add(new DefaultMutableTreeNode(e.getServer_host()));
		     //   parent.add(new DefaultMutableTreeNode(e.getServer_port()));
		     //   parent.add(new DefaultMutableTreeNode(e.getInstanceId()));
		     //   parent.add(new DefaultMutableTreeNode(e.isSpawned()));

	        }
	      
	}

	
}
