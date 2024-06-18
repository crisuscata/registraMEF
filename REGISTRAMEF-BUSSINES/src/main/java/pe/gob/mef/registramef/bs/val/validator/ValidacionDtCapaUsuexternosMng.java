package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaUsuexternosBk;

/**
 * DT_CAPA_USUEXTERNOS SERVICIO VALIDACIÓN: ALMACENA A LOS PARTICIPANTES QUE ASISTEN A LA CAPACITACION "PARTICIPANTES EN LA CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCapaUsuexternosMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtCapaUsuexternosMng.class.getName());
	
	public static void validarDtCapaUsuexternosBk(DtCapaUsuexternosBk dtCapaUsuexternosBk)
	 throws Validador
	{
                //FORANEAS
                if(dtCapaUsuexternosBk.getIdCapacitacion()!=null && dtCapaUsuexternosBk.getIdCapacitacion().longValue()<=0){
			dtCapaUsuexternosBk.setIdCapacitacion(null);
		}
	        if(dtCapaUsuexternosBk.getEstado()!=null && dtCapaUsuexternosBk.getEstado().longValue()<=0){
			dtCapaUsuexternosBk.setEstado(null);
		}
	        if(dtCapaUsuexternosBk.getIdUsuexterno()!=null && dtCapaUsuexternosBk.getIdUsuexterno().longValue()<=0){
			dtCapaUsuexternosBk.setIdUsuexterno(null);
		}
	        if(dtCapaUsuexternosBk.getIdCargoUsuext()!=null && dtCapaUsuexternosBk.getIdCargoUsuext().longValue()<=0){
			dtCapaUsuexternosBk.setIdCargoUsuext(null);
		}
	        if(dtCapaUsuexternosBk.getIdEntidad()!=null && dtCapaUsuexternosBk.getIdEntidad().longValue()<=0){
			dtCapaUsuexternosBk.setIdEntidad(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdCapacitacion(dtCapaUsuexternosBk.getIdCapacitacion());

		
		
		
		//validarIdUsuexterno(dtCapaUsuexternosBk.getIdUsuexterno());

		//validarIdCargoUsuext(dtCapaUsuexternosBk.getIdCargoUsuext());

		//validarIdEntidad(dtCapaUsuexternosBk.getIdEntidad());

		
		//validarCorreoUsuext(dtCapaUsuexternosBk.getCorreoUsuext());
		if(dtCapaUsuexternosBk.getCorreoUsuext()!=null){
				if(dtCapaUsuexternosBk.getCorreoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapaUsuexternos.noexceder"),
							Messages.getStringToKey("dtCapaUsuexternos.correoUsuext"),
							Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtCapaUsuexternos.articuloCorreoUsuext")
									));				
//				dtCapaUsuexternosBk.setCorreoUsuext(dtCapaUsuexternosBk.getCorreoUsuext().toUpperCase());
				}

		
		//validarFijoUsuext(dtCapaUsuexternosBk.getFijoUsuext());
		if(dtCapaUsuexternosBk.getFijoUsuext()!=null){
				if(dtCapaUsuexternosBk.getFijoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapaUsuexternos.noexceder"),
							Messages.getStringToKey("dtCapaUsuexternos.fijoUsuext"),
							Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtCapaUsuexternos.articuloFijoUsuext")
									));				
//				dtCapaUsuexternosBk.setFijoUsuext(dtCapaUsuexternosBk.getFijoUsuext().toUpperCase());
				}

		
		//validarCelularUsuext(dtCapaUsuexternosBk.getCelularUsuext());
		if(dtCapaUsuexternosBk.getCelularUsuext()!=null){
				if(dtCapaUsuexternosBk.getCelularUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapaUsuexternos.noexceder"),
							Messages.getStringToKey("dtCapaUsuexternos.celularUsuext"),
							Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtCapaUsuexternos.articuloCelularUsuext")
									));				
//				dtCapaUsuexternosBk.setCelularUsuext(dtCapaUsuexternosBk.getCelularUsuext().toUpperCase());
				}

		//validarFlagMedioreg(dtCapaUsuexternosBk.getFlagMedioreg());

		//validarFlagAsistencia(dtCapaUsuexternosBk.getFlagAsistencia());

		//validarFlagConfirReg(dtCapaUsuexternosBk.getFlagConfirReg());

		//validarFechaFlagConfirReg(dtCapaUsuexternosBk.getFechaFlagConfirReg());

		//validarFechaFlagAsistencia(dtCapaUsuexternosBk.getFechaFlagAsistencia());

				
	}

	
	
	
	
	public static void validarIdCapacitacion(Long idCapacitacion)
	 throws Validador
	{				
					if(idCapacitacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.seleccione"),
			Messages.getStringToKey("dtCapaUsuexternos.idCapacitacion"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloIdCapacitacion")));
			if(idCapacitacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoseleccione"),
			Messages.getStringToKey("dtCapaUsuexternos.idCapacitacion"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloIdCapacitacion")));			
	}
	
	
	
	public static void validarIdUsuexterno(Long idUsuexterno)
			 throws Validador
				{				
								if(idUsuexterno==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtCapaUsuexternos.idUsuexterno"),
						Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtCapaUsuexternos.articuloIdUsuexterno")));
					}
	
	public static void validarIdCargoUsuext(Long idCargoUsuext)
			 throws Validador
				{				
								if(idCargoUsuext==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtCapaUsuexternos.idCargoUsuext"),
						Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtCapaUsuexternos.articuloIdCargoUsuext")));
					}
	
	public static void validarIdEntidad(Long idEntidad)
			 throws Validador
				{				
								if(idEntidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtCapaUsuexternos.idEntidad"),
						Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtCapaUsuexternos.articuloIdEntidad")));
					}
	
	
	public static void validarCorreoUsuext(String correoUsuext)
	 throws Validador
	{					
			if(correoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.ingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloCorreoUsuext")));
			if(correoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla")));						
			if(correoUsuext!=null){
				if(correoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.noexceder"),
			Messages.getStringToKey("dtCapaUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtCapaUsuexternos.articuloCorreoUsuext")));
				}
	}
	
	public static void validarFijoUsuext(String fijoUsuext)
	 throws Validador
	{					
			if(fijoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.ingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloFijoUsuext")));
			if(fijoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla")));						
			if(fijoUsuext!=null){
				if(fijoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.noexceder"),
			Messages.getStringToKey("dtCapaUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtCapaUsuexternos.articuloFijoUsuext")));
				}
	}
	
	public static void validarCelularUsuext(String celularUsuext)
	 throws Validador
	{					
			if(celularUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.ingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloCelularUsuext")));
			if(celularUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla")));						
			if(celularUsuext!=null){
				if(celularUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.noexceder"),
			Messages.getStringToKey("dtCapaUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtCapaUsuexternos.articuloCelularUsuext")));
				}
	}
	public static void validarFlagMedioreg(Long flagMedioreg)
			 throws Validador
				{				
								if(flagMedioreg==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtCapaUsuexternos.flagMedioreg"),
						Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtCapaUsuexternos.articuloFlagMedioreg")));
					}
	
	public static void validarFlagAsistencia(Long flagAsistencia)
			 throws Validador
				{				
								if(flagAsistencia==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtCapaUsuexternos.flagAsistencia"),
						Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtCapaUsuexternos.articuloFlagAsistencia")));
					}
	
	public static void validarFlagConfirReg(Long flagConfirReg)
			 throws Validador
				{				
								if(flagConfirReg==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtCapaUsuexternos.flagConfirReg"),
						Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
						Messages.getStringToKey("dtCapaUsuexternos.articuloFlagConfirReg")));
					}
	
	
	public static void validarFechaFlagConfirReg(Timestamp fechaFlagConfirReg)
	 throws Validador
	{				
					if(fechaFlagConfirReg==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.fechaFlagConfirReg"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloFechaFlagConfirReg")));
		}
	
	public static void validarFechaFlagAsistencia(Timestamp fechaFlagAsistencia)
	 throws Validador
	{				
					if(fechaFlagAsistencia==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtCapaUsuexternos.fechaFlagAsistencia"),
			Messages.getStringToKey("dtCapaUsuexternos.titulotabla"),
			Messages.getStringToKey("dtCapaUsuexternos.articuloFechaFlagAsistencia")));
		}
		
}