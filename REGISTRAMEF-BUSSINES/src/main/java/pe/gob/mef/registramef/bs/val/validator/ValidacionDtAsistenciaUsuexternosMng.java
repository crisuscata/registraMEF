package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaUsuexternosBk;

/**
 * DT_ASISTENCIA_USUEXTERNOS SERVICIO VALIDACIÓN: ALMACENA LOS USUARIOS QUE BRINDAN LA ATENCION EN LA ASISTENCIA TECNICA "USUARIOS QUE BRINDAN LA ATENCIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtAsistenciaUsuexternosMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtAsistenciaUsuexternosMng.class.getName());
	
	public static void validarDtAsistenciaUsuexternosBk(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk)
	 throws Validador
	{
                //FORANEAS
                if(dtAsistenciaUsuexternosBk.getIdAsistencia()!=null && dtAsistenciaUsuexternosBk.getIdAsistencia().longValue()<=0){
			dtAsistenciaUsuexternosBk.setIdAsistencia(null);
		}
	        if(dtAsistenciaUsuexternosBk.getIdUsuexterno()!=null && dtAsistenciaUsuexternosBk.getIdUsuexterno().longValue()<=0){
			dtAsistenciaUsuexternosBk.setIdUsuexterno(null);
		}
	        if(dtAsistenciaUsuexternosBk.getEstado()!=null && dtAsistenciaUsuexternosBk.getEstado().longValue()<=0){
			dtAsistenciaUsuexternosBk.setEstado(null);
		}
	        if(dtAsistenciaUsuexternosBk.getIdCargoUsuext()!=null && dtAsistenciaUsuexternosBk.getIdCargoUsuext().longValue()<=0){
			dtAsistenciaUsuexternosBk.setIdCargoUsuext(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdAsistencia(dtAsistenciaUsuexternosBk.getIdAsistencia());

		//validarIdUsuexterno(dtAsistenciaUsuexternosBk.getIdUsuexterno());

		
		
		
		//validarIdCargoUsuext(dtAsistenciaUsuexternosBk.getIdCargoUsuext());

		
		//validarCorreoUsuext(dtAsistenciaUsuexternosBk.getCorreoUsuext());
		if(dtAsistenciaUsuexternosBk.getCorreoUsuext()!=null){
				if(dtAsistenciaUsuexternosBk.getCorreoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtAsistenciaUsuexternos.noexceder"),
							Messages.getStringToKey("dtAsistenciaUsuexternos.correoUsuext"),
							Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCorreoUsuext")
									));				
//				dtAsistenciaUsuexternosBk.setCorreoUsuext(dtAsistenciaUsuexternosBk.getCorreoUsuext().toUpperCase());
				}

		
		//validarFijoUsuext(dtAsistenciaUsuexternosBk.getFijoUsuext());
		if(dtAsistenciaUsuexternosBk.getFijoUsuext()!=null){
				if(dtAsistenciaUsuexternosBk.getFijoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtAsistenciaUsuexternos.noexceder"),
							Messages.getStringToKey("dtAsistenciaUsuexternos.fijoUsuext"),
							Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtAsistenciaUsuexternos.articuloFijoUsuext")
									));				
//				dtAsistenciaUsuexternosBk.setFijoUsuext(dtAsistenciaUsuexternosBk.getFijoUsuext().toUpperCase());
				}

		
		//validarCelularUsuext(dtAsistenciaUsuexternosBk.getCelularUsuext());
		if(dtAsistenciaUsuexternosBk.getCelularUsuext()!=null){
				if(dtAsistenciaUsuexternosBk.getCelularUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtAsistenciaUsuexternos.noexceder"),
							Messages.getStringToKey("dtAsistenciaUsuexternos.celularUsuext"),
							Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCelularUsuext")
									));				
//				dtAsistenciaUsuexternosBk.setCelularUsuext(dtAsistenciaUsuexternosBk.getCelularUsuext().toUpperCase());
				}

		//validarCtrlConfirmacion(dtAsistenciaUsuexternosBk.getCtrlConfirmacion());

				
	}

	
	
	
	
	public static void validarIdAsistencia(Long idAsistencia)
	 throws Validador
	{				
					if(idAsistencia==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.seleccione"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.idAsistencia"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloIdAsistencia")));
			if(idAsistencia.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoseleccione"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.idAsistencia"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloIdAsistencia")));			
	}
	public static void validarIdUsuexterno(Long idUsuexterno)
			 throws Validador
				{				
								if(idUsuexterno==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.idUsuexterno"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.articuloIdUsuexterno")));
					}
	
	
	
	
	public static void validarIdCargoUsuext(Long idCargoUsuext)
			 throws Validador
				{				
								if(idCargoUsuext==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.idCargoUsuext"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.articuloIdCargoUsuext")));
					}
	
	
	public static void validarCorreoUsuext(String correoUsuext)
	 throws Validador
	{					
			if(correoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.ingrese"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCorreoUsuext")));
			if(correoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla")));						
			if(correoUsuext!=null){
				if(correoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.noexceder"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCorreoUsuext")));
				}
	}
	
	public static void validarFijoUsuext(String fijoUsuext)
	 throws Validador
	{					
			if(fijoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.ingrese"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloFijoUsuext")));
			if(fijoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla")));						
			if(fijoUsuext!=null){
				if(fijoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.noexceder"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloFijoUsuext")));
				}
	}
	
	public static void validarCelularUsuext(String celularUsuext)
	 throws Validador
	{					
			if(celularUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.ingrese"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCelularUsuext")));
			if(celularUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla")));						
			if(celularUsuext!=null){
				if(celularUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.noexceder"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCelularUsuext")));
				}
	}
	public static void validarCtrlConfirmacion(Long ctrlConfirmacion)
			 throws Validador
				{				
								if(ctrlConfirmacion==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.ctrlConfirmacion"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtAsistenciaUsuexternos.articuloCtrlConfirmacion")));
					}
	
		
}