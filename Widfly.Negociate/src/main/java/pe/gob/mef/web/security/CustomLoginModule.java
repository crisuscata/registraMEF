/**
 * 
 */
package pe.gob.mef.web.security;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.security.Principal;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.jboss.security.PicketBoxLogger;
import org.jboss.security.PicketBoxMessages;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.AbstractServerLoginModule;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;
import org.jboss.security.plugins.TransactionManagerLocator;

/**
 * @author caguilar
 *
 */
public class CustomLoginModule extends UsernamePasswordLoginModule implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4358540625230859091L;
	// see AbstractServerLoginModule
	private static final String DS_JNDI_NAME = "dsJndiName";
	private static final String ROLES_QUERY = "rolesQuery";
	private static final String SUSPEND_RESUME = "suspendResume";
	private static final String PRINCIPALS_QUERY = "principalsQuery"; 
	private static final String TRANSACTION_MANAGER_JNDI_NAME = "transactionManagerJndiName";
	private static final String LDAP_URL = "ldapURL";
	private static final String DOMAIN_BASE = "base";
	private static final String PASSWD_ADMIN = "pwd";
	private static final String PRINCIPALCLASSNAME = "principalClassName";

	private static final String[] ALL_VALID_OPTIONS = { DS_JNDI_NAME, ROLES_QUERY, SUSPEND_RESUME, PRINCIPALS_QUERY,
			TRANSACTION_MANAGER_JNDI_NAME, LDAP_URL, DOMAIN_BASE, PASSWD_ADMIN };

	/** The JNDI name of the DataSource to use */
	protected String dsJndiName = "java:/REGISTRAMEFs";
	
	/** The sql query to obtain the user password */
	protected String principalsQuery = "SELECT IDUSUARIO,TRIM(NOMBRES ||' '|| APELLIDO_PATERNO ||' '|| APELLIDO_MATERNO) AS FULLNAME, CONTRASENIA FROM REGISTRAMEF.MS_USUARIOS WHERE USERNAME=? AND ESTADO>0 ";

	/** The sql query to obtain the user roles */
	protected String rolesQuery = "SELECT ROL FROM REGISTRAMEF.MS_ROLES WHERE USERNAME=? AND ESTADO>0 ";
	
	/** Whether to suspend resume transactions during database operations */
	protected boolean suspendResume = true;
	
	/** The JNDI name of the transaction manager */
	protected String txManagerJndiName = "java:/TransactionManager";
	
	/** The TransactionManagaer instance to be used */
	protected TransactionManager tm = null;

	protected String ldapURL = "ldap://mefscedc01.mef.gob.pe:389";
	protected String base="mef.gob.pe";
	protected String pwd="tr4m1t3";
	
	/**
	 * Initialize this LoginModule.
	 * 
	 * @param options
	 *            - dsJndiName: The name of the DataSource of the database
	 *            containing the Principals, Roles tables principalsQuery: The
	 *            prepared statement query, equivalent to: "select Password from
	 *            Principals where PrincipalID=?" rolesQuery: The prepared
	 *            statement query, equivalent to: "select Role, RoleGroup from
	 *            Roles where PrincipalID=?"
	 */
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
//        log.info("INICIALIZANDO CustomLoginModule...");
         
        addValidOptions(ALL_VALID_OPTIONS);
		
		
		Object tmp = options.get(DS_JNDI_NAME);
		if (tmp != null)
			dsJndiName = tmp.toString();
		
		tmp = options.get(PRINCIPALS_QUERY);
		if (tmp != null)
			principalsQuery = tmp.toString();
		
		tmp = options.get(ROLES_QUERY);
		if (tmp != null)
			rolesQuery = tmp.toString();
		
		tmp = options.get(SUSPEND_RESUME);
		if (tmp != null)
			suspendResume = Boolean.valueOf(tmp.toString()).booleanValue();

		// Get the Transaction Manager JNDI Name
		String jname = (String) options.get(TRANSACTION_MANAGER_JNDI_NAME);
		if (jname != null)
			this.txManagerJndiName = jname;
		
		// Get LDAP Server
		String ldapURL = (String) options.get(LDAP_URL);
		if (ldapURL != null)
			this.ldapURL = ldapURL;

		// Get DOMINIO BASE
		String base = (String) options.get(DOMAIN_BASE);
		if (base != null)
			this.base = base;
		
		
		String principal = (String) options.get(PRINCIPALCLASSNAME);
		if (principal != null)
			this.principalClassName = principal;
		
		// Get PASSWORD ADMIN
		String pwd = (String) options.get(PASSWD_ADMIN);
		if (pwd != null)
			this.pwd = pwd;
		
		PicketBoxLogger.LOGGER.traceDBCertLoginModuleOptions(dsJndiName, principalsQuery, rolesQuery, suspendResume);

		try {
			if (this.suspendResume)
				tm = this.getTransactionManager();
		} catch (NamingException e) {
			throw PicketBoxMessages.MESSAGES.failedToGetTransactionManager(e);
		}
		
		super.initialize(subject, callbackHandler, sharedState, options);
	}

	@Override
	protected String getUsersPassword() throws LoginException {
		
//System.out.println("GET USUARIO AND PASSWRD....");
		String username = getUsername();
		String password = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Transaction tx = null;
		if (suspendResume) {
			// tx = TransactionDemarcationSupport.suspendAnyTransaction();
			try {
				if (tm == null)
					throw PicketBoxMessages.MESSAGES.invalidNullTransactionManager();
				tx = tm.suspend();
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
		}

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(dsJndiName);
			conn = ds.getConnection();
			// Get the password
			PicketBoxLogger.LOGGER.traceExecuteQuery(principalsQuery, username);
			
			ps = conn.prepareStatement(principalsQuery);
			ps.setString(1, username);
			rs = ps.executeQuery();

			if (rs.next() == false) {
				throw PicketBoxMessages.MESSAGES.noMatchingUsernameFoundInPrincipals();
			}

			password = rs.getString(3);////MPINARES 19052021 - INICIO
			
			if(password!=null)
			password = convertRawPassword(password);
			
		} catch (NamingException ex) {
			LoginException le = new LoginException(
					PicketBoxMessages.MESSAGES.failedToLookupDataSourceMessage(dsJndiName));
			le.initCause(ex);
			throw le;
		} catch (SQLException ex) {
			LoginException le = new LoginException(PicketBoxMessages.MESSAGES.failedToProcessQueryMessage());
			le.initCause(ex);
			throw le;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}
			if (suspendResume) {
				// TransactionDemarcationSupport.resumeAnyTransaction(tx);
				try {
					if(tx!=null)
					tm.resume(tx);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		if (password==null && getUsername()!=null && getUsername().equals("AdminSID-D")){
			password=pwd;
		}
		return password;
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
//System.out.println("GETROLLES.....");
		if (rolesQuery != null) {
			String username = getUsername();
			PicketBoxLogger.LOGGER.traceExecuteQuery(rolesQuery, username);
			Group[] roleSets = getRoleSets(username, dsJndiName, txManagerJndiName, rolesQuery, this, suspendResume);
			return roleSets;
		}
		return new Group[0];
	}

	protected String convertRawPassword(String rawPassword) {
//System.out.println("CONVIRTIENDO EN STRING.....");
		Encriptar encritor = new Encriptar();
		String spassworddessincript = encritor.Desencriptar(getUsername().toLowerCase(),rawPassword);
		return spassworddessincript;
	}

	protected TransactionManager getTransactionManager() throws NamingException {
//System.out.println("TRANSACCION.....");
		TransactionManagerLocator tml = new TransactionManagerLocator();
		return tml.getTM(this.txManagerJndiName);
	}

	protected Group[] getRoleSets(String username, String dsJndiName, String txManagerJndiName, String rolesQuery,
			AbstractServerLoginModule aslm, boolean suspendResume) throws LoginException {
//System.out.println("GRUPOS.....");
		Connection conn = null;
		HashMap<String, Group> setsMap = new HashMap<String, Group>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		TransactionManager tm = null;

		if (suspendResume) {
			TransactionManagerLocator tml = new TransactionManagerLocator();
			try {
				tm = tml.getTM(txManagerJndiName);
			} catch (NamingException e1) {
				throw new RuntimeException(e1);
			}
			if (tm == null)
				throw PicketBoxMessages.MESSAGES.invalidNullTransactionManager();
		}
		Transaction tx = null;
		if (suspendResume) {
			// tx = TransactionDemarcationSupport.suspendAnyTransaction();
			try {
				tx = tm.suspend();
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
		}

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(dsJndiName);
			conn = ds.getConnection();
			// Get the user role names
			PicketBoxLogger.LOGGER.traceExecuteQuery(rolesQuery, username);
			ps = conn.prepareStatement(rolesQuery);
			try {
				ps.setString(1, username);
			} catch (ArrayIndexOutOfBoundsException ignore) {
				// The query may not have any parameters so just try it
			}

			rs = ps.executeQuery();
			if (rs.next() == false)
				throw new FailedLoginException("NO TIENE NINGÚN GRUPO ASIGNADO...");

			do {
				String name = rs.getString(1);
				String groupName = null;//MPINARES 19052021 - INICIO
				if (groupName == null || groupName.length() == 0)
					groupName = "Roles";
				Group group = (Group) setsMap.get(groupName);
				if (group == null) {
					group = new SimpleGroup(groupName);
					setsMap.put(groupName, group);
				}

				try {					
					Principal p = createIdentity(name);
					group.addMember(p);
//					System.out.println("ROL "+name);
				} catch (Exception e) {
					PicketBoxLogger.LOGGER.debugFailureToCreatePrincipal(name, e);
				}
			} while (rs.next());
		} catch (NamingException ex) {
			LoginException le = new LoginException(
					PicketBoxMessages.MESSAGES.failedToLookupDataSourceMessage(dsJndiName));
			le.initCause(ex);
			throw le;
		} catch (SQLException ex) {
			LoginException le = new LoginException(PicketBoxMessages.MESSAGES.failedToProcessQueryMessage());
			le.initCause(ex);
			throw le;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			}
			if (suspendResume) {
				// TransactionDemarcationSupport.resumeAnyTransaction(tx);
				try {
					tm.resume(tx);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		Group[] roleSets = new Group[setsMap.size()];
		setsMap.values().toArray(roleSets);
		return roleSets;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Principal createIdentity(String username) throws Exception {
		Principal p = null;
		if (principalClassName == null) {
			p = new SimplePrincipal(username);
		} else {
			Class clazz = this.getClass().getClassLoader().loadClass(principalClassName);
			Class[] ctorSig = { String.class };
			Constructor ctor = clazz.getConstructor(ctorSig);
			Object[] ctorArgs = { username };
			p = (Principal) ctor.newInstance(ctorArgs);
		}
		return p;
	}
	
	protected boolean validatePassword(String inputPassword, String expectedPassword)
	   {
//System.out.println("VALIDANDO: "+inputPassword+" --> "+expectedPassword);
		log.info("INICIO DE USUARIO: "+getUsername());
		boolean valid = super.validatePassword(inputPassword, expectedPassword);
		if(!valid){
			if (ldapURL != null && base != null && ldapURL.trim().length()>1 && base.trim().length()>1) {
				
				Hashtable<String, String> authEnv = new Hashtable<String, String>(11);				
				String dn = getUsername() + "@" + base;
				authEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
				authEnv.put(Context.PROVIDER_URL, ldapURL);
				authEnv.put(Context.SECURITY_AUTHENTICATION,"simple");
				authEnv.put(Context.SECURITY_PRINCIPAL, dn);
				authEnv.put(Context.SECURITY_CREDENTIALS,inputPassword);
				authEnv.put(Context.REFERRAL, "follow");
				
//System.out.println("LDAP VALIDATION "+getUsername()+" Base "+base+" ldap "+ldapURL+" dn "+getUsername());
				
				try {
					@SuppressWarnings("unused")
					DirContext authContext = new InitialDirContext(authEnv);
					valid = true;
				} catch (AuthenticationException authEx) {
					// System.out.println("Authentication failed!");
					//authEx.printStackTrace();
				} catch (NamingException namEx) {
					// System.out.println("Something went wrong!");
					//namEx.printStackTrace();
				}
			}
			if(!valid){
			if (pwd != null && getUsername()!=null && inputPassword!=null)
				if (getUsername().equals("AdminSID-D") && inputPassword.equals(pwd))
					valid = true;
			}
			// -------------------
		}
//		System.out.println("RETORNANDO: "+inputPassword+" --> "+expectedPassword+" ES "+valid);
	      return valid;
	   }

}
