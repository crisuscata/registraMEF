package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.PrtParametrosBk;

/**
 * PRT_PARAMETROS SERVICIO VALIDACIÓN: ALMACENA LOS PARAMETROS REGISTRADOS EN EL SISTEMA "PARÁMETROS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionPrtParametrosMng implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6209072385882652740L;
	public static final Logger log = Logger.getLogger(ValidacionPrtParametrosMng.class.getName());
	
	public static void validarPrtParametrosBk(PrtParametrosBk prtParametrosBk)
	 throws Validador
	{
		 //PURIBE 25012024 - INICIO
        //FORANEAS
      //  if(prtParametrosBk.getIdpadre()!=null && prtParametrosBk.getIdpadre().longValue()<=0){
//	prtParametrosBk.setIdpadre(null);
	
//}
        //PURIBE 25012024 - FIN
	        if(prtParametrosBk.getEstado()!=null && prtParametrosBk.getEstado().longValue()<=0){
			prtParametrosBk.setEstado(null);
		}
	        
		//VALIDANDO
		//validarIdpadre(prtParametrosBk.getIdpadre());

		
		//validarDescripcion(prtParametrosBk.getDescripcion());
		if(prtParametrosBk.getDescripcion()!=null){
				if(prtParametrosBk.getDescripcion().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("prtParametros.noexceder"),
							Messages.getStringToKey("prtParametros.descripcion"),
							Messages.getStringToKey("prtParametros.titulotabla"),
							100,
							Messages.getStringToKey("prtParametros.articuloDescripcion")
									));				
//				prtParametrosBk.setDescripcion(prtParametrosBk.getDescripcion().toUpperCase());
				}

		//validarEstado(prtParametrosBk.getEstado());

		
		
		
		
		
		
				
	}
public static void validarIdpadre(Long idpadre)
			 throws Validador
				{				
								if(idpadre==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("prtParametros.invalidoingrese"),
						Messages.getStringToKey("prtParametros.idpadre"),
						Messages.getStringToKey("prtParametros.titulotabla"),
						Messages.getStringToKey("prtParametros.articuloIdpadre")));
					}
	
	
	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("prtParametros.ingrese"),
			Messages.getStringToKey("prtParametros.descripcion"),
			Messages.getStringToKey("prtParametros.titulotabla"),
			Messages.getStringToKey("prtParametros.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("prtParametros.invalidoingrese"),
			Messages.getStringToKey("prtParametros.descripcion"),
			Messages.getStringToKey("prtParametros.titulotabla")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("prtParametros.noexceder"),
			Messages.getStringToKey("prtParametros.descripcion"),
			Messages.getStringToKey("prtParametros.titulotabla"),100,
			Messages.getStringToKey("prtParametros.articuloDescripcion")));
				}
	}
	
	public static void validarEstado(Integer estado)
	 throws Validador
	{				
					if(estado==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("prtParametros.seleccione"),
			Messages.getStringToKey("prtParametros.estado"),
			Messages.getStringToKey("prtParametros.titulotabla"),
			Messages.getStringToKey("prtParametros.articuloEstado")));
			if(estado.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("prtParametros.invalidoseleccione"),
			Messages.getStringToKey("prtParametros.estado"),
			Messages.getStringToKey("prtParametros.titulotabla"),
			Messages.getStringToKey("prtParametros.articuloEstado")));			
	}
	
	
	
	
	
	
		
}