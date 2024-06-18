package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsTemaBk;

/**
 * MS_TEMA SERVICIO VALIDACIÓN: ALMACENA LOS TEMAS REGISTRADOS EN EL SISTEMA "TEMAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsTemaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsTemaMng.class.getName());
	
	public static void validarMsTemaBk(MsTemaBk msTemaBk)
	 throws Validador
	{
                //FORANEAS
                if(msTemaBk.getIdSistAdmi()!=null && msTemaBk.getIdSistAdmi().longValue()<=0){
			msTemaBk.setIdSistAdmi(null);
		}
	        if(msTemaBk.getEstado()!=null && msTemaBk.getEstado().longValue()<=0){
			msTemaBk.setEstado(null);
		}
	        if(msTemaBk.getTipoServicio()!=null && msTemaBk.getTipoServicio().longValue()<=0){
			msTemaBk.setTipoServicio(null);
		}
	        
		//VALIDANDO
		
		//validarDescripcion(msTemaBk.getDescripcion());
		if(msTemaBk.getDescripcion()!=null){
				if(msTemaBk.getDescripcion().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msTema.noexceder"),
							Messages.getStringToKey("msTema.descripcion"),
							Messages.getStringToKey("msTema.titulotabla"),
							100,
							Messages.getStringToKey("msTema.articuloDescripcion")
									));				
//				msTemaBk.setDescripcion(msTemaBk.getDescripcion().toUpperCase());
				}

		
		
		
		
		//validarIdSistAdmi(msTemaBk.getIdSistAdmi());

		
		
		
		//validarTipoServicio(msTemaBk.getTipoServicio());

				
	}

	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msTema.ingrese"),
			Messages.getStringToKey("msTema.descripcion"),
			Messages.getStringToKey("msTema.titulotabla"),
			Messages.getStringToKey("msTema.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msTema.invalidoingrese"),
			Messages.getStringToKey("msTema.descripcion"),
			Messages.getStringToKey("msTema.titulotabla")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msTema.noexceder"),
			Messages.getStringToKey("msTema.descripcion"),
			Messages.getStringToKey("msTema.titulotabla"),100,
			Messages.getStringToKey("msTema.articuloDescripcion")));
				}
	}
	
	
	
	
	public static void validarIdSistAdmi(Long idSistAdmi)
			 throws Validador
				{				
								if(idSistAdmi==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msTema.invalidoingrese"),
						Messages.getStringToKey("msTema.idSistAdmi"),
						Messages.getStringToKey("msTema.titulotabla"),
						Messages.getStringToKey("msTema.articuloIdSistAdmi")));
					}
	
	
	
	
	public static void validarTipoServicio(Long tipoServicio)
			 throws Validador
				{				
								if(tipoServicio==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msTema.invalidoingrese"),
						Messages.getStringToKey("msTema.tipoServicio"),
						Messages.getStringToKey("msTema.titulotabla"),
						Messages.getStringToKey("msTema.articuloTipoServicio")));
					}
	
		
}