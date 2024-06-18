package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtAmpliacionFechaBk;

/**
 * DT_AMPLIACION_FECHA SERVICIO VALIDACIÓN: ALMACENA LAS AMPLIACIONES DE LOS DÍAS DE PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtAmpliacionFechaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtAmpliacionFechaMng.class.getName());
	
	public static void validarDtAmpliacionFechaBk(DtAmpliacionFechaBk dtAmpliacionFechaBk)
	 throws Validador
	{
                //FORANEAS
                if(dtAmpliacionFechaBk.getTipoFechaCorte()!=null && dtAmpliacionFechaBk.getTipoFechaCorte().longValue()<=0){
			dtAmpliacionFechaBk.setTipoFechaCorte(null);
		}
	        if(dtAmpliacionFechaBk.getIdSede()!=null && dtAmpliacionFechaBk.getIdSede().longValue()<=0){
			dtAmpliacionFechaBk.setIdSede(null);
		}
	        if(dtAmpliacionFechaBk.getIdSistAdmi()!=null && dtAmpliacionFechaBk.getIdSistAdmi().longValue()<=0){
			dtAmpliacionFechaBk.setIdSistAdmi(null);
		}
	        if(dtAmpliacionFechaBk.getEstado()!=null && dtAmpliacionFechaBk.getEstado().longValue()<=0){
			dtAmpliacionFechaBk.setEstado(null);
		}
	        
		//VALIDANDO
		validarTipoFechaCorte(dtAmpliacionFechaBk.getTipoFechaCorte());

		validarIdSede(dtAmpliacionFechaBk.getIdSede());

		validarIdSistAdmi(dtAmpliacionFechaBk.getIdSistAdmi());

		//validarFechaInicio(dtAmpliacionFechaBk.getFechaInicio());

		validarFechaFin(dtAmpliacionFechaBk.getFechaFin());

		
		
		
		
		
		
		
				
	}
public static void validarTipoFechaCorte(Long tipoFechaCorte)
			 throws Validador
				{				
								if(tipoFechaCorte==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAmpliacionFecha.invalidoingrese"),
						Messages.getStringToKey("dtAmpliacionFecha.tipoFechaCorte"),
						Messages.getStringToKey("dtAmpliacionFecha.titulotabla"),
						Messages.getStringToKey("dtAmpliacionFecha.articuloTipoFechaCorte")));
					}
	
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAmpliacionFecha.invalidoingrese"),
						Messages.getStringToKey("dtAmpliacionFecha.idSede"),
						Messages.getStringToKey("dtAmpliacionFecha.titulotabla"),
						Messages.getStringToKey("dtAmpliacionFecha.articuloIdSede")));
					}
	
	public static void validarIdSistAdmi(Long idSistAdmi)
			 throws Validador
				{				
								if(idSistAdmi==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAmpliacionFecha.invalidoingrese"),
						Messages.getStringToKey("dtAmpliacionFecha.idSistAdmi"),
						Messages.getStringToKey("dtAmpliacionFecha.titulotabla"),
						Messages.getStringToKey("dtAmpliacionFecha.articuloIdSistAdmi")));
					}
	
	
	public static void validarFechaInicio(Timestamp fechaInicio)
	 throws Validador
	{				
					if(fechaInicio==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAmpliacionFecha.invalidoingrese"),
			Messages.getStringToKey("dtAmpliacionFecha.fechaInicio"),
			Messages.getStringToKey("dtAmpliacionFecha.titulotabla"),
			Messages.getStringToKey("dtAmpliacionFecha.articuloFechaInicio")));
		}
	
	public static void validarFechaFin(Timestamp fechaFin)
	 throws Validador
	{				
					if(fechaFin==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAmpliacionFecha.invalidoingrese"),
			Messages.getStringToKey("dtAmpliacionFecha.fechaFin"),
			Messages.getStringToKey("dtAmpliacionFecha.titulotabla"),
			Messages.getStringToKey("dtAmpliacionFecha.articuloFechaFin")));
		}
	
	
	
	
	
	
	
		
}