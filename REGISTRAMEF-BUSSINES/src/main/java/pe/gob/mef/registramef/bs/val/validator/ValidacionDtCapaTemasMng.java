package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaTemasBk;

/**
 * DT_CAPA_TEMAS SERVICIO VALIDACIÓN: ALMACENA LOS DIFERENTES TEMAS AGENDADOS EN LA CAPACITACION "TEMAS DE CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCapaTemasMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtCapaTemasMng.class.getName());
	
	public static void validarDtCapaTemasBk(DtCapaTemasBk dtCapaTemasBk)
	 throws Validador
	{
                //FORANEAS
                if(dtCapaTemasBk.getIdCapacitacion()!=null && dtCapaTemasBk.getIdCapacitacion().longValue()<=0){
			dtCapaTemasBk.setIdCapacitacion(null);
		}
	        if(dtCapaTemasBk.getIdTema()!=null && dtCapaTemasBk.getIdTema().longValue()<=0){
			dtCapaTemasBk.setIdTema(null);
		}
	        if(dtCapaTemasBk.getIdSubtema()!=null && dtCapaTemasBk.getIdSubtema().longValue()<=0){
			dtCapaTemasBk.setIdSubtema(null);
		}
	        if(dtCapaTemasBk.getEstado()!=null && dtCapaTemasBk.getEstado().longValue()<=0){
			dtCapaTemasBk.setEstado(null);
		}
	        if(dtCapaTemasBk.getIdUsuinterno()!=null && dtCapaTemasBk.getIdUsuinterno().longValue()<=0){
			dtCapaTemasBk.setIdUsuinterno(null);
		}
	        if(dtCapaTemasBk.getIdSistAdmi()!=null && dtCapaTemasBk.getIdSistAdmi().longValue()<=0){
			dtCapaTemasBk.setIdSistAdmi(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdCapacitacion(dtCapaTemasBk.getIdCapacitacion());

		//validarIdTema(dtCapaTemasBk.getIdTema());

		//validarIdSubtema(dtCapaTemasBk.getIdSubtema());

		//validarEstado(dtCapaTemasBk.getEstado());

		
		
		//validarIdUsuinterno(dtCapaTemasBk.getIdUsuinterno());

		//validarIdSistAdmi(dtCapaTemasBk.getIdSistAdmi());

				
	}

	
	
	
	
	public static void validarIdCapacitacion(Long idCapacitacion)
	 throws Validador
	{				
					if(idCapacitacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.seleccione"),
			Messages.getStringToKey("dtCapaTemas.idCapacitacion"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloIdCapacitacion")));
			if(idCapacitacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtCapaTemas.idCapacitacion"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloIdCapacitacion")));			
	}
	public static void validarIdTema(Long idTema)
			 throws Validador
				{				
								if(idTema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.invalidoingrese"),
						Messages.getStringToKey("dtCapaTemas.idTema"),
						Messages.getStringToKey("dtCapaTemas.titulotabla"),
						Messages.getStringToKey("dtCapaTemas.articuloIdTema")));
					}
	
	public static void validarIdSubtema(Long idSubtema)
			 throws Validador
				{				
								if(idSubtema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.invalidoingrese"),
						Messages.getStringToKey("dtCapaTemas.idSubtema"),
						Messages.getStringToKey("dtCapaTemas.titulotabla"),
						Messages.getStringToKey("dtCapaTemas.articuloIdSubtema")));
					}
	
	
	public static void validarEstado(Long estado)
	 throws Validador
	{				
					if(estado==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.seleccione"),
			Messages.getStringToKey("dtCapaTemas.estado"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloEstado")));
			if(estado.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtCapaTemas.estado"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloEstado")));			
	}
	
	
	
	public static void validarIdUsuinterno(Long idUsuinterno)
	 throws Validador
	{				
					if(idUsuinterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.seleccione"),
			Messages.getStringToKey("dtCapaTemas.idUsuinterno"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloIdUsuinterno")));
			if(idUsuinterno.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtCapaTemas.idUsuinterno"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloIdUsuinterno")));			
	}
	
	public static void validarIdSistAdmi(Long idSistAdmi)
	 throws Validador
	{				
					if(idSistAdmi==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.seleccione"),
			Messages.getStringToKey("dtCapaTemas.idSistAdmi"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloIdSistAdmi")));
			if(idSistAdmi.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtCapaTemas.idSistAdmi"),
			Messages.getStringToKey("dtCapaTemas.titulotabla"),
			Messages.getStringToKey("dtCapaTemas.articuloIdSistAdmi")));			
	}
		
}