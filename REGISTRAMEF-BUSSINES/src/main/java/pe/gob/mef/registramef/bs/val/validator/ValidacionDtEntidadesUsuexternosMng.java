package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuexternosBk;

/**
 * DT_ENTIDADES_USUEXTERNOS SERVICIO VALIDACIÓN: ALMACENA LAS ENTIDADES A LA QUE PERTENECE EL USUARIO EXTERNO "ENTIDAD DEL USUARIO EXTERNO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtEntidadesUsuexternosMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtEntidadesUsuexternosMng.class.getName());
	
	public static void validarDtEntidadesUsuexternosBk(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk)
	 throws Validador
	{
                //FORANEAS
                if(dtEntidadesUsuexternosBk.getIdEntidad()!=null && dtEntidadesUsuexternosBk.getIdEntidad().longValue()<=0){
			dtEntidadesUsuexternosBk.setIdEntidad(null);
		}
	        if(dtEntidadesUsuexternosBk.getIdUsuexterno()!=null && dtEntidadesUsuexternosBk.getIdUsuexterno().longValue()<=0){
			dtEntidadesUsuexternosBk.setIdUsuexterno(null);
		}
	        if(dtEntidadesUsuexternosBk.getEstado()!=null && dtEntidadesUsuexternosBk.getEstado().longValue()<=0){
			dtEntidadesUsuexternosBk.setEstado(null);
		}
	        
		//VALIDANDO
		//validarIdEntidad(dtEntidadesUsuexternosBk.getIdEntidad());

		
		
		
		
		//validarIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());

		
		
		
				
	}
	
	// JPUYEN 14052024 - INICIO
			public static void validarDtVisitasUsuexternoBk(DtVisitasUsuexternosBk dtEntidadesUsuexternosBk)
			 throws Validador
			{
		                //FORANEAS
		                
			        if(dtEntidadesUsuexternosBk.getIdUsuexterno()!=null && dtEntidadesUsuexternosBk.getIdUsuexterno().longValue()<=0){
					dtEntidadesUsuexternosBk.setIdUsuexterno(null);
				}
			        if(dtEntidadesUsuexternosBk.getEstado()!=null && dtEntidadesUsuexternosBk.getEstado().longValue()<=0){
					dtEntidadesUsuexternosBk.setEstado(null);
				}
		
				
				
						
			}
			
			// JPUYEN 14052024 - FIN

	public static void validarIdEntidad(Long idEntidad)
	 throws Validador
	{				
					if(idEntidad==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadesUsuexternos.seleccione"),
			Messages.getStringToKey("dtEntidadesUsuexternos.idEntidad"),
			Messages.getStringToKey("dtEntidadesUsuexternos.titulotabla"),
			Messages.getStringToKey("dtEntidadesUsuexternos.articuloIdEntidad")));
			if(idEntidad.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadesUsuexternos.invalidoseleccione"),
			Messages.getStringToKey("dtEntidadesUsuexternos.idEntidad"),
			Messages.getStringToKey("dtEntidadesUsuexternos.titulotabla"),
			Messages.getStringToKey("dtEntidadesUsuexternos.articuloIdEntidad")));			
	}
	
	
	
	
	public static void validarIdUsuexterno(Long idUsuexterno)
			 throws Validador
				{				
								if(idUsuexterno==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadesUsuexternos.invalidoingrese"),
						Messages.getStringToKey("dtEntidadesUsuexternos.idUsuexterno"),
						Messages.getStringToKey("dtEntidadesUsuexternos.titulotabla"),
						Messages.getStringToKey("dtEntidadesUsuexternos.articuloIdUsuexterno")));
					}
	
	
	
	
		
}