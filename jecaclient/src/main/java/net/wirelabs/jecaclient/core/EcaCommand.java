package net.wirelabs.jecaclient.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import net.wirelabs.jecaclient.gui.swing.Application;
/**
 * single ECA command object. can be queued, queried etc; 
 * 
 */
public class EcaCommand {


	public static StringBuffer output;
	

	public EcaCommand(ClientConnection connection, String command ) {

		    send(connection, command);
		    
	}

	public static boolean send(ClientConnection connection, String command) {
		
		StringBuffer instr = new StringBuffer();
		output = new StringBuffer();
		
		
		
		// to jest zerżnięte z jakiegos manuala ;) - trzeba to ładniej napisać
		try {
		    
			int inChar;
		    
		    
		    BufferedOutputStream bos = new BufferedOutputStream(connection.getSocket().getOutputStream());
		    OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
		    
		    /** Write across the socket connection and flush the buffer */
		    osw.write(command + (char)13 + (char)10);
		    osw.flush();
		    

		    BufferedInputStream bis = new BufferedInputStream(connection.getSocket().getInputStream());
		    InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

		    /**Read the socket's InputStream and append to a StringBuffer */
		    
		 
		   	while ( (inChar = isr.read()) != 10) {
		   		instr.append( (char) inChar);
			}
		   
		   	String [] command_reply = instr.toString().replaceAll("\\p{Cntrl}", "").split(" ");
		   	int size = Integer.parseInt(command_reply[1]);
		   	
		   
		   	for (int i=0;i<size;i++) {
		   		output.append((char)isr.read());
		   	}
		   
		    return (command_reply[2].equals("s"));
		    
		}
		  catch (IOException | NullPointerException f) {
			
			  Application.getLogger().error("Can't send command");
			  return false;
		  }
	}	




}

