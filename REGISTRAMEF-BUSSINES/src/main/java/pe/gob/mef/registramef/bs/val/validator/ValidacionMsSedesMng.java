package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsSedesBk;

/**
 * MS_SEDES SERVICIO VALIDACIÓN: ALMACENA LAS SEDES REGISTRADAS EN EL SISTEMA "SEDES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsSedesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsSedesMng.class.getName());
	
	public static void validarMsSedesBk(MsSedesBk msSedesBk)
	 throws Validador
	{
                //FORANEAS
                if(msSedesBk.getIdGrupo()!=null && msSedesBk.getIdGrupo().longValue()<=0){
			msSedesBk.setIdGrupo(null);
		}
	        if(msSedesBk.getCodDpto()!=null && msSedesBk.getCodDpto().longValue()<=0){
			msSedesBk.setCodDpto(null);
		}
	        if(msSedesBk.getCodProv()!=null && msSedesBk.getCodProv().longValue()<=0){
			msSedesBk.setCodProv(null);
		}
	        if(msSedesBk.getCodDistr()!=null && msSedesBk.getCodDistr().longValue()<=0){
			msSedesBk.setCodDistr(null);
		}
	        if(msSedesBk.getEstado()!=null && msSedesBk.getEstado().longValue()<=0){
			msSedesBk.setEstado(null);
		}
	        if(msSedesBk.getIdMacregion()!=null && msSedesBk.getIdMacregion().longValue()<=0){
			msSedesBk.setIdMacregion(null);
		}
	        if(msSedesBk.getIdpais()!=null && msSedesBk.getIdpais().longValue()<=0){
			msSedesBk.setIdpais(null);
		}
	        
		//VALIDANDO
		
		//validarSigla(msSedesBk.getSigla());
		if(msSedesBk.getSigla()!=null){
				if(msSedesBk.getSigla().trim().length()>10)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msSedes.noexceder"),
							Messages.getStringToKey("msSedes.sigla"),
							Messages.getStringToKey("msSedes.titulotabla"),
							10,
							Messages.getStringToKey("msSedes.articuloSigla")
									));				
//				msSedesBk.setSigla(msSedesBk.getSigla().toUpperCase());
				}

		
		//validarSede(msSedesBk.getSede());
		if(msSedesBk.getSede()!=null){
				if(msSedesBk.getSede().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msSedes.noexceder"),
							Messages.getStringToKey("msSedes.sede"),
							Messages.getStringToKey("msSedes.titulotabla"),
							100,
							Messages.getStringToKey("msSedes.articuloSede")
									));				
//				msSedesBk.setSede(msSedesBk.getSede().toUpperCase());
				}

		
		//validarDireccion(msSedesBk.getDireccion());
		if(msSedesBk.getDireccion()!=null){
				if(msSedesBk.getDireccion().trim().length()>1000)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msSedes.noexceder"),
							Messages.getStringToKey("msSedes.direccion"),
							Messages.getStringToKey("msSedes.titulotabla"),
							1000,
							Messages.getStringToKey("msSedes.articuloDireccion")
							));				
//				msSedesBk.setDireccion(msSedesBk.getDireccion().toUpperCase());
				}

		
		
		
		
		//validarIdGrupo(msSedesBk.getIdGrupo());

		//validarCodDpto(msSedesBk.getCodDpto());

		//validarCodProv(msSedesBk.getCodProv());

		//validarCodDistr(msSedesBk.getCodDistr());

		
		//validarIdMacregion(msSedesBk.getIdMacregion());

		//validarIdpais(msSedesBk.getIdpais());

		
		
		//validarOrden(msSedesBk.getOrden());

		//validarFlagvisible(msSedesBk.getFlagvisible());

		//validarFlagvisiblerpte(msSedesBk.getFlagvisiblerpte());

				
	}

	public static void validarSigla(String sigla)
	 throws Validador
	{					
			if(sigla==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.ingrese"),
			Messages.getStringToKey("msSedes.sigla"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloSigla")));
			if(sigla.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
			Messages.getStringToKey("msSedes.sigla"),
			Messages.getStringToKey("msSedes.titulotabla")));						
			if(sigla!=null){
				if(sigla.trim().length()>10)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.noexceder"),
			Messages.getStringToKey("msSedes.sigla"),
			Messages.getStringToKey("msSedes.titulotabla"),10,
			Messages.getStringToKey("msSedes.articuloSigla")));
				}
	}
	
	public static void validarSede(String sede)
	 throws Validador
	{					
			if(sede==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.ingrese"),
			Messages.getStringToKey("msSedes.sede"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloSede")));
			if(sede.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
			Messages.getStringToKey("msSedes.sede"),
			Messages.getStringToKey("msSedes.titulotabla")));						
			if(sede!=null){
				if(sede.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.noexceder"),
			Messages.getStringToKey("msSedes.sede"),
			Messages.getStringToKey("msSedes.titulotabla"),100,
			Messages.getStringToKey("msSedes.articuloSede")));
				}
	}
	
	public static void validarDireccion(String direccion)
	 throws Validador
	{					
			if(direccion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.ingrese"),
			Messages.getStringToKey("msSedes.direccion"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloDireccion")));
			if(direccion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
			Messages.getStringToKey("msSedes.direccion"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloDireccion")));						
			if(direccion!=null){
				if(direccion.trim().length()>1000)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.noexceder"),
			Messages.getStringToKey("msSedes.direccion"),
			Messages.getStringToKey("msSedes.titulotabla"),1000,
			Messages.getStringToKey("msSedes.articuloDireccion")));
				}
	}
	
	
	
	
	public static void validarIdGrupo(Long idGrupo)
			 throws Validador
				{				
								if(idGrupo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
						Messages.getStringToKey("msSedes.idGrupo"),
						Messages.getStringToKey("msSedes.titulotabla"),
						Messages.getStringToKey("msSedes.articuloIdGrupo")));
					}
	
	public static void validarCodDpto(Integer codDpto)
			 throws Validador
				{				
								if(codDpto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
						Messages.getStringToKey("msSedes.codDpto"),
						Messages.getStringToKey("msSedes.titulotabla"),
						Messages.getStringToKey("msSedes.articuloCodDpto")));
					}
	
	public static void validarCodProv(Integer codProv)
			 throws Validador
				{				
								if(codProv==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
						Messages.getStringToKey("msSedes.codProv"),
						Messages.getStringToKey("msSedes.titulotabla"),
						Messages.getStringToKey("msSedes.articuloCodProv")));
					}
	
	public static void validarCodDistr(Integer codDistr)
			 throws Validador
				{				
								if(codDistr==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
						Messages.getStringToKey("msSedes.codDistr"),
						Messages.getStringToKey("msSedes.titulotabla"),
						Messages.getStringToKey("msSedes.articuloCodDistr")));
					}
	
	
	public static void validarIdMacregion(Long idMacregion)
			 throws Validador
				{				
								if(idMacregion==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
						Messages.getStringToKey("msSedes.idMacregion"),
						Messages.getStringToKey("msSedes.titulotabla"),
						Messages.getStringToKey("msSedes.articuloIdMacregion")));
					}
	
	
	public static void validarIdpais(Long idpais)
	 throws Validador
	{				
					if(idpais==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.seleccione"),
			Messages.getStringToKey("msSedes.idpais"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloIdpais")));
			if(idpais.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoseleccione"),
			Messages.getStringToKey("msSedes.idpais"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloIdpais")));			
	}
	
	
	
	public static void validarOrden(Long orden)
	 throws Validador
	{				
					if(orden==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.seleccione"),
			Messages.getStringToKey("msSedes.orden"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloOrden")));
			if(orden.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoseleccione"),
			Messages.getStringToKey("msSedes.orden"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloOrden")));			
	}
	
	public static void validarFlagvisible(Integer flagvisible)
	 throws Validador
	{				
					if(flagvisible==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
			Messages.getStringToKey("msSedes.flagvisible"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloFlagvisible")));
	}	
	
	
	public static void validarFlagvisiblerpte(Integer flagvisiblerpte)
	 throws Validador
	{				
					if(flagvisiblerpte==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("msSedes.invalidoingrese"),
			Messages.getStringToKey("msSedes.flagvisiblerpte"),
			Messages.getStringToKey("msSedes.titulotabla"),
			Messages.getStringToKey("msSedes.articuloFlagvisiblerpte")));
	}	
	
		
}