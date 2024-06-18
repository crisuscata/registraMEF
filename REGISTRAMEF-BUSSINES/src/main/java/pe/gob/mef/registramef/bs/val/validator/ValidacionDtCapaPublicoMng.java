package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaPublicoBk;

/**
 * DT_CAPA_PUBLICO SERVICIO VALIDACIÓN: ALMACENA EL TIPO DE PUBLICO OBJETIVO POR CAPACITACION "PUBLICO OBJETIVO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCapaPublicoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtCapaPublicoMng.class.getName());
	
	public static void validarDtCapaPublicoBk(DtCapaPublicoBk dtCapaPublicoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtCapaPublicoBk.getIdCapacitacion()!=null && dtCapaPublicoBk.getIdCapacitacion().longValue()<=0){
			dtCapaPublicoBk.setIdCapacitacion(null);
		}
	        if(dtCapaPublicoBk.getIdCargo()!=null && dtCapaPublicoBk.getIdCargo().longValue()<=0){
			dtCapaPublicoBk.setIdCargo(null);
		}
	        if(dtCapaPublicoBk.getEstado()!=null && dtCapaPublicoBk.getEstado().longValue()<=0){
			dtCapaPublicoBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdCapacitacion(dtCapaPublicoBk.getIdCapacitacion());

		//validarIdCargo(dtCapaPublicoBk.getIdCargo());

		
		
		
				
	}

	
	
	
	
	public static void validarIdCapacitacion(Long idCapacitacion)
	 throws Validador
	{				
					if(idCapacitacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaPublico.seleccione"),
			Messages.getStringToKey("dtCapaPublico.idCapacitacion"),
			Messages.getStringToKey("dtCapaPublico.titulotabla"),
			Messages.getStringToKey("dtCapaPublico.articuloIdCapacitacion")));
			if(idCapacitacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaPublico.invalidoseleccione"),
			Messages.getStringToKey("dtCapaPublico.idCapacitacion"),
			Messages.getStringToKey("dtCapaPublico.titulotabla"),
			Messages.getStringToKey("dtCapaPublico.articuloIdCapacitacion")));			
	}
	public static void validarIdCargo(Long idCargo)
			 throws Validador
				{				
								if(idCargo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaPublico.invalidoingrese"),
						Messages.getStringToKey("dtCapaPublico.idCargo"),
						Messages.getStringToKey("dtCapaPublico.titulotabla"),
						Messages.getStringToKey("dtCapaPublico.articuloIdCargo")));
					}
	
	
	
	
		
}