package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;

/**
 * DT_ENTIDADES SERVICIO VALIDACIÓN: ALMACENA LAS ENTIDAD REGISTRADAS EN EL SISTEMA "ENTIDADES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 19:20
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 19:20                      / Creación de la clase             /
 * 
 */
public class ValidacionDtEntidadesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtEntidadesMng.class.getName());
	
	public static void validarDtEntidadesBk(DtEntidadesBk dtEntidadesBk)
	 throws Validador
	{
		
		//MPINARES 24012023 - INICIO
				validarRuc(dtEntidadesBk.getRuc());
				validarCodEjec(dtEntidadesBk.getCodEjec());
				validarRazSocial(dtEntidadesBk.getRazSocial());
				validarIdSede(dtEntidadesBk.getIdSede());
				validarIdTipo(dtEntidadesBk.getIdTipo());
				validarDireccion(dtEntidadesBk.getDireccion());
				validarIdCaract(dtEntidadesBk.getIdCaract());
				validarCodDpto(dtEntidadesBk.getCodDpto());
				validarCodProv(dtEntidadesBk.getCodProv());
				validarCodDistr(dtEntidadesBk.getCodDistr());
				
				//MPINARES 24012023 - FIN
                //FORANEAS
                if(dtEntidadesBk.getEstado()!=null && dtEntidadesBk.getEstado().longValue()<=0){
			dtEntidadesBk.setEstado(null);
		}
	        if(dtEntidadesBk.getIdTipo()!=null && dtEntidadesBk.getIdTipo().longValue()<=0){
			dtEntidadesBk.setIdTipo(null);
		}
	        if(dtEntidadesBk.getIdCaract()!=null && dtEntidadesBk.getIdCaract().longValue()<=0){
			dtEntidadesBk.setIdCaract(null);
		}
	        if(dtEntidadesBk.getCodDpto()!=null && dtEntidadesBk.getCodDpto().longValue()<=0){
			dtEntidadesBk.setCodDpto(null);
		}
	        if(dtEntidadesBk.getCodProv()!=null && dtEntidadesBk.getCodProv().longValue()<=0){
			dtEntidadesBk.setCodProv(null);
		}
	        if(dtEntidadesBk.getCodDistr()!=null && dtEntidadesBk.getCodDistr().longValue()<=0){
			dtEntidadesBk.setCodDistr(null);
		}
	        if(dtEntidadesBk.getIdpais()!=null && dtEntidadesBk.getIdpais().longValue()<=0){
			dtEntidadesBk.setIdpais(null);
		}
	        if(dtEntidadesBk.getIdSistAdmi()!=null && dtEntidadesBk.getIdSistAdmi().longValue()<=0){
			dtEntidadesBk.setIdSistAdmi(null);
		}
	        
		//VALIDANDO
		
		//validarCodEjec(dtEntidadesBk.getCodEjec());
		if(dtEntidadesBk.getCodEjec()!=null){
				if(dtEntidadesBk.getCodEjec().trim().length()>10)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEntidades.noexceder"),
							Messages.getStringToKey("dtEntidades.codEjec"),
							Messages.getStringToKey("dtEntidades.titulotabla"),
							10,
							Messages.getStringToKey("dtEntidades.articuloCodEjec")
									));				
//				dtEntidadesBk.setCodEjec(dtEntidadesBk.getCodEjec().toUpperCase());
				}

		
		//validarRazSocial(dtEntidadesBk.getRazSocial());
		if(dtEntidadesBk.getRazSocial()!=null){
				if(dtEntidadesBk.getRazSocial().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEntidades.noexceder"),
							Messages.getStringToKey("dtEntidades.razSocial"),
							Messages.getStringToKey("dtEntidades.titulotabla"),
							200,
							Messages.getStringToKey("dtEntidades.articuloRazSocial")
									));				
//				dtEntidadesBk.setRazSocial(dtEntidadesBk.getRazSocial().toUpperCase());
				}

		
		//validarDireccion(dtEntidadesBk.getDireccion());
		if(dtEntidadesBk.getDireccion()!=null){
				if(dtEntidadesBk.getDireccion().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEntidades.noexceder"),
							Messages.getStringToKey("dtEntidades.direccion"),
							Messages.getStringToKey("dtEntidades.titulotabla"),
							300,
							Messages.getStringToKey("dtEntidades.articuloDireccion")
							));				
//				dtEntidadesBk.setDireccion(dtEntidadesBk.getDireccion().toUpperCase());
				}

		
		
		
		
		//validarRuc(dtEntidadesBk.getRuc());

		
		//validarIdTipo(dtEntidadesBk.getIdTipo());

		//validarIdCaract(dtEntidadesBk.getIdCaract());

		//validarCodDpto(dtEntidadesBk.getCodDpto());

		//validarCodProv(dtEntidadesBk.getCodProv());

		//validarCodDistr(dtEntidadesBk.getCodDistr());

		//validarIdpais(dtEntidadesBk.getIdpais());

		//validarIdSistAdmi(dtEntidadesBk.getIdSistAdmi());

		
		
		
		//validarGeozona(dtEntidadesBk.getGeozona());
		if(dtEntidadesBk.getGeozona()!=null){
				if(dtEntidadesBk.getGeozona().trim().length()>2)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEntidades.noexceder"),
							Messages.getStringToKey("dtEntidades.geozona"),
							Messages.getStringToKey("dtEntidades.titulotabla"),
							2,
							Messages.getStringToKey("dtEntidades.articuloGeozona")
									));				
