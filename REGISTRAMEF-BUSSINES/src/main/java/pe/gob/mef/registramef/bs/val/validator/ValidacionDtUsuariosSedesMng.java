package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuariosSedesBk;

/**
 * DT_USUARIOS_SEDES SERVICIO VALIDACIÓN: ALMACENA A LAS SEDES A LAS QUE PUEDEN PERTENECER LOS USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtUsuariosSedesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtUsuariosSedesMng.class.getName());
	
	public static void validarDtUsuariosSedesBk(DtUsuariosSedesBk dtUsuariosSedesBk)
	 throws Validador
	{
                //FORANEAS
                if(dtUsuariosSedesBk.getIdSede()!=null && dtUsuariosSedesBk.getIdSede().longValue()<=0){
			dtUsuariosSedesBk.setIdSede(null);
		}
	        if(dtUsuariosSedesBk.getIdusuario()!=null && dtUsuariosSedesBk.getIdusuario().longValue()<=0){
			dtUsuariosSedesBk.setIdusuario(null);
		}
	        if(dtUsuariosSedesBk.getEstado()!=null && dtUsuariosSedesBk.getEstado().longValue()<=0){
			dtUsuariosSedesBk.setEstado(null);
		}
	        
		//VALIDANDO
		validarIdSede(dtUsuariosSedesBk.getIdSede());

		validarIdusuario(dtUsuariosSedesBk.getIdusuario());

		
		
		
		
		
		
		
				
	}

	public static void validarIdSede(Long idSede)
	 throws Validador
	{				
					if(idSede==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuariosSedes.seleccione"),
			Messages.getStringToKey("dtUsuariosSedes.idSede"),
			Messages.getStringToKey("dtUsuariosSedes.titulotabla"),
			Messages.getStringToKey("dtUsuariosSedes.articuloIdSede")));
			if(idSede.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuariosSedes.invalidoseleccione"),
			Messages.getStringToKey("dtUsuariosSedes.idSede"),
			Messages.getStringToKey("dtUsuariosSedes.titulotabla"),
			Messages.getStringToKey("dtUsuariosSedes.articuloIdSede")));			
	}
	
	public static void validarIdusuario(Long idusuario)
	 throws Validador
	{				
					if(idusuario==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuariosSedes.seleccione"),
			Messages.getStringToKey("dtUsuariosSedes.idusuario"),
			Messages.getStringToKey("dtUsuariosSedes.titulotabla"),
			Messages.getStringToKey("dtUsuariosSedes.articuloIdusuario")));
			if(idusuario.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuariosSedes.invalidoseleccione"),
			Messages.getStringToKey("dtUsuariosSedes.idusuario"),
			Messages.getStringToKey("dtUsuariosSedes.titulotabla"),
			Messages.getStringToKey("dtUsuariosSedes.articuloIdusuario")));			
	}
	
	
	
	
	
	
	
		
}