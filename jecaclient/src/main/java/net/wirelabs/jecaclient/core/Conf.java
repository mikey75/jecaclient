package net.wirelabs.jecaclient.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conf {

		
	@XmlElement(name = "ecasound_path")
	private String path;
	@XmlElement(name = "ecasound_logfile")
	private String logfile;

	@XmlElementWrapper(name = "ecasound_sessions")
	@XmlElement(name = "session")
	private List<Ecasound> sessions = new ArrayList<Ecasound>();

	public List<Ecasound> getSessions() {
		return sessions;
	}

	public void setSessions(List<Ecasound> sessions) {
		this.sessions = sessions;
	}

	
}