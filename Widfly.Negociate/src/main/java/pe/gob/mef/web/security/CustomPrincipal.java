package pe.gob.mef.web.security;

import org.jboss.security.SimplePrincipal;

public class CustomPrincipal extends SimplePrincipal  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7981645660176920480L;
	private long idUserId = 0;
	private String fName = null;
	
    //required when creating principal See AbstractServerLoginModule.createIdentity();
    public CustomPrincipal(String userName) {
        super(userName);
    }

	public long getIdUserId() {
		return idUserId;
	}

	public void setIdUserId(long idUserId) {
		this.idUserId = idUserId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

}
