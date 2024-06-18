package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;

/**
 * MS_USUARIOS SERVICIO VALIDACIÓN: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS INTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsUsuariosMng implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7971062061867078981L;
	public static final Logger log = Logger.getLogger(ValidacionMsUsuariosMng.class.getName());
	
	public static void validarMsUsuariosBk(MsUsuariosBk msUsuariosBk, boolean solocontrasenia)
	 throws Validador
	{
                //FORANEAS
                if(msUsuariosBk.getEstado()!=null && msUsuariosBk.getEstado().longValue()<=0){
			msUsuariosBk.setEstado(null);
		}
	        if(msUsuariosBk.getIdCargo()!=null && msUsuariosBk.getIdCargo().longValue()<=0){
			msUsuariosBk.setIdCargo(null);
		}
	        if(msUsuariosBk.getCodDpto()!=null && msUsuariosBk.getCodDpto().longValue()<=0){
			msUsuariosBk.setCodDpto(null);
		}
	        if(msUsuariosBk.getCodProv()!=null && msUsuariosBk.getCodProv().longValue()<=0){
			msUsuariosBk.setCodProv(null);
		}
	        if(msUsuariosBk.getCodDistr()!=null && msUsuariosBk.getCodDistr().longValue()<=0){
			msUsuariosBk.setCodDistr(null);
		}
	        if(msUsuariosBk.getIdpais()!=null && msUsuariosBk.getIdpais().longValue()<=0){
			msUsuariosBk.setIdpais(null);
		}
	        if(msUsuariosBk.getIdSistAdmi()!=null && msUsuariosBk.getIdSistAdmi().longValue()<=0){
			msUsuariosBk.setIdSistAdmi(null);
		}
	        if(msUsuariosBk.getIdSede()!=null && msUsuariosBk.getIdSede().longValue()<=0){
			msUsuariosBk.setIdSede(null);
		}
	        if(msUsuariosBk.getIdCondlabr()!=null && msUsuariosBk.getIdCondlabr().longValue()<=0){
			msUsuariosBk.setIdCondlabr(null);
		}
	        
		//VALIDANDO
	        if(!solocontrasenia){
		
	        	validarDni(msUsuariosBk.getDni());

	        	
	    		validarUsername(msUsuariosBk.getUsername());
	    		if(msUsuariosBk.getUsername()!=null){
	    				if(msUsuariosBk.getUsername().trim().length()>50)
	    					throw new Validador(MessageFormat.format(
	    							Messages.getStringToKey("msUsuarios.noexceder"),
	    							Messages.getStringToKey("msUsuarios.username"),
	    							Messages.getStringToKey("msUsuarios.titulotabla"),
	    							50,
	    							Messages.getStringToKey("msUsuarios.articuloUsername")
	    									));				
//	    				msUsuariosBk.setUsername(msUsuariosBk.getUsername().toUpperCase());
	    				}
	    		
	    		
		validarNombres(msUsuariosBk.getNombres());
		if(msUsuariosBk.getNombres()!=null){
				if(msUsuariosBk.getNombres().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUsuarios.noexceder"),
							Messages.getStringToKey("msUsuarios.nombres"),
							Messages.getStringToKey("msUsuarios.titulotabla"),
							100,
							Messages.getStringToKey("msUsuarios.articuloNombres")
									));				
//				msUsuariosBk.setNombres(msUsuariosBk.getNombres().toUpperCase());
				}

		
		validarApellidoPaterno(msUsuariosBk.getApellidoPaterno());
		if(msUsuariosBk.getApellidoPaterno()!=null){
				if(msUsuariosBk.getApellidoPaterno().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUsuarios.noexceder"),
							Messages.getStringToKey("msUsuarios.apellidoPaterno"),
							Messages.getStringToKey("msUsuarios.titulotabla"),
							100,
							Messages.getStringToKey("msUsuarios.articuloApellidoPaterno")
									));				
//				msUsuariosBk.setApellidoPaterno(msUsuariosBk.getApellidoPaterno().toUpperCase());
				}

		
//		validarApellidoMaterno(msUsuariosBk.getApellidoMaterno());
		if(msUsuariosBk.getApellidoMaterno()!=null){
				if(msUsuariosBk.getApellidoMaterno().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUsuarios.noexceder"),
							Messages.getStringToKey("msUsuarios.apellidoMaterno"),
							Messages.getStringToKey("msUsuarios.titulotabla"),
							100,
							Messages.getStringToKey("msUsuarios.articuloApellidoMaterno")
									));				
//				msUsuariosBk.setApellidoMaterno(msUsuariosBk.getApellidoMaterno().toUpperCase());
				}
		
		//validarProfesion(msUsuariosBk.getProfesion());
		if(msUsuariosBk.getProfesion()!=null){
				if(msUsuariosBk.getProfesion().trim().length()>130)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUsuarios.noexceder"),
							Messages.getStringToKey("msUsuarios.profesion"),
							Messages.getStringToKey("msUsuarios.titulotabla"),
							130,
							Messages.getStringToKey("msUsuarios.articuloProfesion")
									));				
//				msUsuariosBk.setProfesion(msUsuariosBk.getProfesion().toUpperCase());
				}

		
		validarCorreo(msUsuariosBk.getCorreo());
		if(msUsuariosBk.getCorreo()!=null){
				if(msUsuariosBk.getCorreo().trim().length()>30)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUsuarios.noexceder"),
							Messages.getStringToKey("msUsuarios.correo"),
							Messages.getStringToKey("msUsuarios.titulotabla"),
							30,
							Messages.getStringToKey("msUsuarios.articuloCorreo")
									));				
//				msUsuariosBk.setCorreo(msUsuariosBk.getCorreo().toUpperCase());
				}

		//validarTelefono(msUsuariosBk.getTelefono());
		
		validarFechaInic(msUsuariosBk.getFechaInic());

//		validarFechaCese(msUsuariosBk.getFechaCese());
		
		//validarDireccion(msUsuariosBk.getDireccion());
		if(msUsuariosBk.getDireccion()!=null){
				if(msUsuariosBk.getDireccion().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUsuarios.noexceder"),
							Messages.getStringToKey("msUsuarios.direccion"),
							Messages.getStringToKey("msUsuarios.titulotabla"),
							200,
							Messages.getStringToKey("msUsuarios.articuloDireccion")
									));				
//				msUsuariosBk.setDireccion(msUsuariosBk.getDireccion().toUpperCase());
				}
		
		validarIdCargo(msUsuariosBk.getIdCargo());

		//validarCodDpto(msUsuariosBk.getCodDpto());

		//validarCodProv(msUsuariosBk.getCodProv());

		//validarCodDistr(msUsuariosBk.getCodDistr());

		//validarIdpais(msUsuariosBk.getIdpais());

		validarIdSistAdmi(msUsuariosBk.getIdSistAdmi());

		validarIdSede(msUsuariosBk.getIdSede());

		validarIdCondlabr(msUsuariosBk.getIdCondlabr());
	  }

	        boolean validarcontrasenia = false;
			if (msUsuariosBk.getIdusuario() == null) {
				validarcontrasenia = true;
			} else if (msUsuariosBk.getIdusuario().longValue() <= 0) {
				validarcontrasenia = true;
			} else if (msUsuariosBk.getContrasenia() != null && msUsuariosBk.getContrasenia().length() > 0) {
				validarcontrasenia = true;
			}

			if (validarcontrasenia) {
				validarContrasenia(msUsuariosBk.getContrasenia());
				if (msUsuariosBk.getContrasenia() != null) {
					if (msUsuariosBk.getContrasenia().trim().length() > 50)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("MsUsuarios.noexceder"),
								Messages.getStringToKey("MsUsuarios.contrasenia"),
								Messages.getStringToKey("MsUsuarios.titulotabla"), 50));
					// msUsuariosBk.setContrasenia(msUsuariosBk.getContrasenia().toUpperCase());
				}

				/***
				 * ((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16}) (?=.*[a-z]) : This matches the presence of at least
				 * one lowercase letter. (?=.*d) : This matches the presence of at least one digit i.e. 0-9. (?=.*[@#$%]) :
				 * This matches the presence of at least one special character. ((?=.*[A-Z]) : This matches the presence of
				 * at least one capital letter. {6,16} : This limits the length of password from minimum 6 letters to
				 * maximum 16 letters.
				 */

				if (msUsuariosBk.getContrasenia().trim().length() <= 5) {
					throw new Validador(Messages.getStringToKey("MsUsuariosRegistro.contrasenia_6_caracteres"));
				}
				if (msUsuariosBk.getContraseniaConfir() == null) {
					throw new Validador(Messages.getStringToKey("MsUsuariosRegistro.contrasenia_debe_reingresar"));
				} else if (msUsuariosBk.getContraseniaConfir().trim().length() <= 5) {
					throw new Validador(Messages.getStringToKey("MsUsuariosRegistro.contrasenia_reingrese"));
				} else if (!msUsuariosBk.getContraseniaConfir().equals(msUsuariosBk.getContrasenia())) {
					throw new Validador(Messages.getStringToKey("MsUsuariosRegistro.contrasenia_no_coincide"));
				}

				String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,50})"; // "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,100})"
				Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
				Matcher matcher = pattern.matcher(msUsuariosBk.getContrasenia());
				boolean resultado = matcher.matches();
				if (!resultado) {
					throw new Validador(
							"LA CONTRASEÑA DEBE AL MENOS CONTENER UN DÍGITO DE 0-9,  DEBE CONTENER AL MENOS UNA LETRA EN MINÚSCULA, DEBE CONTENER AL MENOS UNA LETRA MAYÚSCULA Y DEBE TENER UNA LONGITUD DE AL MENOS 6 CARACTERES Y MÁXIMO DE 50 CARACTERES."); 
					// DEBE CONTENER $%\"
				}
			}				
	}

	public static void validarDni(Long dni)
	 throws Validador
	{				
					if(dni==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.seleccione"),
			Messages.getStringToKey("msUsuarios.dni"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloDni")));
			if(dni.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoseleccione"),
			Messages.getStringToKey("msUsuarios.dni"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloDni")));			
	}
	
	public static void validarNombres(String nombres)
	 throws Validador
	{					
			if(nombres==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.nombres"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloNombres")));
			if(nombres.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.nombres"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(nombres!=null){
				if(nombres.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.nombres"),
			Messages.getStringToKey("msUsuarios.titulotabla"),100,
			Messages.getStringToKey("msUsuarios.articuloNombres")));
				}
	}
	
	public static void validarApellidoPaterno(String apellidoPaterno)
	 throws Validador
	{					
			if(apellidoPaterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.apellidoPaterno"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloApellidoPaterno")));
			if(apellidoPaterno.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.apellidoPaterno"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(apellidoPaterno!=null){
				if(apellidoPaterno.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.apellidoPaterno"),
			Messages.getStringToKey("msUsuarios.titulotabla"),100,
			Messages.getStringToKey("msUsuarios.articuloApellidoPaterno")));
				}
	}
	
	public static void validarApellidoMaterno(String apellidoMaterno)
	 throws Validador
	{					
			if(apellidoMaterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.apellidoMaterno"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloApellidoMaterno")));
			if(apellidoMaterno.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.apellidoMaterno"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(apellidoMaterno!=null){
				if(apellidoMaterno.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.apellidoMaterno"),
			Messages.getStringToKey("msUsuarios.titulotabla"),100,
			Messages.getStringToKey("msUsuarios.articuloApellidoMaterno")));
				}
	}
	public static void validarContrasenia(String contrasenia)
			 throws Validador
				{				
								if(contrasenia==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.contrasenia"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloContrasenia")));
					}
	
	
	public static void validarProfesion(String profesion)
	 throws Validador
	{					
			if(profesion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.profesion"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloProfesion")));
			if(profesion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.profesion"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(profesion!=null){
				if(profesion.trim().length()>130)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.profesion"),
			Messages.getStringToKey("msUsuarios.titulotabla"),130,
			Messages.getStringToKey("msUsuarios.articuloProfesion")));
				}
	}
	
	public static void validarCorreo(String correo)
	 throws Validador
	{					
			if(correo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.correo"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloCorreo")));
			if(correo.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.correo"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(correo!=null){
				if(correo.trim().length()>30)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.correo"),
			Messages.getStringToKey("msUsuarios.titulotabla"),30,
			Messages.getStringToKey("msUsuarios.articuloCorreo")));
				}
	}
	
	public static void validarTelefono(Long telefono)
	 throws Validador
	{				
					if(telefono==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.seleccione"),
			Messages.getStringToKey("msUsuarios.telefono"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloTelefono")));
			if(telefono.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoseleccione"),
			Messages.getStringToKey("msUsuarios.telefono"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloTelefono")));			
	}
	
	
	
	public static void validarFechaInic(Timestamp fechaInic)
	 throws Validador
	{				
					if(fechaInic==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.fechaInic"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloFechaInic")));
		}
	
	public static void validarFechaCese(Timestamp fechaCese)
	 throws Validador
	{				
					if(fechaCese==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.fechaCese"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloFechaCese")));
		}
	
	
	
	public static void validarDireccion(String direccion)
	 throws Validador
	{					
			if(direccion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.direccion"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloDireccion")));
			if(direccion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.direccion"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(direccion!=null){
				if(direccion.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.direccion"),
			Messages.getStringToKey("msUsuarios.titulotabla"),200,
			Messages.getStringToKey("msUsuarios.articuloDireccion")));
				}
	}
	
	public static void validarUsername(String username)
	 throws Validador
	{					
			if(username==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.ingrese"),
			Messages.getStringToKey("msUsuarios.username"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloUsername")));
			if(username.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
			Messages.getStringToKey("msUsuarios.username"),
			Messages.getStringToKey("msUsuarios.titulotabla")));						
			if(username!=null){
				if(username.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.noexceder"),
			Messages.getStringToKey("msUsuarios.username"),
			Messages.getStringToKey("msUsuarios.titulotabla"),50,
			Messages.getStringToKey("msUsuarios.articuloUsername")));
				}
	}
	
	public static void validarIdCargo(Long idCargo)
			 throws Validador
				{				
								if(idCargo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.idCargo"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloIdCargo")));
					}
	
	public static void validarCodDpto(Integer codDpto)
			 throws Validador
				{				
								if(codDpto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.codDpto"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloCodDpto")));
					}
	
	public static void validarCodProv(Integer codProv)
			 throws Validador
				{				
								if(codProv==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.codProv"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloCodProv")));
					}
	
	public static void validarCodDistr(Integer codDistr)
			 throws Validador
				{				
								if(codDistr==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.codDistr"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloCodDistr")));
					}
	
	
	public static void validarIdpais(Long idpais)
	 throws Validador
	{				
					if(idpais==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.seleccione"),
			Messages.getStringToKey("msUsuarios.idpais"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloIdpais")));
			if(idpais.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoseleccione"),
			Messages.getStringToKey("msUsuarios.idpais"),
			Messages.getStringToKey("msUsuarios.titulotabla"),
			Messages.getStringToKey("msUsuarios.articuloIdpais")));			
	}
	public static void validarIdSistAdmi(Long idSistAdmi)
			 throws Validador
				{				
								if(idSistAdmi==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.idSistAdmi"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloIdSistAdmi")));
					}
	
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.idSede"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloIdSede")));
					}
	
	public static void validarIdCondlabr(Long idCondlabr)
			 throws Validador
				{				
								if(idCondlabr==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUsuarios.invalidoingrese"),
						Messages.getStringToKey("msUsuarios.idCondlabr"),
						Messages.getStringToKey("msUsuarios.titulotabla"),
						Messages.getStringToKey("msUsuarios.articuloIdCondlabr")));
					}
	
	
	
		
}