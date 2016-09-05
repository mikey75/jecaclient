package net.wirelabs.jecaclient.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketException;
/**
 * single ECA command object. can be queued, queried etc; 
 * 
 */
public class EcaCommand {


	private StringBuffer output;
	private boolean status;

	public EcaCommand(ClientConnection connection, String command ) {

		    StringBuffer instr = new StringBuffer();
		    output = new StringBuffer();
		    
		    try {
				connection.getSocket().setKeepAlive(true);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    	
		    
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
		        //int c;
		     
		       	while ( (inChar = isr.read()) != 10) {
		       		instr.append( (char) inChar);
				}
		       
		       	String [] command_reply = instr.toString().replaceAll("\\p{Cntrl}", "").split(" ");
		       	int size = Integer.parseInt(command_reply[1]);
		       	
		       
		       	for (int i=0;i<size;i++) {
		       		output.append((char)isr.read());
		       	}
		        	
		        
		        /** Close the socket connection. */
		       // connection.close();
		       
		        if (command_reply[2].equals("s")) {
		        	status = true;
		        } else {
		        	status = false;
		        }
		        
		    }
		      catch (IOException f) {
		    	  status = false;
		        System.out.println("IOException: " + f);
		      }
		    
		}	

	public StringBuffer getOutput() {
		return output;
	}

	public boolean getStatus() {
		return status;
	}

	


}

