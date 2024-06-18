package pe.gob.mef.web.security;

import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.servlet.handlers.ServletRequestContext;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import io.undertow.servlet.spec.HttpServletResponseImpl;
import io.undertow.servlet.spec.HttpSessionImpl;
import io.undertow.servlet.spec.ServletContextImpl;
import io.undertow.util.HttpString;

public class CandadoFixation implements HttpHandler {

	private HttpHandler next = null;

	public CandadoFixation(HttpHandler next) {
		this.next = next;
	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		// 1.) Only check requests to 'j_security_check'
		// 2.) Get current session
		// 3.) Copy session keys
		// 4.) Copy session notes
		// 5.) Destroy session
		// 6.) Create new session
		// 7.) Add old session keys
		// Log log = container.getLogger();

		if (exchange.getRequestURI().endsWith("j_security_check")) {
			final ServletRequestContext sc = exchange.getAttachment(ServletRequestContext.ATTACHMENT_KEY);
			ServletContextImpl currentServletContext = sc.getCurrentServletContext();
			HttpSessionImpl session = currentServletContext.getSession(exchange, false);
			if (session != null) {
				Map<String, Object> old_attribs = new HashMap<String, Object>();
//				Map<String, Object> old_notes = new HashMap<String, Object>();

				String captcha = null;
				Integer intentos = null;
				
				final HttpServletResponseImpl response = new HttpServletResponseImpl(exchange, currentServletContext);
		        final HttpServletRequestImpl request = new HttpServletRequestImpl(exchange, currentServletContext);
		        
		        String nombre = request.getParameter("j_username");			
				String captchavalor = request.getParameter("j_captcha");		
						
				Enumeration<String> names = session.getAttributeNames();
				while (names.hasMoreElements()) {
					Object o = names.nextElement();
					if (o instanceof java.lang.String) {
						String name = (String) o;
						old_attribs.put(name, session.getAttribute(name));
						// System.out.println("ATRIBUTO: " + name);
						if (name != null && name.equals("info_captcha")) {
							captcha = (String) session.getAttribute(name);
							// log.info("ATRIBUTO1VERS1: ");
						} else if (name != null && name.equals("j_intentos")) {
							intentos = (Integer) session.getAttribute(name);
						}
					}
				}
				
//				String valoresnames[] = session.getValueNames();
//				for (String name : valoresnames) {
//					Object o = session.getValue(name);
//					old_notes.put(name, o);
//				}
//
//				session.invalidate();
//				session = currentServletContext.getSession(exchange, true);
//
//				// Restore HTTP session data
//				for (String name : old_attribs.keySet()) {
//					session.setAttribute(name, old_attribs.get(name));
//				}
//
//				for (String name : old_notes.keySet()) {
//					session.putValue(name, old_notes.get(name));
//				}
//				
//				// log.info("ATRIBUTO2: ");
//				if (intentos == null) {
//					// System.out.println("INTENTOS NULO");
//					session.setAttribute("j_intentos", 0);
//				}

				// System.out.println("Captchavalor 2: "+captchavalor+" j_username "+nombre+" captcha "+captcha);

				if (captcha != null) {
					// System.out.println("Captchavalor 3: "+captchavalor+" j_username "+nombre);
					if (captchavalor == null || captchavalor.trim().length() <= 0) {
						session.setAttribute("ERROR", "INGRESE EL VALOR QUE SE MUESTRA EN LA IMAGEN");
						if(intentos==null){
							intentos=0;
						}
						session.setAttribute("j_intentos", new Integer((intentos.intValue() + 1)));

						String errorpg = currentServletContext.getContextPath() + "/";
						exchange.setStatusCode(301);
						exchange.getResponseHeaders().add(new HttpString("Location"), response.encodeRedirectURL(errorpg));
						return;
					} else if (!captchavalor.equals(captcha)) {
						// System.out.println("Captchavalor 4: "+captchavalor+" j_username "+nombre);
						// System.out.println("ERROR:--> "+captchavalor+"<>"+captcha);
						// session.getSession().invalidate();
						// session = request.getSessionInternal(true);
						session.setAttribute("ERROR", "NO HA INGRESADO EL VALOR CORRECTO DE LA IMAGEN");
						// System.out.println("INTENTO: "+nombre+" -> "+(intentos.intValue()+1));
						session.setAttribute("j_intentos", new Integer((intentos.intValue() + 1)));
						String errorpg = currentServletContext.getContextPath() + "/";
						exchange.setStatusCode(301);
						exchange.getResponseHeaders().add(new HttpString("Location"), response.encodeRedirectURL(errorpg));
						return;
					} else {
						// System.out.println("Captchavalor 5: "+captchavalor+" j_username "+nombre);
						session.removeAttribute("ERROR");
//						session.removeAttribute("j_intentos");
						intentos = null;
					}
				}
				if(intentos==null){
					intentos=0;
				}
				if (intentos != null) {
					System.out.println("INTENTO: " + nombre + " -> " + (intentos.intValue() + 1));
					session.setAttribute("j_intentos", new Integer((intentos.intValue() + 1)));
				}
			}
		}
		next.handleRequest(exchange);
	}

