package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsSubtemaBk;

/**
 * MS_SUBTEMA SERVICIO VALIDACIÓN: ALMACENA LOS SUBTEMAS REGISTRADOS EN EL SISTEMA "SUBTEMAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsSubtemaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsSubtemaMng.class.getName());
	
	public static void validarMsSubtemaBk(MsSubtemaBk msSubtemaBk)
	 throws Validador
	{
                //FORANEAS
                if(msSubtemaBk.getIdTema()!=null && msSubtemaBk.getIdTema().longValue()<=0){
			msSubtemaBk.setIdTema(null);
		}
	        if(msSubtemaBk.getEstado()!=null && msSubtemaBk.getEstado().longValue()<=0){
			msSubtemaBk.setEstado(null);
		}
	        if(msSubtemaBk.getIdIndicador()!=null && msSubtemaBk.getIdIndicador().longValue()<=0){
			msSubtemaBk.setIdIndicador(null);
		}
	        
		//VALIDANDO
		
		//validarDescripcion(msSubtemaBk.getDescripcion());
		if(msSubtemaBk.getDescripcion()!=null){
				if(msSubtemaBk.getDescripcion().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msSubtema.noexceder"),
							Messages.getStringToKey("msSubtema.descripcion"),
							Messages.getStringToKey("msSubtema.titulotabla"),
							200,
							Messages.getStringToKey("msSubtema.articuloDescripcion")
							));				
//				msSubtemaBk.setDescripcion(msSubtemaBk.getDescripcion().toUpperCase());
				}

		
		
		
		
		//validarIdTema(msSubtemaBk.getIdTema());

		
		//validarIdIndicador(msSubtemaBk.getIdIndicador());

		
		
				
	}

	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSubtema.ingrese"),
			Messages.getStringToKey("msSubtema.descripcion"),
			Messages.getStringToKey("msSubtema.titulotabla"),
			Messages.getStringToKey("msSubtema.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSubtema.invalidoingrese"),
			Messages.getStringToKey("msSubtema.descripcion"),
			Messages.getStringToKey("msSubtema.titulotabla"),
			Messages.getStringToKey("msSubtema.articuloDescripcion")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msSubtema.noexceder"),
			Messages.getStringToKey("msSubtema.descripcion"),
			Messages.getStringToKey("msSubtema.titulotabla"),200,
			Messages.getStringToKey("msSubtema.articuloDescripcion")));
				}
	}
	
	
	
	
	public static void validarIdTema(Long idTema)
			 throws Validador
				{				
								if(idTema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSubtema.invalidoingrese"),
						Messages.getStringToKey("msSubtema.idTema"),
						Messages.getStringToKey("msSubtema.titulotabla"),
						Messages.getStringToKey("msSubtema.articuloIdTema")));
					}
	
	
	public static void validarIdIndicador(Long idIndicador)
			 throws Validador
				{				
								if(idIndicador==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSubtema.invalidoingrese"),
						Messages.getStringToKey("msSubtema.idIndicador"),
						Messages.getStringToKey("msSubtema.titulotabla"),
						Messages.getStringToKey("msSubtema.articuloIdIndicador")));
					}
	
	
	
		
}