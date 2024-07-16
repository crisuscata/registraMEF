
package pe.gob.mef.registramef.bs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;

import com.sun.mail.smtp.SMTPTransport;
//JPUYEN 17062024 - NUEVA CLASE EN EL PROYECTO


public class EmailUtil implements TransportListener, ConnectionListener {
	
	private static Log logger = LogFactory.getLog(EmailUtil.class.getName());
	
	public static void main(String[] args) {
		try {
			EmailUtil email = new EmailUtil();
			List<String> recipients = new ArrayList<String>();
			recipients.add("ivan@villafana.pe");
			String sub = "Asunto Encuesta:)"; 
			String msg = "Este mensaje es de prueba...";
			email.sendEmail(recipients, null, null, sub, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendmailtoM(boolean detalle, int validar, String usuario, String password, Properties props, String from, String sub, String recipiente,
			String msg) {
		SMTPTransport t = null;
		try {
			Session session = javax.mail.Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);
			message.addHeader("Content-type", "text/html");
			message.setSubject(sub);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, recipiente);
			message.setText(msg, "ISO-8859-1", "html");
			message.setSentDate(new Date());
			t = (SMTPTransport) session.getTransport("smtp");

			if (detalle) {
				t.addConnectionListener(this);
				t.addTransportListener(this);
			}

			if (validar == 0) {
				t.connect(usuario, password);
			} else {
				t.connect();
			}
			t.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException mex) {
			if (detalle) {
				mex.printStackTrace();
				System.out.println();
				Exception ex = mex;
				do {
					if (ex instanceof SendFailedException) {
						SendFailedException sfex = (SendFailedException) ex;
						Address[] invalid = sfex.getInvalidAddresses();
						if (invalid != null) {
							System.out.println(" ** Invalid Addresses");
							if (invalid != null) {
								for (int i = 0; i < invalid.length; i++)
									System.out.println(" " + invalid[i]);
							}
						}
						Address[] validUnsent = sfex.getValidUnsentAddresses();
						if (validUnsent != null) {
							System.out.println(" ** ValidUnsent Addresses");
							if (validUnsent != null) {
								for (int i = 0; i < validUnsent.length; i++)
									System.out.println(" " + validUnsent[i]);
							}
						}
						Address[] validSent = sfex.getValidSentAddresses();
						if (validSent != null) {
							System.out.println(" ** ValidSent Addresses");
							if (validSent != null) {
								for (int i = 0; i < validSent.length; i++)
									System.out.println(" " + validSent[i]);
							}
						}
					}
					System.out.println();
					if (ex instanceof MessagingException)
						ex = ((MessagingException) ex).getNextException();
					else
						ex = null;
				} while (ex != null);
			}
		} finally {
			try {
				if (t != null)
					t.close();
			} catch (MessagingException mex) {
			}
		}
	}


	
	public static boolean validateEmail(String email) {
		try {
			new InternetAddress(email).validate();

		} catch (AddressException ex) {
			System.out.println("Error : " + ex.getMessage());
			return false;
		}
		return true;
	}

	
	public void addToZipFile(String fileName, String ruta, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(ruta);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

	
	public void closed(ConnectionEvent arg0) {
		System.out.println("Connection closed");
	}

	
	public void disconnected(ConnectionEvent arg0) {
		System.out.println("Connection disconnected");
	}

	
	public void opened(ConnectionEvent arg0) {
		System.out.println("Connection opened");
	}

	
	public void messageDelivered(TransportEvent e) {
		System.out.println("Message delivered for:");
		if (e != null) {
			Address[] a = e.getValidSentAddresses();
			if (a != null && a.length > 0) {
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i].toString());
				}
			}
			System.out.println("");
		}
	}

	
	public void messageNotDelivered(TransportEvent e) {
		System.out.println("Message not delivered for:");
		if (e != null) {
			Address[] a = e.getValidUnsentAddresses();
			if (a != null && a.length > 0) {
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i].toString());
				}
			}
			System.out.println("");
		}
	}

	
	public void messagePartiallyDelivered(TransportEvent e) {
		System.out.println("These addresses are invalid:");
		if (e != null) {
			Address[] a = e.getInvalidAddresses();
			if (a != null && a.length > 0) {
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i].toString());
				}
			}
			System.out.println("");
		}
	}

	

	private String getApellidoDeCorreo(String correo) {
		String apellido = null;
		int arrova = correo.indexOf('@');
		if (arrova > 0) {
			apellido = correo.substring(1, arrova);
		}
		return apellido;
	}

	public void sendEmailCpyM(List<String> recipients, List<String> recipientsCC, List<String> recipientsCCO, String sub, String msg) {

		if (recipients == null) {
			String errMsg = "Could not send email: smtp host address is null";
			logger.error(errMsg);
			return;
		}

		Properties propertieAlarma = PropertiesMg.getAlarmaProperties();
		int validar = 0;
		try {
			validar = Integer.parseInt(propertieAlarma.getProperty("VALIDAR", "0"));
		} catch (Exception e) {
		}

		boolean detalle = false;
		try {
			detalle = Boolean.parseBoolean(propertieAlarma.getProperty("DETALLE", "false"));
		} catch (Exception e) {
		}

		String from = null;
		if (propertieAlarma != null) {
			Properties props = new Properties();
			from = propertieAlarma.getProperty("userSMTP");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", propertieAlarma.getProperty("servidorSMTP"));

			props.setProperty("mail.smtp.port", propertieAlarma.getProperty("puertoSMTP"));

			if (validar == 0 || validar == 1) {
				props.setProperty("mail.smtp.starttls.enable", "true");
				if (validar == 0) {
					props.setProperty("mail.smtp.user", from);
					props.setProperty("mail.smtp.auth", "true");
				}
			}

			String password = propertieAlarma.getProperty("passSMTP");
			String usuario = from;

			SMTPTransport t = null;
			try {
				Session session = javax.mail.Session.getDefaultInstance(props);

				MimeMessage message = new MimeMessage(session);
				message.addHeader("Content-type", "text/html");
				message.setSubject(sub);
				message.setFrom(new InternetAddress(propertieAlarma.getProperty("userSMTP")));

				for (Iterator<String> it = recipients.iterator(); it.hasNext();) {
					String email = (String) it.next();
					message.addRecipients(Message.RecipientType.TO, email);
				}

				if (recipientsCC != null && recipientsCC.size() > 0) {
					for (Iterator<String> it = recipientsCC.iterator(); it.hasNext();) {
						String email = (String) it.next();
						message.addRecipients(Message.RecipientType.CC, email);
					}
				}

				if (recipientsCCO != null && recipientsCCO.size() > 0) {
					for (Iterator<String> it = recipientsCCO.iterator(); it.hasNext();) {
						String email = (String) it.next();
						message.addRecipients(Message.RecipientType.BCC, email);
					}
				}

				message.setText(msg, "ISO-8859-1", "html");
				message.setSentDate(new Date());

				t = (SMTPTransport) session.getTransport("smtp");

				if (validar == 0) {
					t.connect(usuario, password);
				} else {
					t.connect();
				}
				t.sendMessage(message, message.getAllRecipients());
			} catch (MessagingException mex) {
				if (detalle) {
					mex.printStackTrace();
					System.out.println();
					Exception ex = mex;
					do {
						if (ex instanceof SendFailedException) {
							SendFailedException sfex = (SendFailedException) ex;
							Address[] invalid = sfex.getInvalidAddresses();
							if (invalid != null) {
								System.out.println(" ** Invalid Addresses");
								if (invalid != null) {
									for (int i = 0; i < invalid.length; i++)
										System.out.println(" " + invalid[i]);
								}
							}
							Address[] validUnsent = sfex.getValidUnsentAddresses();
							if (validUnsent != null) {
								System.out.println(" ** ValidUnsent Addresses");
								if (validUnsent != null) {
									for (int i = 0; i < validUnsent.length; i++)
										System.out.println(" " + validUnsent[i]);
								}
							}
							Address[] validSent = sfex.getValidSentAddresses();
							if (validSent != null) {
								System.out.println(" ** ValidSent Addresses");
								if (validSent != null) {
									for (int i = 0; i < validSent.length; i++)
										System.out.println(" " + validSent[i]);
								}
							}
						}
						// System.out.println();
						if (ex instanceof MessagingException)
							ex = ((MessagingException) ex).getNextException();
						else
							ex = null;
					} while (ex != null);
				}
			} finally {
				try {
					if (t != null)
						t.close();
				} catch (MessagingException mex) { /* ignore */
				}
			}
		}

	}

	
	@Async
	public void sendEmail(List<String> recipients, List<String> recipientsCC, List<String> recipientsCCO, String sub, String msg) {

		if (recipients == null) {
			String errMsg = "Could not send email: smtp host address is null";
			logger.error(errMsg);
			return;
		}

		Properties propertieAlarma = PropertiesMg.getAlarmaProperties();
		int validar = 0;
		try {
			validar = Integer.parseInt(propertieAlarma.getProperty("VALIDAR", "0"));
		} catch (Exception e) {
		}

		boolean debug = false;
		try {
			debug = Boolean.parseBoolean(propertieAlarma.getProperty("DEBUG", "false"));
		} catch (Exception e) {
		}

		String fromEmail = propertieAlarma.getProperty("userSMTP");
//		System.out.println("fromEmail: "+fromEmail);
		Integer serverPort = Integer.parseInt(propertieAlarma.getProperty("puertoSMTP"));
//		System.out.println("serverPort: "+serverPort);
		String serverName = propertieAlarma.getProperty("servidorSMTP");
//		System.out.println("serverName: "+serverName);
		String userName = propertieAlarma.getProperty("userSMTP");
//		System.out.println("userName: "+userName);
		String password = propertieAlarma.getProperty("passSMTP");
//		System.out.println("password: "+password);

		SendEmailUtil sendEmailUtil = new SendEmailUtil(serverName, serverPort, fromEmail, userName, password);
		sendEmailUtil.setDebug(debug);

		//sendEmailUtil.setUseSsl(false);
		if (validar > 1)
			sendEmailUtil.setUseSsl(true);
		else if (validar > 0)
			sendEmailUtil.setUseTls(true);
//			sendEmailUtil.setUseSsl(true);

		for (Iterator<String> it = recipients.iterator(); it.hasNext();) {
			String email = (String) it.next();
			sendEmailUtil.sendEmail(email, null, null, sub, msg, null);
		}

		if (recipientsCC != null && recipientsCC.size() > 0) {
			for (Iterator<String> it = recipientsCC.iterator(); it.hasNext();) {
				String email = (String) it.next();
				sendEmailUtil.sendEmail(email, null, null, sub, msg, null);
			}
		}

		if (recipientsCCO != null && recipientsCCO.size() > 0) {
			for (Iterator<String> it = recipientsCCO.iterator(); it.hasNext();) {
				String email = (String) it.next();
				sendEmailUtil.sendEmail(email, null, null, sub, msg, null);
			}
		}
	}


	public void sendEmailF(List<String> recipients, List<String> recipientsCC, List<String> recipientsCCO, String sub, String msg, File archivo) {

		if (recipients == null) {
			String errMsg = "Could not send email: smtp host address is null";
			logger.error(errMsg);
			return;
		}

		Properties propertieAlarma = PropertiesMg.getAlarmaProperties();
		int validar = 0;
		try {
			validar = Integer.parseInt(propertieAlarma.getProperty("VALIDAR", "0"));
		} catch (Exception e) {
		}

		boolean debug = false;
		try {
			debug = Boolean.parseBoolean(propertieAlarma.getProperty("DEBUG", "false"));
		} catch (Exception e) {
		}

		String fromEmail = propertieAlarma.getProperty("userSMTP");
		Integer serverPort = Integer.parseInt(propertieAlarma.getProperty("puertoSMTP"));
		String serverName = propertieAlarma.getProperty("servidorSMTP");
		String userName = propertieAlarma.getProperty("userSMTP");
		String password = propertieAlarma.getProperty("passSMTP");

		SendEmailUtil sendEmailUtil = new SendEmailUtil(serverName, serverPort, fromEmail, userName, password);
		sendEmailUtil.setDebug(debug);

		if (validar > 1)
			sendEmailUtil.setUseSsl(true);
		else if (validar > 0)
			sendEmailUtil.setUseTls(true);

		for (Iterator<String> it = recipients.iterator(); it.hasNext();) {
			String email = (String) it.next();
			sendEmailUtil.sendEmail(email, null, null, sub, msg, archivo.getAbsolutePath());
		}

		if (recipientsCC != null && recipientsCC.size() > 0) {
			for (Iterator<String> it = recipientsCC.iterator(); it.hasNext();) {
				String email = (String) it.next();
				sendEmailUtil.sendEmail(email, null, null, sub, msg, archivo.getAbsolutePath());
			}
		}

		if (recipientsCCO != null && recipientsCCO.size() > 0) {
			for (Iterator<String> it = recipientsCCO.iterator(); it.hasNext();) {
				String email = (String) it.next();
				sendEmailUtil.sendEmail(email, null, null, sub, msg, archivo.getAbsolutePath());
			}
		}
	}
	
	public void sendEmail(String receiverAddress, String sub, String msg) throws Exception {
		List<String> recipients = new ArrayList<String>();
		if (receiverAddress.indexOf(';') > 0) {
			StringTokenizer stk = new StringTokenizer(receiverAddress, ";");
			while (stk.hasMoreTokens()) {
				String recipiente = stk.nextToken();
				recipients.add(recipiente);
			}
		} else {
			recipients.add(receiverAddress);
		}
		sendEmail(recipients, null, null, sub, msg);
	}

}
//JPUYEN 17062024 - FIN CLASE