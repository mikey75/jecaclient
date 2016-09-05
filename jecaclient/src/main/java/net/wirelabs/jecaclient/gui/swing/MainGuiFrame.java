package net.wirelabs.jecaclient.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import net.wirelabs.jecaclient.core.ClientConnection;
import net.wirelabs.jecaclient.core.EcaCommand;
import net.wirelabs.jecaclient.core.Ecasound;

public class MainGuiFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	

	/**
	 * Create the frame.
	 */
	public MainGuiFrame() {
		
		this(null);
		
		
	}
	/**
	 * Main application 
	 * @param el - list of configured ecasound instances
	 */
	public MainGuiFrame(List<Ecasound> el) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][]"));
		
		JButton btnKakkakakakaka = new JButton("kakkakakakaka");
		
		Ecasound [] arr = new Ecasound[el.size()];
		arr = el.toArray(arr);
		
		JComboBox<Ecasound> comboBox = new JComboBox<Ecasound>(arr);
		
		comboBox.setRenderer(new InstanceSelectorRenderer());
		comboBox.setEditable(false);
		btnKakkakakakaka.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ecasound ec = (Ecasound) comboBox.getSelectedItem();
				//System.out.println(ec.spawnServer());
				docommand((Ecasound)comboBox.getSelectedItem());
			}
		});
		
		
		
		contentPane.add(comboBox, "cell 0 0,growx");
		
		contentPane.add(btnKakkakakakaka, "cell 0 1");
		
		
		
	}

	private void docommand(Ecasound el) {
		ClientConnection cc = el.getConnection(); 
		//ClientConnection cc = new ClientConnection(el);
		
		if (cc.getSocket()!=null) {
	        
			EcaCommand ecc = new EcaCommand(cc,"int-output-mode-wellformed");
			System.out.println(ecc.getOutput());
			
			EcaCommand ec = new EcaCommand(cc,"status");
			//System.out.println(ec.getStatus());
			System.out.println(ec.getOutput());
			//connection.close();
		}
		//cc.close();
	}

}
