package pe.gob.mef.registramef.bs.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * DT_ANEXO ENTIDAD: ALMACENA LOS DOCUMENTOS ANEXADOS EN EL SISTEMA "ANEXO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_ANEXO")
public class DtAnexo implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6073499329275215160L;

	// ID
	private Long idAnexo = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String filename = null;
	private String filenameoriginal = null;
	private Long estado = null;
	private Long idTiposervicio = null;
	private Long tipoAnexo = null;
	private Long idmaestro = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long flagMaterialCapa = null;
	

	public DtAnexo() {
	}

	@SequenceGenerator(name = "G_DT_ANEXO", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_ANEXO", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_ANEXO")
@Id
@Column(name = "ID_ANEXO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdAnexo()
{
		return this.idAnexo;
}

public void setIdAnexo(Long idAnexo)
{
		this.idAnexo = idAnexo;
}

@Column(name = "IDUSSER_CREA", precision = 10, scale = 0)
public Long  getIdusserCrea()
{
		return this.idusserCrea;
}

public void setIdusserCrea(Long idusserCrea)
{
		this.idusserCrea = idusserCrea;
}

@Column(name = "IDUSSER_MODIF", precision = 10, scale = 0)
public Long  getIdusserModif()
{
		return this.idusserModif;
}

public void setIdusserModif(Long idusserModif)
{
		this.idusserModif = idusserModif;
}

@Column(name = "FECHA_CREA", length = 7)
public Timestamp  getFechaCrea()
{
		return this.fechaCrea;
}

public void setFechaCrea(Timestamp fechaCrea)
{
		this.fechaCrea = fechaCrea;
}

@Column(name = "FECHA_MODIF", length = 7)
public Timestamp  getFechaModif()
{
		return this.fechaModif;
}

public void setFechaModif(Timestamp fechaModif)
{
		this.fechaModif = fechaModif;
}

@Column(name = "FILENAME", length = 200)
public String  getFilename()
{
		return this.filename;
}

public void setFilename(String filename)
{
		this.filename = filename;
}

@Column(name = "FILENAMEORIGINAL", length = 200)
public String  getFilenameoriginal()
{
		return this.filenameoriginal;
}

public void setFilenameoriginal(String filenameoriginal)
{
		this.filenameoriginal = filenameoriginal;
}

@Column(name = "ESTADO", precision = 10, scale = 0)
public Long  getEstado()
{
		return this.estado;
}

public void setEstado(Long estado)
{
		this.estado = estado;
}

@Column(name = "ID_TIPOSERVICIO", precision = 10, scale = 0)
public Long  getIdTiposervicio()
{
		return this.idTiposervicio;
}

public void setIdTiposervicio(Long idTiposervicio)
{
		this.idTiposervicio = idTiposervicio;
}

@Column(name = "TIPO_ANEXO", precision = 10, scale = 0)
public Long  getTipoAnexo()
{
		return this.tipoAnexo;
}

public void setTipoAnexo(Long tipoAnexo)
{
		this.tipoAnexo = tipoAnexo;
}

@Column(name = "IDMAESTRO", precision = 10, scale = 0)
public Long  getIdmaestro()
{
		return this.idmaestro;
}

public void setIdmaestro(Long idmaestro)
{
		this.idmaestro = idmaestro;
}

@Column(name = "RTMADDRESS", length = 50)
public String  getRtmaddress()
{
		return this.rtmaddress;
}

public void setRtmaddress(String rtmaddress)
{
		this.rtmaddress = rtmaddress;
}

@Column(name = "RTMADDRESSRST", length = 50)
public String  getRtmaddressrst()
{
		return this.rtmaddressrst;
}

public void setRtmaddressrst(String rtmaddressrst)
{
		this.rtmaddressrst = rtmaddressrst;
}

@Column(name = "FLAG_MATERIAL_CAPA", precision = 38, scale = 0)
public Long  getFlagMaterialCapa()
{
		return this.flagMaterialCapa;
}

public void setFlagMaterialCapa(Long flagMaterialCapa)
{
		this.flagMaterialCapa = flagMaterialCapa;
}


			
}
