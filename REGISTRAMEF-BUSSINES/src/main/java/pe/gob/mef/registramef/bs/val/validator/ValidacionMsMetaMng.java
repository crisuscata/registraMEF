package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsMetaBk;

/**
 * MS_META SERVICIO VALIDACIÓN: ALMACENA LAS METAS CON SUS VALORES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsMetaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsMetaMng.class.getName());
	
	public static void validarMsMetaBk(MsMetaBk msMetaBk)
	 throws Validador
	{
                //FORANEAS
                if(msMetaBk.getIdTipoServicio()!=null && msMetaBk.getIdTipoServicio().longValue()<=0){
			msMetaBk.setIdTipoServicio(null);
		}
	        if(msMetaBk.getIdSistAdmi()!=null && msMetaBk.getIdSistAdmi().longValue()<=0){
			msMetaBk.setIdSistAdmi(null);
		}
	        if(msMetaBk.getIdSede()!=null && msMetaBk.getIdSede().longValue()<=0){
			msMetaBk.setIdSede(null);
		}
	        
		//VALIDANDO
		//validarAnnio(msMetaBk.getAnnio());

		//validarIdTipoServicio(msMetaBk.getIdTipoServicio());

		//validarIdSistAdmi(msMetaBk.getIdSistAdmi());

		//validarIdSede(msMetaBk.getIdSede());

		//validarValor(msMetaBk.getValor());

		
		
		
		
		
		
		
				
	}
public static void validarAnnio(Integer annio)
			 throws Validador
				{				
								if(annio==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msMeta.invalidoingrese"),
						Messages.getStringToKey("msMeta.annio"),
						Messages.getStringToKey("msMeta.titulotabla"),
						Messages.getStringToKey("msMeta.articuloAnnio")));
					}
	
	public static void validarIdTipoServicio(Long idTipoServicio)
			 throws Validador
				{				
								if(idTipoServicio==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msMeta.invalidoingrese"),
						Messages.getStringToKey("msMeta.idTipoServicio"),
						Messages.getStringToKey("msMeta.titulotabla"),
						Messages.getStringToKey("msMeta.articuloIdTipoServicio")));
					}
	
	public static void validarIdSistAdmi(Long idSistAdmi)
			 throws Validador
				{				
								if(idSistAdmi==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msMeta.invalidoingrese"),
						Messages.getStringToKey("msMeta.idSistAdmi"),
						Messages.getStringToKey("msMeta.titulotabla"),
						Messages.getStringToKey("msMeta.articuloIdSistAdmi")));
					}
	
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msMeta.invalidoingrese"),
						Messages.getStringToKey("msMeta.idSede"),
						Messages.getStringToKey("msMeta.titulotabla"),
						Messages.getStringToKey("msMeta.articuloIdSede")));
					}
	
	
	public static void validarValor(Long valor)
	 throws Validador
	{				
					if(valor==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msMeta.seleccione"),
			Messages.getStringToKey("msMeta.valor"),
			Messages.getStringToKey("msMeta.titulotabla"),
			Messages.getStringToKey("msMeta.articuloValor")));
			if(valor.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msMeta.invalidoseleccione"),
			Messages.getStringToKey("msMeta.valor"),
			Messages.getStringToKey("msMeta.titulotabla"),
			Messages.getStringToKey("msMeta.articuloValor")));			
	}
	
	
	
	
	
	
	
		
}