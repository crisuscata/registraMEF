package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsRolesBk;

/**
 * MS_ROLES SERVICIO VALIDACIÓN: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsRolesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsRolesMng.class.getName());
	
	public static void validarMsRolesBk(MsRolesBk msRolesBk)
	 throws Validador
	{
                //FORANEAS
                
		//VALIDANDO
		
		validarUsername(msRolesBk.getUsername());
		if(msRolesBk.getUsername()!=null){
				if(msRolesBk.getUsername().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msRoles.noexceder"),
							Messages.getStringToKey("msRoles.username"),
							Messages.getStringToKey("msRoles.titulotabla"),
							50,
							Messages.getStringToKey("msRoles.articuloUsername")
									));				
//				msRolesBk.setUsername(msRolesBk.getUsername().toUpperCase());
				}

		
		//validarRol(msRolesBk.getRol());
		if(msRolesBk.getRol()!=null){
				if(msRolesBk.getRol().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msRoles.noexceder"),
							Messages.getStringToKey("msRoles.rol"),
							Messages.getStringToKey("msRoles.titulotabla"),
							100,
							Messages.getStringToKey("msRoles.articuloRol")
									));				
//				msRolesBk.setRol(msRolesBk.getRol().toUpperCase());
				}

		
		
		
		
		
		
		
				
	}

	public static void validarUsername(String username)
	 throws Validador
	{					
			if(username==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msRoles.ingrese"),
			Messages.getStringToKey("msRoles.username"),
			Messages.getStringToKey("msRoles.titulotabla"),
			Messages.getStringToKey("msRoles.articuloUsername")));
			if(username.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msRoles.invalidoingrese"),
			Messages.getStringToKey("msRoles.username"),
			Messages.getStringToKey("msRoles.titulotabla")));						
			if(username!=null){
				if(username.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msRoles.noexceder"),
			Messages.getStringToKey("msRoles.username"),
			Messages.getStringToKey("msRoles.titulotabla"),50,
			Messages.getStringToKey("msRoles.articuloUsername")));
				}
	}
	
	public static void validarRol(String rol)
	 throws Validador
	{					
			if(rol==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msRoles.ingrese"),
			Messages.getStringToKey("msRoles.rol"),
			Messages.getStringToKey("msRoles.titulotabla"),
			Messages.getStringToKey("msRoles.articuloRol")));
			if(rol.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msRoles.invalidoingrese"),
			Messages.getStringToKey("msRoles.rol"),
			Messages.getStringToKey("msRoles.titulotabla")));						
			if(rol!=null){
				if(rol.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msRoles.noexceder"),
			Messages.getStringToKey("msRoles.rol"),
			Messages.getStringToKey("msRoles.titulotabla"),100,
			Messages.getStringToKey("msRoles.articuloRol")));
				}
	}
	
	
	
	
	
	
	
		
}