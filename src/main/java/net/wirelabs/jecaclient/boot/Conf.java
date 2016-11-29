package net.wirelabs.jecaclient.boot;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import net.wirelabs.jecaclient.core.Ecasound;
/**
 * Configuration for jecaclient. (ecaclient.xml)
 * @author Michał Szwaczko
 *
 */
@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conf {

	/**
	 * ecasound binary path		
	 */
	@XmlElement(name = "ecasound_path")
	private String path;
	/**
	 * ecasound daemon logfile - if spawning local server
	 */
	@XmlElement(name = "ecasound_logfile")
	private String logfile;
	/**
	 * session id of a session loaded at startup (boot session)
	 */
	@XmlElement(name = "default_session")
	private String defaultsession;
	
	/**
	 * list of configured sessions
	 */
	@XmlElementWrapper(name = "ecasound_sessions")
	@XmlElement(name = "session")
	private List<Ecasound> sessions = new ArrayList<Ecasound>();

	

	
	
	public List<Ecasound> getSessions() {
		return sessions;
	}

	public void setSessions(List<Ecasound> sessions) {
		this.sessions = sessions;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLogfile() {
		return logfile;
	}

	public void setLogfile(String logfile) {
		this.logfile = logfile;
	}

	public String getDefaultsession() {
		return defaultsession;
	}

	public boolean hasDefaultSession() {
		return (defaultsession != null);
	}
	public boolean hasSessions() {
		return (sessions.size()>0);
	}
	
	/**
	 * find the session object of boot session
	 * @return session object
	 */
	public Ecasound getDefaultSessionObject() {
		
		if (hasSessions() && hasDefaultSession()) {
			for (Ecasound e: sessions) {
				if (defaultsession.equals(e.getInstanceId()))
					return e;
			}
		}
		JEca.logger.debug("No default session or default session does not match session id");
		return null;
		
		
			
		
		
	}
		
}