package net.wirelabs.jecaclient.gui.swing;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import net.wirelabs.jecaclient.core.Ecasound;

public class InstanceSelectorRenderer extends JLabel implements ListCellRenderer<Ecasound> {

	
	private static final long serialVersionUID = 1L;
	
	public InstanceSelectorRenderer() {
		setOpaque(true);
        
    }
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Ecasound> list, Ecasound value, int index,
			boolean isSelected, boolean cellHasFocus) 
	{
		 
		setText((value == null) ? "null" : value.getInstanceName());
		
		if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
		
		return this;
	
	}
	
}
