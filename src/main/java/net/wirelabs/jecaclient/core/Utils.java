package net.wirelabs.jecaclient.core;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.FontUIResource;

public class Utils {
	
	 public static void centerOnScreen(Window window) {
		
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  Dimension windowSize = window.getSize();
		 
		  windowSize.height = Math.min(windowSize.height, screenSize.height);
		  windowSize.width = Math.min(windowSize.width, screenSize.width);
		  window.setLocation((screenSize.width - windowSize.width) >> 1, (screenSize.height - windowSize.height) >> 1);
		 
	  }
	  
	  public static void setFullScreen(Window window) {
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  window.setLocation(0, 0);
		  window.setSize(screenSize);
	  }
	
	  public static void ErrorMsg(String header, String msg) {
		  JOptionPane.showMessageDialog(null,msg,header, JOptionPane.ERROR_MESSAGE);
	  }
	  
	  public static void ErrorMsg(String msg) {
		  //Toolkit.getDefaultToolkit().beep();
		  JOptionPane.showMessageDialog(null,msg,"Error", JOptionPane.ERROR_MESSAGE);
		
	  }
	  public static void ErrorMsgExit(String msg) {
		  Toolkit.getDefaultToolkit().beep();
		  JOptionPane.showMessageDialog(null,msg,"Błąd", JOptionPane.ERROR_MESSAGE);
		  System.exit(1);
	  }
	
	  public static void setLook(String look, Integer fontsize) {
		// ustaw look and feel
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if (look.toString().equals(info.getName())) {
			        	UIManager.setLookAndFeel(info.getClassName());
			        	
			        	//int fontSize = 10;
			        	
			            Hashtable<Object, Object> defaults = UIManager.getDefaults();
			            Enumeration<Object> keys = defaults.keys();
			            while (keys.hasMoreElements()) {
			                Object key = keys.nextElement();

			                if ((key instanceof String) && (((String) key).endsWith(".font"))) {
			                	
			                    FontUIResource font = (FontUIResource) UIManager.get(key);
			                    FontUIResource newFont = new FontUIResource(font.getFamily(), font.getStyle(), fontsize);
			                    defaults.put (key, newFont);

			                }
			            }
				        break;
				    	}
		    		}
			} catch (Exception e) { 
				
				ErrorMsgExit(e.getMessage());
				
			}
	  }
	  
	  public static void sleep(int seconds) {
			try {
				Thread.sleep(seconds << 10); /* bitshift multiply by 1024 */
			} catch (InterruptedException e) {
				
			}
		}
		
		public static void sleepmili(long miliseconds) {
			try {
				Thread.sleep(miliseconds);
			} catch (InterruptedException e) {
				
			}
		}
}
