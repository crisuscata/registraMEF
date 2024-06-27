package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.DtUsuarioExternoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtUsuarioExterno;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_USUARIO_EXTERNO REPOSITORIO: LISTA DE LOS USUARIOS EXTERNOS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtUsuarioExternoDaoImp extends
		AbstractJpaCRUDDao<DtUsuarioExterno, Long> implements
		DtUsuarioExternoDao {

	private static final Logger log = Logger.getLogger(DtUsuarioExternoDaoImp.class.getName());

	public DtUsuarioExternoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtUsuarioExternoDaoImp");
	}
	
	public DtUsuarioExternoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtUsuarioExternoDaoImp");
	}
	
	@Transactional
	public void saveDtUsuarioExterno(DtUsuarioExterno param) {
		super.save(param);
	}

	@Transactional
	public void updateDtUsuarioExterno(DtUsuarioExterno param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtUsuarioExterno(DtUsuarioExterno param) {
		super.delete(param);
	}

	public List<DtUsuarioExterno> getAllDtUsuarioExterno() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtUsuarioExterno getDtUsuarioExterno(Long id) {
		return super.findById(id);
	}

	public List<DtUsuarioExterno> getNativeSQLDtUsuarioExterno(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtUsuarioExterno> getDomainClass() {
		return DtUsuarioExterno.class;
	}

	public List<DtUsuarioExterno> getActivasDtUsuarioExterno() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtUsuarioExterno> getActivasDtUsuarioExternoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtUsuarioExterno> getDesactivasDtUsuarioExterno() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtUsuarioExterno> getByIdDtUsuarioExterno(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idUsuexterno = ? order by t.idUsuexterno asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtUsuarioExterno> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idUsuexterno) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	//INICIO CUSCATA - 18062024
		@Override
		public List<DtUsuarioExterno> getXFiltro(String aPaterno,String aMaterno,String nombre,Long numDocu,String correo,Long telefFijo,Long telefCell,Timestamp fechaModif,Long estado) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

			
			if (aPaterno != null && aPaterno.trim().length() > 0) {
				sb.append("and t.apaterno = ? ");
				hs.add(aPaterno);
			}
			if (aMaterno != null && aMaterno.trim().length() > 0) {
				sb.append("and t.amaterno = ? ");
				hs.add(aMaterno);
			}
			if (nombre != null && nombre.trim().length() > 0) {
				sb.append("and t.nombre = ? ");
				hs.add(nombre);
			}
			if (numDocu != null) {
				sb.append("and t.numDocu = ? ");
				hs.add(numDocu);
			}
			if (correo != null && correo.trim().length() > 0) {
				sb.append("and t.correo = ? ");
				hs.add(correo);
			}
			if (telefFijo != null) {
				sb.append("and t.telefFijo = ? ");
				hs.add(telefFijo);
			}
			if (telefCell != null) {
				sb.append("and t.telefCell = ? ");
				hs.add(telefCell);
			}
			if (fechaModif != null) {
				sb.append("and t.fechaModif = ? ");
				hs.add(fechaModif);
			}
			if (estado != null) {
				sb.append("and t.estado = ? ");
				hs.add(estado);
			}		
			// sb.append("order by t.idUsuexterno desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtUsuarioExterno> lista = super.find(sb.toString(), param);

			return lista;
		}

		@Override
		public List<DtUsuarioExterno> getXFiltro(String aPaterno,String aMaterno,String nombre,Long numDocu,String correo,Long telefFijo,Long telefCell,Timestamp fechaModif,Long estado, int iniciar, int max) {
			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

			
					if (aPaterno != null && aPaterno.trim().length() > 0) {
						sb.append("and t.apaterno = ? ");
						hs.add(aPaterno);
					}
					if (aMaterno != null && aMaterno.trim().length() > 0) {
						sb.append("and t.amaterno = ? ");
						hs.add(aMaterno);
					}
					if (nombre != null && nombre.trim().length() > 0) {
						sb.append("and t.nombre = ? ");
						hs.add(nombre);
					}
					if (numDocu != null) {
						sb.append("and t.numDocu = ? ");
						hs.add(numDocu);
					}
					if (correo != null && correo.trim().length() > 0) {
						sb.append("and t.correo = ? ");
						hs.add(correo);
					}
					if (telefFijo != null) {
						sb.append("and t.telefFijo = ? ");
						hs.add(telefFijo);
					}
					if (telefCell != null) {
						sb.append("and t.telefCell = ? ");
						hs.add(telefCell);
					}
					if (fechaModif != null) {
						sb.append("and t.fechaModif = ? ");
						hs.add(fechaModif);
					}
					if (estado != null) {
						sb.append("and t.estado = ? ");
						hs.add(estado);
					}
			// sb.append("order by t.idUsuexterno desc ");

			List<DtUsuarioExterno> lista = null;
			if (hs.size() > 0) {
				Object param[] = new Object[hs.size()];
				hs.toArray(param);
				lista = super.findLimitedResult(sb.toString(), iniciar, (max + 1), param);
				return lista;
			} else {
				lista = super.findLimitedResult(sb.toString(), iniciar, (max + 1));
				return lista;
			}
		}

		@Override
		public long getTotalXFiltro(String aPaterno,String aMaterno,String nombre,Long numDocu,String correo,Long telefFijo,Long telefCell,Timestamp fechaModif,Long estado) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select count(t.idUsuexterno) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

			
					if (aPaterno != null && aPaterno.trim().length() > 0) {
						sb.append("and t.apaterno = ? ");
						hs.add(aPaterno);
					}
					if (aMaterno != null && aMaterno.trim().length() > 0) {
						sb.append("and t.amaterno = ? ");
						hs.add(aMaterno);
					}
					if (nombre != null && nombre.trim().length() > 0) {
						sb.append("and t.nombre = ? ");
						hs.add(nombre);
					}
					if (numDocu != null) {
						sb.append("and t.numDocu = ? ");
						hs.add(numDocu);
					}
					if (correo != null && correo.trim().length() > 0) {
						sb.append("and t.correo = ? ");
						hs.add(correo);
					}
					if (telefFijo != null) {
						sb.append("and t.telefFijo = ? ");
						hs.add(telefFijo);
					}
					if (telefCell != null) {
						sb.append("and t.telefCell = ? ");
						hs.add(telefCell);
					}
					if (fechaModif != null) {
						sb.append("and t.fechaModif = ? ");
						hs.add(fechaModif);
					}
					if (estado != null) {
						sb.append("and t.estado = ? ");
						hs.add(estado);
					}
							
			if (hs.size() > 0) {
				Object param[] = new Object[hs.size()];
				hs.toArray(param);
				Object o = super.findUniqueResultObject(sb.toString(), param);
				long retorno = 0;
				if (o instanceof java.lang.Long) {
					retorno = ((Long) o).longValue();
				}
				return retorno;
			} else {
				Object o = super.findUniqueResultObject(sb.toString());
				long retorno = 0;
				if (o instanceof java.lang.Long) {
					retorno = ((Long) o).longValue();
				}
				return retorno;
			}
		}
		
		@Override
		public List<DtUsuarioExterno> getListaNombre(String nombre) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("SELECT tablaa FROM DtUsuarioExterno tablaa ");
			sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" AND tablaa.nombre LIKE '%"+nombre+"%'");
			sb.append("ORDER BY tablaa.nombre asc ");
			return super.find(sb.toString());
		}
		
		//PURIBE 14032024 - INICIO-->
			@Override
			public long getTotalXFiltro(String nombre,String aPaterno,String aMaterno,String direccion,Integer codDpto,Integer codProv,Integer codDistr,String numDocum) {

				StringBuffer sb = new StringBuffer(100);
				List<Object> hs = new ArrayList<Object>();
				sb.append("select count(t.idUsuexterno) from " + getDomainClass().getName() + " t where t.estado >= 1 ");

				
						if (nombre != null && nombre.trim().length() > 0) {
							sb.append("and t.nombre = ? ");
							hs.add(nombre);
						}
						if (aPaterno != null && aPaterno.trim().length() > 0) {
							sb.append("and t.apaterno = ? ");
							hs.add(aPaterno);
						}
						if (aMaterno != null && aMaterno.trim().length() > 0) {
							sb.append("and t.amaterno = ? ");
							hs.add(aMaterno);
						}
						if (direccion != null) {
							sb.append("and t.direccion = ? ");
							hs.add(direccion);
						}
						if (codDpto != null) {
							sb.append("and t.codDpto = ? ");
							hs.add(codDpto);
						}
						if (codProv != null) {
							sb.append("and t.codProv = ? ");
							hs.add(codProv);
						}
						if (codDistr != null) {
							sb.append("and t.codDistr = ? ");
							hs.add(codDistr);
						}
						if (numDocum != null && numDocum.trim().length() > 0) {
							sb.append("and t.numDocum = ? ");
							hs.add(numDocum);
						}
								
				if (hs.size() > 0) {
					Object param[] = new Object[hs.size()];
					hs.toArray(param);
					Object o = super.findUniqueResultObject(sb.toString(), param);
					long retorno = 0;
					if (o instanceof java.lang.Long) {
						retorno = ((Long) o).longValue();
					}
					return retorno;
				} else {
					Object o = super.findUniqueResultObject(sb.toString());
					long retorno = 0;
					if (o instanceof java.lang.Long) {
						retorno = ((Long) o).longValue();
					}
					return retorno;
				}
			}

			@Override
			public List<DtUsuarioExterno> getXFiltro(String nombre,String aPaterno,String aMaterno,String direccion,Integer codDpto,Integer codProv,Integer codDistr,String numDocum) {

				StringBuffer sb = new StringBuffer(100);
				List<Object> hs = new ArrayList<Object>();
				sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= 1 ");

				
				if (nombre != null && nombre.trim().length() > 0) {
					sb.append("and t.nombre = ? ");
					hs.add(nombre);
				}
				if (aPaterno != null && aPaterno.trim().length() > 0) {
					sb.append("and t.apaterno = ? ");
					hs.add(aPaterno);
				}
				if (aMaterno != null && aMaterno.trim().length() > 0) {
					sb.append("and t.amaterno = ? ");
					hs.add(aMaterno);
				}
				if (direccion != null) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.codDistr = ? ");
					hs.add(codDistr);
				}
				if (numDocum != null && numDocum.trim().length() > 0) {
					sb.append("and t.numDocum = ? ");
					hs.add(numDocum);
				}		
				// sb.append("order by t.idUsuexterno desc ");

				Object param[] = new Object[hs.size()];
				hs.toArray(param);
				List<DtUsuarioExterno> lista = super.find(sb.toString(), param);

				return lista;
			}
			

			//PURIBE 22042024 - INICIO-->
			
					@Override
					public List<DtUsuarioExterno> getXFiltroList(String nombre) {
						
						StringBuffer sb = new StringBuffer(100);
				                List<Object> hs = new ArrayList<Object>();		
						sb.append("select t from DtUsuarioExterno"
								+ " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
						
				
						if (nombre != null && nombre.trim().length() > 0) {
						    String nombreMayusculas = nombre.toUpperCase();
						    sb.append(" and ( t.nombre like ? or t.apellidoPaterno like ? or t.apellidoMaterno like ? ) ");
							 hs.add("%" + nombreMayusculas + "%");
							 hs.add("%" + nombreMayusculas + "%");
							 hs.add("%" + nombreMayusculas + "%");
						}
					
						//sb.append(" order by t.aPaterno, t.aMaterno, t.nombre asc  ");
						
						Object param[] = new Object[hs.size()];
						hs.toArray(param);
						List<DtUsuarioExterno> lista = super.find(sb.toString(), param);
						//List<DtUsuarioExterno> lista = super.findLimitedResult(sb.toString(), 0, 100,param);

						return lista;	
					}
					
					@Override
					public List<DtUsuarioExterno> getDtUsuarioExtByNombreapellido(String[] nombreapellido) {
						StringBuffer sb = new StringBuffer(100);
						List<Object> parameters = new ArrayList<Object>();
						
						sb.append("select t from " + this.getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
						
						if(nombreapellido.length > 0 && nombreapellido[0]!=null && !nombreapellido[0].trim().isEmpty()){
							sb.append("and UPPER(t.apaterno) LIKE ? ");
					        parameters.add("%" + nombreapellido[0].toUpperCase() + "%");
						}
						if (nombreapellido.length > 1 && nombreapellido[1] != null && !nombreapellido[1].trim().isEmpty()) {
							sb.append("and UPPER(t.amaterno) LIKE ? ");
					        parameters.add("%" + nombreapellido[1].toUpperCase() + "%");
				        }
						if (nombreapellido.length > 2 && nombreapellido[2] != null && !nombreapellido[2].trim().isEmpty()) {
							sb.append("and UPPER(t.nombre) LIKE ? ");
					        parameters.add("%" + nombreapellido[2].toUpperCase() + "%");
					    }
						sb.append("ORDER BY t.apaterno ASC");
						
						Object[] paramArray = new Object[parameters.size()];
						parameters.toArray(paramArray);
						
						List<DtUsuarioExterno> lista = super.find(sb.toString(), paramArray);
						
						
						return lista;
					}
					
					//JPUYEN 14052024 - INICIO
					@Override
					public List<DtUsuarioExterno> getDtUsuarioExtByDni(String dni) {
						StringBuffer sb = new StringBuffer(100);
						sb.append("select t from " + this.getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
						List<Object> hs = new ArrayList<Object>();
						if (dni != null && dni.length()>=0) {
							sb.append("and t.numDocum = ? ");
							hs.add(dni);
						}
						Object[] param = new Object[hs.size()];
						hs.toArray(param);
						List<DtUsuarioExterno> lista = super.find(sb.toString(), param);
						return lista;
					}
					
//					@Override
//					public List<DtUsuarioExterno> getDtUsuarioExtByNombreapellido(String[] nombreapellido) {
//						StringBuffer sb = new StringBuffer(100);
//						List<Object> parameters = new ArrayList<Object>();
//						
//						sb.append("select t from " + this.getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
//						
//						if(nombreapellido.length > 0 && nombreapellido[0]!=null && !nombreapellido[0].trim().isEmpty()){
//							sb.append("and UPPER(t.apaterno) LIKE ? ");
//					        parameters.add("%" + nombreapellido[0].toUpperCase() + "%");
//						}
//						if (nombreapellido.length > 1 && nombreapellido[1] != null && !nombreapellido[1].trim().isEmpty()) {
//							sb.append("and UPPER(t.amaterno) LIKE ? ");
//					        parameters.add("%" + nombreapellido[1].toUpperCase() + "%");
//				        }
//						if (nombreapellido.length > 2 && nombreapellido[2] != null && !nombreapellido[2].trim().isEmpty()) {
//							sb.append("and UPPER(t.nombre) LIKE ? ");
//					        parameters.add("%" + nombreapellido[2].toUpperCase() + "%");
//					    }
//						sb.append("ORDER BY t.apaterno ASC");
//						
//						Object[] paramArray = new Object[parameters.size()];
//						parameters.toArray(paramArray);
//						
//						
//						List<DtUsuarioExterno> lista = super.find(sb.toString(), paramArray);
//						
//						
//						return lista;
//						
//					/*	StringBuffer sb = new StringBuffer(100);
//						sb.append("SELECT t FROM DtUsuarioExterno t ");
//						sb.append("WHERE t.estado >= "+Estado.ACTIVO.getValor()+" ");
//						if(nombreapellido.length > 0 && nombreapellido[0]!=null && !nombreapellido[0].trim().isEmpty()){
//							sb.append("and t.apaterno LIKE '%" + nombreapellido[0] + "%'");
//						}
//						if (nombreapellido.length > 1 && nombreapellido[1] != null && !nombreapellido[1].trim().isEmpty()) {
//							sb.append("and t.amaterno LIKE '%" + nombreapellido[1] + "%'");
//				        }
//						if (nombreapellido.length > 2 && nombreapellido[2] != null && !nombreapellido[2].trim().isEmpty()) {
//							sb.append("and t.nombre LIKE '%" + nombreapellido[2] + "%'");
//					    }
//						sb.append(" ORDER BY t.nombre asc ");
//						return super.find(sb.toString());*/
//						
//					}
					
				//JPUYEN 14052024 - FIN
}