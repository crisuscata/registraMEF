package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;

/**
 * DT_USUARIO_EXTERNO SERVICIO VALIDACIÓN: ALMACENA A LOS USUARIOS EXTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS EXTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtUsuarioExternoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtUsuarioExternoMng.class.getName());
	
	public static void validarDtUsuarioExternoBk(DtUsuarioExternoBk dtUsuarioExternoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtUsuarioExternoBk.getEstado()!=null && dtUsuarioExternoBk.getEstado().longValue()<=0){
			dtUsuarioExternoBk.setEstado(null);
		}
	        if(dtUsuarioExternoBk.getIdTipodocumento()!=null && dtUsuarioExternoBk.getIdTipodocumento().longValue()<=0){
			dtUsuarioExternoBk.setIdTipodocumento(null);
		}
	        if(dtUsuarioExternoBk.getCodDpto()!=null && dtUsuarioExternoBk.getCodDpto().longValue()<=0){
			dtUsuarioExternoBk.setCodDpto(null);
		}
	        if(dtUsuarioExternoBk.getCodProv()!=null && dtUsuarioExternoBk.getCodProv().longValue()<=0){
			dtUsuarioExternoBk.setCodProv(null);
		}
	        if(dtUsuarioExternoBk.getCodDistr()!=null && dtUsuarioExternoBk.getCodDistr().longValue()<=0){
			dtUsuarioExternoBk.setCodDistr(null);
		}
	        if(dtUsuarioExternoBk.getIdpais()!=null && dtUsuarioExternoBk.getIdpais().longValue()<=0){
			dtUsuarioExternoBk.setIdpais(null);
		}
	        
		//VALIDANDO
		
		//validarNombre(dtUsuarioExternoBk.getNombre());
		if(dtUsuarioExternoBk.getNombre()!=null){
				if(dtUsuarioExternoBk.getNombre().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.nombre"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							100,
							Messages.getStringToKey("dtUsuarioExterno.articuloNombre")
									));				
//				dtUsuarioExternoBk.setNombre(dtUsuarioExternoBk.getNombre().toUpperCase());
				}

		
		//validarAPaterno(dtUsuarioExternoBk.getAPaterno());
		if(dtUsuarioExternoBk.getApaterno()!=null){//CUSCATA - 18062024
			if(dtUsuarioExternoBk.getApaterno().trim().length()>100)//CUSCATA - 18062024
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.aPaterno"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							100,
							Messages.getStringToKey("dtUsuarioExterno.articuloAPaterno")
									));				
//				dtUsuarioExternoBk.setAPaterno(dtUsuarioExternoBk.getAPaterno().toUpperCase());
				}

		
		//validarAMaterno(dtUsuarioExternoBk.getAMaterno());
		if(dtUsuarioExternoBk.getAmaterno()!=null){
				if(dtUsuarioExternoBk.getAmaterno().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.aMaterno"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							100,
							Messages.getStringToKey("dtUsuarioExterno.articuloAMaterno")
									));				
//				dtUsuarioExternoBk.setAMaterno(dtUsuarioExternoBk.getAMaterno().toUpperCase());
				}

		
		//validarDireccion(dtUsuarioExternoBk.getDireccion());
		if(dtUsuarioExternoBk.getDireccion()!=null){
				if(dtUsuarioExternoBk.getDireccion().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.direccion"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							300,
							Messages.getStringToKey("dtUsuarioExterno.articuloDireccion")
							));				
//				dtUsuarioExternoBk.setDireccion(dtUsuarioExternoBk.getDireccion().toUpperCase());
				}

		
		//validarCorreo(dtUsuarioExternoBk.getCorreo());
		if(dtUsuarioExternoBk.getCorreo()!=null){
				if(dtUsuarioExternoBk.getCorreo().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.correo"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							50,
							Messages.getStringToKey("dtUsuarioExterno.articuloCorreo")
									));				
//				dtUsuarioExternoBk.setCorreo(dtUsuarioExternoBk.getCorreo().toUpperCase());
				}

		//validarTelefFijo(dtUsuarioExternoBk.getTelefFijo());

		//validarTelefCell(dtUsuarioExternoBk.getTelefCell());

		
		
		
		
		//validarNumDocu(dtUsuarioExternoBk.getNumDocu());

		
		//validarSexo(dtUsuarioExternoBk.getSexo());
		if(dtUsuarioExternoBk.getSexo()!=null){
				if(dtUsuarioExternoBk.getSexo().trim().length()>1)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.sexo"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							1,
							Messages.getStringToKey("dtUsuarioExterno.articuloSexo")
									));				
//				dtUsuarioExternoBk.setSexo(dtUsuarioExternoBk.getSexo().toUpperCase());
				}

		
		//validarIdTipodocumento(dtUsuarioExternoBk.getIdTipodocumento());

		//validarCodDpto(dtUsuarioExternoBk.getCodDpto());

		//validarCodProv(dtUsuarioExternoBk.getCodProv());

		//validarCodDistr(dtUsuarioExternoBk.getCodDistr());

		//validarIdpais(dtUsuarioExternoBk.getIdpais());

		
		
		
		//validarOtroTelefono(dtUsuarioExternoBk.getOtroTelefono());
		if(dtUsuarioExternoBk.getOtroTelefono()!=null){
				if(dtUsuarioExternoBk.getOtroTelefono().trim().length()>150)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.otroTelefono"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							150,
							Messages.getStringToKey("dtUsuarioExterno.articuloOtroTelefono")
									));				
//				dtUsuarioExternoBk.setOtroTelefono(dtUsuarioExternoBk.getOtroTelefono().toUpperCase());
				}

		
		//validarOtroCelular(dtUsuarioExternoBk.getOtroCelular());
		if(dtUsuarioExternoBk.getOtroCelular()!=null){
				if(dtUsuarioExternoBk.getOtroCelular().trim().length()>150)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.otroCelular"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							150,
							Messages.getStringToKey("dtUsuarioExterno.articuloOtroCelular")
									));				
//				dtUsuarioExternoBk.setOtroCelular(dtUsuarioExternoBk.getOtroCelular().toUpperCase());
				}

		
		//validarNumDocum(dtUsuarioExternoBk.getNumDocum());
		if(dtUsuarioExternoBk.getNumDocum()!=null){
				if(dtUsuarioExternoBk.getNumDocum().trim().length()>20)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtUsuarioExterno.noexceder"),
							Messages.getStringToKey("dtUsuarioExterno.numDocum"),
							Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
							20,
							Messages.getStringToKey("dtUsuarioExterno.articuloNumDocum")
									));				
//				dtUsuarioExternoBk.setNumDocum(dtUsuarioExternoBk.getNumDocum().toUpperCase());
				}

		//validarFlagMedioreg(dtUsuarioExternoBk.getFlagMedioreg());

				
	}

	public static void validarNombre(String nombre)
	 throws Validador
	{					
			if(nombre==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.nombre"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloNombre")));
			if(nombre.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.nombre"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(nombre!=null){
				if(nombre.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.nombre"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),100,
			Messages.getStringToKey("dtUsuarioExterno.articuloNombre")));
				}
	}
	
	public static void validarAPaterno(String aPaterno)
	 throws Validador
	{					
			if(aPaterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.aPaterno"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloAPaterno")));
			if(aPaterno.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.aPaterno"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(aPaterno!=null){
				if(aPaterno.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.aPaterno"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),100,
			Messages.getStringToKey("dtUsuarioExterno.articuloAPaterno")));
				}
	}
	
	public static void validarAMaterno(String aMaterno)
	 throws Validador
	{					
			if(aMaterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.aMaterno"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloAMaterno")));
			if(aMaterno.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.aMaterno"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(aMaterno!=null){
				if(aMaterno.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.aMaterno"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),100,
			Messages.getStringToKey("dtUsuarioExterno.articuloAMaterno")));
				}
	}
	
	public static void validarDireccion(String direccion)
	 throws Validador
	{					
			if(direccion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.direccion"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloDireccion")));
			if(direccion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.direccion"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloDireccion")));						
			if(direccion!=null){
				if(direccion.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.direccion"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),300,
			Messages.getStringToKey("dtUsuarioExterno.articuloDireccion")));
				}
	}
	
	public static void validarCorreo(String correo)
	 throws Validador
	{					
			if(correo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.correo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloCorreo")));
			if(correo.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.correo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(correo!=null){
				if(correo.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.correo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),50,
			Messages.getStringToKey("dtUsuarioExterno.articuloCorreo")));
				}
	}
	
	public static void validarTelefFijo(Long telefFijo)
	 throws Validador
	{				
					if(telefFijo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.seleccione"),
			Messages.getStringToKey("dtUsuarioExterno.telefFijo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloTelefFijo")));
			if(telefFijo.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoseleccione"),
			Messages.getStringToKey("dtUsuarioExterno.telefFijo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloTelefFijo")));			
	}
	
	public static void validarTelefCell(Long telefCell)
	 throws Validador
	{				
					if(telefCell==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.seleccione"),
			Messages.getStringToKey("dtUsuarioExterno.telefCell"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloTelefCell")));
			if(telefCell.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoseleccione"),
			Messages.getStringToKey("dtUsuarioExterno.telefCell"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloTelefCell")));			
	}
	
	
	
	
	
	public static void validarNumDocu(Long numDocu)
	 throws Validador
	{				
					if(numDocu==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.seleccione"),
			Messages.getStringToKey("dtUsuarioExterno.numDocu"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloNumDocu")));
			if(numDocu.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoseleccione"),
			Messages.getStringToKey("dtUsuarioExterno.numDocu"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloNumDocu")));			
	}
	
	public static void validarSexo(String sexo)
	 throws Validador
	{					
			if(sexo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.sexo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloSexo")));
			if(sexo.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.sexo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(sexo!=null){
				if(sexo.trim().length()>1)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.sexo"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),1,
			Messages.getStringToKey("dtUsuarioExterno.articuloSexo")));
				}
	}
	
	public static void validarIdTipodocumento(Long idTipodocumento)
			 throws Validador
				{				
								if(idTipodocumento==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
						Messages.getStringToKey("dtUsuarioExterno.idTipodocumento"),
						Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
						Messages.getStringToKey("dtUsuarioExterno.articuloIdTipodocumento")));
					}
	
	public static void validarCodDpto(Integer codDpto)
			 throws Validador
				{				
								if(codDpto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
						Messages.getStringToKey("dtUsuarioExterno.codDpto"),
						Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
						Messages.getStringToKey("dtUsuarioExterno.articuloCodDpto")));
					}
	
	public static void validarCodProv(Integer codProv)
			 throws Validador
				{				
								if(codProv==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
						Messages.getStringToKey("dtUsuarioExterno.codProv"),
						Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
						Messages.getStringToKey("dtUsuarioExterno.articuloCodProv")));
					}
	
	public static void validarCodDistr(Integer codDistr)
			 throws Validador
				{				
								if(codDistr==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
						Messages.getStringToKey("dtUsuarioExterno.codDistr"),
						Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
						Messages.getStringToKey("dtUsuarioExterno.articuloCodDistr")));
					}
	
	
	public static void validarIdpais(Long idpais)
	 throws Validador
	{				
					if(idpais==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.seleccione"),
			Messages.getStringToKey("dtUsuarioExterno.idpais"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloIdpais")));
			if(idpais.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoseleccione"),
			Messages.getStringToKey("dtUsuarioExterno.idpais"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloIdpais")));			
	}
	
	
	
	public static void validarOtroTelefono(String otroTelefono)
	 throws Validador
	{					
			if(otroTelefono==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.otroTelefono"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloOtroTelefono")));
			if(otroTelefono.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.otroTelefono"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(otroTelefono!=null){
				if(otroTelefono.trim().length()>150)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.otroTelefono"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),150,
			Messages.getStringToKey("dtUsuarioExterno.articuloOtroTelefono")));
				}
	}
	
	public static void validarOtroCelular(String otroCelular)
	 throws Validador
	{					
			if(otroCelular==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.otroCelular"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloOtroCelular")));
			if(otroCelular.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.otroCelular"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(otroCelular!=null){
				if(otroCelular.trim().length()>150)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.otroCelular"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),150,
			Messages.getStringToKey("dtUsuarioExterno.articuloOtroCelular")));
				}
	}
	
	public static void validarNumDocum(String numDocum)
	 throws Validador
	{					
			if(numDocum==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.ingrese"),
			Messages.getStringToKey("dtUsuarioExterno.numDocum"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloNumDocum")));
			if(numDocum.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoingrese"),
			Messages.getStringToKey("dtUsuarioExterno.numDocum"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla")));						
			if(numDocum!=null){
				if(numDocum.trim().length()>20)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.noexceder"),
			Messages.getStringToKey("dtUsuarioExterno.numDocum"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),20,
			Messages.getStringToKey("dtUsuarioExterno.articuloNumDocum")));
				}
	}
	
	public static void validarFlagMedioreg(Long flagMedioreg)
	 throws Validador
	{				
					if(flagMedioreg==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.seleccione"),
			Messages.getStringToKey("dtUsuarioExterno.flagMedioreg"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloFlagMedioreg")));
			if(flagMedioreg.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtUsuarioExterno.invalidoseleccione"),
			Messages.getStringToKey("dtUsuarioExterno.flagMedioreg"),
			Messages.getStringToKey("dtUsuarioExterno.titulotabla"),
			Messages.getStringToKey("dtUsuarioExterno.articuloFlagMedioreg")));			
	}
		
}