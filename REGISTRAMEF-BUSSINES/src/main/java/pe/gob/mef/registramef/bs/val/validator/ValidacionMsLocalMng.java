package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsLocalBk;

/**
 * MS_LOCAL SERVICIO VALIDACIÓN: ALMACENA LOS LOCALES REGISTRADOS EN EL SISTEMA "LOCALES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsLocalMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsLocalMng.class.getName());
	
	public static void validarMsLocalBk(MsLocalBk msLocalBk)
	 throws Validador
	{
                //FORANEAS
                if(msLocalBk.getCodDpto()!=null && msLocalBk.getCodDpto().longValue()<=0){
			msLocalBk.setCodDpto(null);
		}
	        if(msLocalBk.getCodProv()!=null && msLocalBk.getCodProv().longValue()<=0){
			msLocalBk.setCodProv(null);
		}
	        if(msLocalBk.getCodDistr()!=null && msLocalBk.getCodDistr().longValue()<=0){
			msLocalBk.setCodDistr(null);
		}
	        if(msLocalBk.getIdSede()!=null && msLocalBk.getIdSede().longValue()<=0){
			msLocalBk.setIdSede(null);
		}
	        if(msLocalBk.getIdpais()!=null && msLocalBk.getIdpais().longValue()<=0){
			msLocalBk.setIdpais(null);
		}
	        if(msLocalBk.getEstado()!=null && msLocalBk.getEstado().longValue()<=0){
			msLocalBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		//validarDescripcion(msLocalBk.getDescripcion());
		if(msLocalBk.getDescripcion()!=null){
				if(msLocalBk.getDescripcion().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msLocal.noexceder"),
							Messages.getStringToKey("msLocal.descripcion"),
							Messages.getStringToKey("msLocal.titulotabla"),
							200,
							Messages.getStringToKey("msLocal.articuloDescripcion")
									));				
//				msLocalBk.setDescripcion(msLocalBk.getDescripcion().toUpperCase());
				}

		
		//validarDireccion(msLocalBk.getDireccion());
		if(msLocalBk.getDireccion()!=null){
				if(msLocalBk.getDireccion().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msLocal.noexceder"),
							Messages.getStringToKey("msLocal.direccion"),
							Messages.getStringToKey("msLocal.titulotabla"),
							100,
							Messages.getStringToKey("msLocal.articuloDireccion")
									));				
//				msLocalBk.setDireccion(msLocalBk.getDireccion().toUpperCase());
				}

		
		//validarReferencia(msLocalBk.getReferencia());
		if(msLocalBk.getReferencia()!=null){
				if(msLocalBk.getReferencia().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msLocal.noexceder"),
							Messages.getStringToKey("msLocal.referencia"),
							Messages.getStringToKey("msLocal.titulotabla"),
							200,
							Messages.getStringToKey("msLocal.articuloReferencia")
									));				
//				msLocalBk.setReferencia(msLocalBk.getReferencia().toUpperCase());
				}

		
		
		
		
		//validarCodDpto(msLocalBk.getCodDpto());

		//validarCodProv(msLocalBk.getCodProv());

		//validarCodDistr(msLocalBk.getCodDistr());

		//validarIdSede(msLocalBk.getIdSede());

		//validarIdpais(msLocalBk.getIdpais());

		
		
		
				
	}

	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.ingrese"),
			Messages.getStringToKey("msLocal.descripcion"),
			Messages.getStringToKey("msLocal.titulotabla"),
			Messages.getStringToKey("msLocal.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
			Messages.getStringToKey("msLocal.descripcion"),
			Messages.getStringToKey("msLocal.titulotabla")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.noexceder"),
			Messages.getStringToKey("msLocal.descripcion"),
			Messages.getStringToKey("msLocal.titulotabla"),200,
			Messages.getStringToKey("msLocal.articuloDescripcion")));
				}
	}
	
	public static void validarDireccion(String direccion)
	 throws Validador
	{					
			if(direccion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.ingrese"),
			Messages.getStringToKey("msLocal.direccion"),
			Messages.getStringToKey("msLocal.titulotabla"),
			Messages.getStringToKey("msLocal.articuloDireccion")));
			if(direccion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
			Messages.getStringToKey("msLocal.direccion"),
			Messages.getStringToKey("msLocal.titulotabla")));						
			if(direccion!=null){
				if(direccion.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.noexceder"),
			Messages.getStringToKey("msLocal.direccion"),
			Messages.getStringToKey("msLocal.titulotabla"),100,
			Messages.getStringToKey("msLocal.articuloDireccion")));
				}
	}
	
	public static void validarReferencia(String referencia)
	 throws Validador
	{					
			if(referencia==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.ingrese"),
			Messages.getStringToKey("msLocal.referencia"),
			Messages.getStringToKey("msLocal.titulotabla"),
			Messages.getStringToKey("msLocal.articuloReferencia")));
			if(referencia.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
			Messages.getStringToKey("msLocal.referencia"),
			Messages.getStringToKey("msLocal.titulotabla")));						
			if(referencia!=null){
				if(referencia.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.noexceder"),
			Messages.getStringToKey("msLocal.referencia"),
			Messages.getStringToKey("msLocal.titulotabla"),200,
			Messages.getStringToKey("msLocal.articuloReferencia")));
				}
	}
	
	
	
	
	public static void validarCodDpto(Integer codDpto)
			 throws Validador
				{				
								if(codDpto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
						Messages.getStringToKey("msLocal.codDpto"),
						Messages.getStringToKey("msLocal.titulotabla"),
						Messages.getStringToKey("msLocal.articuloCodDpto")));
					}
	
	public static void validarCodProv(Integer codProv)
			 throws Validador
				{				
								if(codProv==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
						Messages.getStringToKey("msLocal.codProv"),
						Messages.getStringToKey("msLocal.titulotabla"),
						Messages.getStringToKey("msLocal.articuloCodProv")));
					}
	
	public static void validarCodDistr(Integer codDistr)
			 throws Validador
				{				
								if(codDistr==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
						Messages.getStringToKey("msLocal.codDistr"),
						Messages.getStringToKey("msLocal.titulotabla"),
						Messages.getStringToKey("msLocal.articuloCodDistr")));
					}
	
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoingrese"),
						Messages.getStringToKey("msLocal.idSede"),
						Messages.getStringToKey("msLocal.titulotabla"),
						Messages.getStringToKey("msLocal.articuloIdSede")));
					}
	
	
	public static void validarIdpais(Long idpais)
	 throws Validador
	{				
					if(idpais==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.seleccione"),
			Messages.getStringToKey("msLocal.idpais"),
			Messages.getStringToKey("msLocal.titulotabla"),
			Messages.getStringToKey("msLocal.articuloIdpais")));
			if(idpais.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msLocal.invalidoseleccione"),
			Messages.getStringToKey("msLocal.idpais"),
			Messages.getStringToKey("msLocal.titulotabla"),
			Messages.getStringToKey("msLocal.articuloIdpais")));			
	}
	
	
	
		
}