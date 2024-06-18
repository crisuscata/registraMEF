package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsUbigeoBk;

/**
 * MS_UBIGEO SERVICIO VALIDACIÓN: ALMACENA EL UBIGEO(DEPARTAMENTO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsUbigeoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsUbigeoMng.class.getName());
	
	public static void validarMsUbigeoBk(MsUbigeoBk msUbigeoBk)
	 throws Validador
	{
		if(msUbigeoBk.getCodDpto()==null){
			msUbigeoBk.setCodDpto(0);
		}
		
		if(msUbigeoBk.getCodProv()==null){
			msUbigeoBk.setCodProv(0);
		}
		if(msUbigeoBk.getCodDistr()==null){
			msUbigeoBk.setCodDistr(0);
		}
                //FORANEAS
                
		//VALIDANDO
		
		//validarDescripcion(msUbigeoBk.getDescripcion());
		if(msUbigeoBk.getDescripcion()!=null){
				if(msUbigeoBk.getDescripcion().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msUbigeo.noexceder"),
							Messages.getStringToKey("msUbigeo.descripcion"),
							Messages.getStringToKey("msUbigeo.titulotabla"),
							50,
							Messages.getStringToKey("msUbigeo.articuloDescripcion")
									));				
//				msUbigeoBk.setDescripcion(msUbigeoBk.getDescripcion().toUpperCase());
				}

		
		
		
//		validarCodDpto(msUbigeoBk.getCodDpto());

//		validarCodProv(msUbigeoBk.getCodProv());

		
		
		
		
		//validarIdubigeo(msUbigeoBk.getIdubigeo());

				
	}

	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.ingrese"),
			Messages.getStringToKey("msUbigeo.descripcion"),
			Messages.getStringToKey("msUbigeo.titulotabla"),
			Messages.getStringToKey("msUbigeo.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.invalidoingrese"),
			Messages.getStringToKey("msUbigeo.descripcion"),
			Messages.getStringToKey("msUbigeo.titulotabla")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.noexceder"),
			Messages.getStringToKey("msUbigeo.descripcion"),
			Messages.getStringToKey("msUbigeo.titulotabla"),50,
			Messages.getStringToKey("msUbigeo.articuloDescripcion")));
				}
	}
	
	
	
	public static void validarCodDpto(Integer codDpto)
			 throws Validador
				{				
								if(codDpto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.invalidoingrese"),
						Messages.getStringToKey("msUbigeo.codDpto"),
						Messages.getStringToKey("msUbigeo.titulotabla"),
						Messages.getStringToKey("msUbigeo.articuloCodDpto")));
					}
	
	public static void validarCodProv(Integer codProv)
			 throws Validador
				{				
								if(codProv==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.invalidoingrese"),
						Messages.getStringToKey("msUbigeo.codProv"),
						Messages.getStringToKey("msUbigeo.titulotabla"),
						Messages.getStringToKey("msUbigeo.articuloCodProv")));
					}
	
	
	
	
	
	
	public static void validarIdubigeo(Long idubigeo)
	 throws Validador
	{				
					if(idubigeo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.seleccione"),
			Messages.getStringToKey("msUbigeo.idubigeo"),
			Messages.getStringToKey("msUbigeo.titulotabla"),
			Messages.getStringToKey("msUbigeo.articuloIdubigeo")));
			if(idubigeo.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msUbigeo.invalidoseleccione"),
			Messages.getStringToKey("msUbigeo.idubigeo"),
			Messages.getStringToKey("msUbigeo.titulotabla"),
			Messages.getStringToKey("msUbigeo.articuloIdubigeo")));			
	}
		
}