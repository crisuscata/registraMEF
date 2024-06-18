package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuexternosBk;

/**
 * DT_VISITAS_USUEXTERNOS SERVICIO VALIDACIÓN: ALMACENA A LOS PARTICIPANTES DE LA VISITA "PARTICIPANTES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtVisitasUsuexternosMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtVisitasUsuexternosMng.class.getName());
	
	public static void validarDtVisitasUsuexternosBk(DtVisitasUsuexternosBk dtVisitasUsuexternosBk)
	 throws Validador
	{
                //FORANEAS
                if(dtVisitasUsuexternosBk.getIdVisita()!=null && dtVisitasUsuexternosBk.getIdVisita().longValue()<=0){
			dtVisitasUsuexternosBk.setIdVisita(null);
		}
	        if(dtVisitasUsuexternosBk.getIdUsuexterno()!=null && dtVisitasUsuexternosBk.getIdUsuexterno().longValue()<=0){
			dtVisitasUsuexternosBk.setIdUsuexterno(null);
		}
	        if(dtVisitasUsuexternosBk.getEstado()!=null && dtVisitasUsuexternosBk.getEstado().longValue()<=0){
			dtVisitasUsuexternosBk.setEstado(null);
		}
	        if(dtVisitasUsuexternosBk.getIdCargoUsuext()!=null && dtVisitasUsuexternosBk.getIdCargoUsuext().longValue()<=0){
			dtVisitasUsuexternosBk.setIdCargoUsuext(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdVisita(dtVisitasUsuexternosBk.getIdVisita());

		//validarIdUsuexterno(dtVisitasUsuexternosBk.getIdUsuexterno());

		
		
		
		//validarIdCargoUsuext(dtVisitasUsuexternosBk.getIdCargoUsuext());

		
		//validarCorreoUsuext(dtVisitasUsuexternosBk.getCorreoUsuext());
		if(dtVisitasUsuexternosBk.getCorreoUsuext()!=null){
				if(dtVisitasUsuexternosBk.getCorreoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtVisitasUsuexternos.noexceder"),
							Messages.getStringToKey("dtVisitasUsuexternos.correoUsuext"),
							Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtVisitasUsuexternos.articuloCorreoUsuext")
									));				
//				dtVisitasUsuexternosBk.setCorreoUsuext(dtVisitasUsuexternosBk.getCorreoUsuext().toUpperCase());
				}

		
		//validarFijoUsuext(dtVisitasUsuexternosBk.getFijoUsuext());
		if(dtVisitasUsuexternosBk.getFijoUsuext()!=null){
				if(dtVisitasUsuexternosBk.getFijoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtVisitasUsuexternos.noexceder"),
							Messages.getStringToKey("dtVisitasUsuexternos.fijoUsuext"),
							Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtVisitasUsuexternos.articuloFijoUsuext")
									));				
//				dtVisitasUsuexternosBk.setFijoUsuext(dtVisitasUsuexternosBk.getFijoUsuext().toUpperCase());
				}

		
		//validarCelularUsuext(dtVisitasUsuexternosBk.getCelularUsuext());
		if(dtVisitasUsuexternosBk.getCelularUsuext()!=null){
				if(dtVisitasUsuexternosBk.getCelularUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtVisitasUsuexternos.noexceder"),
							Messages.getStringToKey("dtVisitasUsuexternos.celularUsuext"),
							Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
							50,
							Messages.getStringToKey("dtVisitasUsuexternos.articuloCelularUsuext")
									));				
//				dtVisitasUsuexternosBk.setCelularUsuext(dtVisitasUsuexternosBk.getCelularUsuext().toUpperCase());
				}

				
	}

	
	
	
	
	public static void validarIdVisita(Long idVisita)
	 throws Validador
	{				
					if(idVisita==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.seleccione"),
			Messages.getStringToKey("dtVisitasUsuexternos.idVisita"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuexternos.articuloIdVisita")));
			if(idVisita.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.invalidoseleccione"),
			Messages.getStringToKey("dtVisitasUsuexternos.idVisita"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuexternos.articuloIdVisita")));			
	}
	public static void validarIdUsuexterno(Long idUsuexterno)
			 throws Validador
				{				
								if(idUsuexterno==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtVisitasUsuexternos.idUsuexterno"),
						Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
						Messages.getStringToKey("dtVisitasUsuexternos.articuloIdUsuexterno")));
					}
	
	
	
	
	public static void validarIdCargoUsuext(Long idCargoUsuext)
			 throws Validador
				{				
								if(idCargoUsuext==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtVisitasUsuexternos.idCargoUsuext"),
						Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
						Messages.getStringToKey("dtVisitasUsuexternos.articuloIdCargoUsuext")));
					}
	
	
	public static void validarCorreoUsuext(String correoUsuext)
	 throws Validador
	{					
			if(correoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.ingrese"),
			Messages.getStringToKey("dtVisitasUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuexternos.articuloCorreoUsuext")));
			if(correoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtVisitasUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla")));						
			if(correoUsuext!=null){
				if(correoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.noexceder"),
			Messages.getStringToKey("dtVisitasUsuexternos.correoUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtVisitasUsuexternos.articuloCorreoUsuext")));
				}
	}
	
	public static void validarFijoUsuext(String fijoUsuext)
	 throws Validador
	{					
			if(fijoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.ingrese"),
			Messages.getStringToKey("dtVisitasUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuexternos.articuloFijoUsuext")));
			if(fijoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtVisitasUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla")));						
			if(fijoUsuext!=null){
				if(fijoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.noexceder"),
			Messages.getStringToKey("dtVisitasUsuexternos.fijoUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtVisitasUsuexternos.articuloFijoUsuext")));
				}
	}
	
	public static void validarCelularUsuext(String celularUsuext)
	 throws Validador
	{					
			if(celularUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.ingrese"),
			Messages.getStringToKey("dtVisitasUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuexternos.articuloCelularUsuext")));
			if(celularUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.invalidoingrese"),
			Messages.getStringToKey("dtVisitasUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla")));						
			if(celularUsuext!=null){
				if(celularUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuexternos.noexceder"),
			Messages.getStringToKey("dtVisitasUsuexternos.celularUsuext"),
			Messages.getStringToKey("dtVisitasUsuexternos.titulotabla"),50,
			Messages.getStringToKey("dtVisitasUsuexternos.articuloCelularUsuext")));
				}
	}
		
}