package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaEntidadesBk;

/**
 * DT_CAPA_ENTIDADES SERVICIO VALIDACIÓN: ALMACENA A LAS ENTIDADES PROGRAMADAS EN LA CAPACITACION "ENTIDADES EN LA CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCapaEntidadesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtCapaEntidadesMng.class.getName());
	
	public static void validarDtCapaEntidadesBk(DtCapaEntidadesBk dtCapaEntidadesBk)
	 throws Validador
	{
                //FORANEAS
                if(dtCapaEntidadesBk.getIdCapacitacion()!=null && dtCapaEntidadesBk.getIdCapacitacion().longValue()<=0){
			dtCapaEntidadesBk.setIdCapacitacion(null);
		}
	        if(dtCapaEntidadesBk.getIdEntidad()!=null && dtCapaEntidadesBk.getIdEntidad().longValue()<=0){
			dtCapaEntidadesBk.setIdEntidad(null);
		}
	        if(dtCapaEntidadesBk.getEstado()!=null && dtCapaEntidadesBk.getEstado().longValue()<=0){
			dtCapaEntidadesBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdCapacitacion(dtCapaEntidadesBk.getIdCapacitacion());

		//validarIdEntidad(dtCapaEntidadesBk.getIdEntidad());

		
		
		
				
	}

	
	
	
	
	public static void validarIdCapacitacion(Long idCapacitacion)
	 throws Validador
	{				
					if(idCapacitacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaEntidades.seleccione"),
			Messages.getStringToKey("dtCapaEntidades.idCapacitacion"),
			Messages.getStringToKey("dtCapaEntidades.titulotabla"),
			Messages.getStringToKey("dtCapaEntidades.articuloIdCapacitacion")));
			if(idCapacitacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaEntidades.invalidoseleccione"),
			Messages.getStringToKey("dtCapaEntidades.idCapacitacion"),
			Messages.getStringToKey("dtCapaEntidades.titulotabla"),
			Messages.getStringToKey("dtCapaEntidades.articuloIdCapacitacion")));			
	}
	public static void validarIdEntidad(Long idEntidad)
			 throws Validador
				{				
								if(idEntidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaEntidades.invalidoingrese"),
						Messages.getStringToKey("dtCapaEntidades.idEntidad"),
						Messages.getStringToKey("dtCapaEntidades.titulotabla"),
						Messages.getStringToKey("dtCapaEntidades.articuloIdEntidad")));
					}
	
	
	
	
		
}