	public void handleRequestA(HttpServerExchange exchange) throws Exception {
		// 1.) Only check requests to 'j_security_check'
		// 2.) Get current session
		// 3.) Copy session keys
		// 4.) Copy session notes
		// 5.) Destroy session
		// 6.) Create new session
		// 7.) Add old session keys
		// Log log = container.getLogger();
		if (exchange.getRequestURI().endsWith("j_security_check")) {
			final ServletRequestContext sc = exchange.getAttachment(ServletRequestContext.ATTACHMENT_KEY);
			ServletContextImpl currentServletContext = sc.getCurrentServletContext();
			HttpSessionImpl session = currentServletContext.getSession(exchange, false);
			if (session != null) {
				Map<String, Object> old_attribs = new HashMap<String, Object>();
				// Map<String, Object> old_notes = new HashMap<String, Object>();

				String captcha = null;
				Integer intentos = null;
				// Save HTTP session data
				@SuppressWarnings("rawtypes")
				Enumeration names = session.getAttributeNames();
				while (names.hasMoreElements()) {
					Object o = names.nextElement();
					if (o instanceof java.lang.String) {
						String name = (String) o;
						old_attribs.put(name, session.getSession().getAttribute(name));
						// log.info("ATRIBUTO: " + name);
						if (name != null && name.equals("info_captcha")) {
							captcha = (String) session.getSession().getAttribute(name);
							// log.info("ATRIBUTO1VERS1: ");
						} else if (name != null && name.equals("j_intentos")) {
							intentos = (Integer) session.getSession().getAttribute(name);
						}
					}
				}
				// while (names. hasMoreElements()) {
				// Object o = names.nextElement();
				// //log.info("CLASE: " + o.getClass().getName());
				// if(o instanceof java.lang.String){
				// String name = (String) o;
				// old_attribs.put(name, session.getSession().getAttribute(name));
				//// log.info("ATRIBUTO: " + name);
				// if (name != null && name.equals("info_captcha")) {
				// captcha = (String) session.getSession().getAttribute(name);
				// //log.info("ATRIBUTO1VERS1: ");
				// }else if(name != null && name.equals("j_intentos")){
				// intentos = (Integer) session.getSession().getAttribute(name);
				// }
				// }
				// }

				// Save Tomcat internal session data
				// @SuppressWarnings("rawtypes")
				// Iterator it = session.getNoteNames();
				// while (it.hasNext()) {
				// String name = (String) it.next();
				// old_notes.put(name, session.getNote(name));
				//// log.info("NOTE: " + name);
				// }

				session.getSession().invalidate(exchange);
				session = currentServletContext.getSession(exchange, true);
				// session = request.getSessionInternal(true);

				// Restore HTTP session data
				for (String name : old_attribs.keySet()) {
					session.getSession().setAttribute(name, old_attribs.get(name));
				}

				// Restore Tomcat internal session data
				// for (String name : old_notes.keySet()) {
				// session.setNote(name, old_notes.get(name));
				// }

				// log.info("ATRIBUTO2: ");
				if (intentos != null) {
					System.out.println("INTENTOS: " + intentos.intValue());
				} else {
					System.out.println("INTENTOS NULO");
				}

				if (captcha != null) {
					// String captchavalor = request.getParameter("j_captcha");
					Deque<String> captchavalorPathDeque = exchange.getPathParameters().get("j_captcha");
					Deque<String> captchavalorQueryDeque = exchange.getQueryParameters().get("j_captcha");

					String captchavalor = captchavalorPathDeque == null
							? (captchavalorQueryDeque == null ? null : captchavalorQueryDeque.getFirst())
							: captchavalorPathDeque.getFirst();

					if (captchavalor == null) {
						System.out.println("CAPCHA NULO");
						session.getSession().invalidate(exchange);
						// session = request.getSessionInternal(true);
						session = currentServletContext.getSession(exchange, true);
						session.getSession().setAttribute("ERROR", "INGRESE EL VALOR QUE SE MUESTRA EN LA IMAGEN");

						String errorpg = currentServletContext.getContextPath() + "/";
						// String errorpg = request.getServletContext().getContextPath()+"/";

						exchange.setStatusCode(301);
						// response.setStatus(Response.SC_MOVED_PERMANENTLY);
						exchange.getResponseHeaders().add(new HttpString("Location"), errorpg);
						// response.setHeader("Location", response.encodeRedirectURL(errorpg));
						// response.sendRedirect("/error.jsp");
						return;
					} else if (!captchavalor.equals(captcha)) {
						session.getSession().invalidate(exchange);
						session = currentServletContext.getSession(exchange, true);
						// session = request.getSessionInternal(true);
						session.getSession().setAttribute("ERROR", "NO HA INGRESADO EL VALOR DE LA IMAGEN CORRECTO ");
						String errorpg = currentServletContext.getContextPath() + "/";
						// String errorpg = request.getServletContext().getContextPath()+"/";
						exchange.setStatusCode(301);
						// response.setStatus(Response.SC_MOVED_PERMANENTLY);
						exchange.getResponseHeaders().add(new HttpString("Location"), errorpg);
						// response.setHeader("Location", response.encodeRedirectURL(errorpg));
						return;
					}
				}
			} else {
				System.out.println("...SESSION NULA...");
			}
		}
		next.handleRequest(exchange);
	}

}
