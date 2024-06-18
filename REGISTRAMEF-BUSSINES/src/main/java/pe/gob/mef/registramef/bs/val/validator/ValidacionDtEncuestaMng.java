package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaBk;

/**
 * DT_ENCUESTA SERVICIO VALIDACIÓN: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtEncuestaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtEncuestaMng.class.getName());
	
	public static void validarDtEncuestaBk(DtEncuestaBk dtEncuestaBk)
	 throws Validador
	{
                //FORANEAS
                if(dtEncuestaBk.getIdOrigen()!=null && dtEncuestaBk.getIdOrigen().longValue()<=0){
			dtEncuestaBk.setIdOrigen(null);
		}
	        if(dtEncuestaBk.getIdPrestacion()!=null && dtEncuestaBk.getIdPrestacion().longValue()<=0){
			dtEncuestaBk.setIdPrestacion(null);
		}
	        
		//VALIDANDO
		validarTipoServicio(dtEncuestaBk.getTipoServicio());

		validarFechaInicio(dtEncuestaBk.getFechaInicio());

		validarFechaFin(dtEncuestaBk.getFechaFin());

		
		
		
		
		
		
		
		//validarFlagBloqueo(dtEncuestaBk.getFlagBloqueo());

		//validarIdOrigen(dtEncuestaBk.getIdOrigen());

		//validarIdPrestacion(dtEncuestaBk.getIdPrestacion());

				
	}
public static void validarTipoServicio(Long tipoServicio)
			 throws Validador
				{				
								if(tipoServicio==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuesta.invalidoingrese"),
						Messages.getStringToKey("dtEncuesta.tipoServicio"),
						Messages.getStringToKey("dtEncuesta.titulotabla"),
						Messages.getStringToKey("dtEncuesta.articuloTipoServicio")));
					}
	
	
	public static void validarFechaInicio(Timestamp fechaInicio)
	 throws Validador
	{				
					if(fechaInicio==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuesta.invalidoingrese"),
			Messages.getStringToKey("dtEncuesta.fechaInicio"),
			Messages.getStringToKey("dtEncuesta.titulotabla"),
			Messages.getStringToKey("dtEncuesta.articuloFechaInicio")));
		}
	
	public static void validarFechaFin(Timestamp fechaFin)
	 throws Validador
	{				
					if(fechaFin==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuesta.invalidoingrese"),
			Messages.getStringToKey("dtEncuesta.fechaFin"),
			Messages.getStringToKey("dtEncuesta.titulotabla"),
			Messages.getStringToKey("dtEncuesta.articuloFechaFin")));
		}
	
	
	
	
	
	
	
	public static void validarFlagBloqueo(Long flagBloqueo)
			 throws Validador
				{				
								if(flagBloqueo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuesta.invalidoingrese"),
						Messages.getStringToKey("dtEncuesta.flagBloqueo"),
						Messages.getStringToKey("dtEncuesta.titulotabla"),
						Messages.getStringToKey("dtEncuesta.articuloFlagBloqueo")));
					}
	
	public static void validarIdOrigen(Long idOrigen)
			 throws Validador
				{				
								if(idOrigen==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuesta.invalidoingrese"),
						Messages.getStringToKey("dtEncuesta.idOrigen"),
						Messages.getStringToKey("dtEncuesta.titulotabla"),
						Messages.getStringToKey("dtEncuesta.articuloIdOrigen")));
					}
	
	public static void validarIdPrestacion(Long idPrestacion)
			 throws Validador
				{				
								if(idPrestacion==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuesta.invalidoingrese"),
						Messages.getStringToKey("dtEncuesta.idPrestacion"),
						Messages.getStringToKey("dtEncuesta.titulotabla"),
						Messages.getStringToKey("dtEncuesta.articuloIdPrestacion")));
					}
	
		
}