//				dtEntidadesBk.setGeozona(dtEntidadesBk.getGeozona().toUpperCase());
				}

				
	}

	public static void validarCodEjec(String codEjec)
	 throws Validador
	{					
			if(codEjec==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.ingrese"),
			Messages.getStringToKey("dtEntidades.codEjec"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloCodEjec")));
			if(codEjec.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),
			Messages.getStringToKey("dtEntidades.codEjec"),
			Messages.getStringToKey("dtEntidades.titulotabla")));						
			if(codEjec!=null){
				if(codEjec.trim().length()>10)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.noexceder"),
			Messages.getStringToKey("dtEntidades.codEjec"),
			Messages.getStringToKey("dtEntidades.titulotabla"),10,
			Messages.getStringToKey("dtEntidades.articuloCodEjec")));
				}
	}
	
	public static void validarRazSocial(String razSocial)
	 throws Validador
	{					
			if(razSocial==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.ingrese"),
			Messages.getStringToKey("dtEntidades.razSocial"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloRazSocial")));
			if(razSocial.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),
			Messages.getStringToKey("dtEntidades.razSocial"),
			Messages.getStringToKey("dtEntidades.titulotabla")));						
			if(razSocial!=null){
				if(razSocial.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.noexceder"),
			Messages.getStringToKey("dtEntidades.razSocial"),
			Messages.getStringToKey("dtEntidades.titulotabla"),200,
			Messages.getStringToKey("dtEntidades.articuloRazSocial")));
				}
	}
	
	public static void validarDireccion(String direccion)
	 throws Validador
	{					
			if(direccion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.ingrese"),
			Messages.getStringToKey("dtEntidades.direccion"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloDireccion")));
			if(direccion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),
			Messages.getStringToKey("dtEntidades.direccion"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloDireccion")));						
			if(direccion!=null){
				if(direccion.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.noexceder"),
			Messages.getStringToKey("dtEntidades.direccion"),
			Messages.getStringToKey("dtEntidades.titulotabla"),300,
			Messages.getStringToKey("dtEntidades.articuloDireccion")));
				}
	}
	
	
	
	
	
	public static void validarRuc(Long ruc)
	 throws Validador
	{				
					if(ruc==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),//MPINARES 24012023 - INICIO
			Messages.getStringToKey("dtEntidades.ruc"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloRuc")));
			if(ruc.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),//MPINARES 24012023 - INICIO
			Messages.getStringToKey("dtEntidades.ruc"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloRuc")));			
	}
	
	public static void validarIdTipo(Long idTipo)
			 throws Validador
				{				
								if(idTipo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),//MPINARES 24012023 - INICIO
						Messages.getStringToKey("dtEntidades.idTipo"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloIdTipo")));
					}
	
	public static void validarIdCaract(Long idCaract)
			 throws Validador
				{				
								if(idCaract==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),//MPINARES 24012023 - INICIO
						Messages.getStringToKey("dtEntidades.idCaract"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloIdCaract")));
					}
	
	public static void validarCodDpto(Integer codDpto)
			 throws Validador
				{				
								if(codDpto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),//MPINARES 24012023 - INICIO
						Messages.getStringToKey("dtEntidades.codDpto"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloCodDpto")));
					}
	
	public static void validarCodProv(Integer codProv)
			 throws Validador
				{				
								if(codProv==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),//MPINARES 24012023 - INICIO
						Messages.getStringToKey("dtEntidades.codProv"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloCodProv")));
					}
	
	public static void validarCodDistr(Integer codDistr)
			 throws Validador
				{				
								if(codDistr==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),//MPINARES 24012023 - INICIO
						Messages.getStringToKey("dtEntidades.codDistr"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloCodDistr")));
					}
	
	
	public static void validarIdpais(Long idpais)
	 throws Validador
	{				
					if(idpais==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.seleccione"),
			Messages.getStringToKey("dtEntidades.idpais"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloIdpais")));
			if(idpais.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),
			Messages.getStringToKey("dtEntidades.idpais"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloIdpais")));			
	}
	public static void validarIdSistAdmi(Long idSistAdmi)
			 throws Validador
				{				
								if(idSistAdmi==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),
						Messages.getStringToKey("dtEntidades.idSistAdmi"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloIdSistAdmi")));
					}
	
	
	
	
	public static void validarGeozona(String geozona)
	 throws Validador
	{					
			if(geozona==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.ingrese"),
			Messages.getStringToKey("dtEntidades.geozona"),
			Messages.getStringToKey("dtEntidades.titulotabla"),
			Messages.getStringToKey("dtEntidades.articuloGeozona")));
			if(geozona.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoingrese"),
			Messages.getStringToKey("dtEntidades.geozona"),
			Messages.getStringToKey("dtEntidades.titulotabla")));						
			if(geozona!=null){
				if(geozona.trim().length()>2)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.noexceder"),
			Messages.getStringToKey("dtEntidades.geozona"),
			Messages.getStringToKey("dtEntidades.titulotabla"),2,
			Messages.getStringToKey("dtEntidades.articuloGeozona")));
				}
	}
	
	//MPINARES 24012023 - INICIO
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidades.invalidoseleccione"),
						Messages.getStringToKey("dtEntidades.idSede"),
						Messages.getStringToKey("dtEntidades.titulotabla"),
						Messages.getStringToKey("dtEntidades.articuloIdSede")));
					}
	//MPINARES 24012023 - FIN
		
}