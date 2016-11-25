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

	/**
	 * find the session object of boot session
	 * @return
	 */
	public Ecasound findDefaultSession() {
		
		for (Ecasound e: sessions) {
			
			if (defaultsession.equals(e.getInstance_id()))
				return e;
		}
		throw new IllegalArgumentException("Boot session declared in config file has no corresponding session definition");
	}

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

	
	
		
}