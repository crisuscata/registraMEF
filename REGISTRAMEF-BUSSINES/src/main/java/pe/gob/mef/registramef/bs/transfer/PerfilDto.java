package pe.gob.mef.registramef.bs.transfer;

public class PerfilDto {

	private int id;
	private String user;
	private Long idUsuario;
	private String ip;
	private Long idSede;
	private String idSede_txt;
	private Long idSistAdmi;
	private String idSistAdmi_txt;
	private Long area;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public Long getIdSistAdmi() {
		return idSistAdmi;
	}

	public void setIdSistAdmi(Long idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}

	public String getIdSede_txt() {
		return idSede_txt;
	}

	public void setIdSede_txt(String idSede_txt) {
		this.idSede_txt = idSede_txt;
	}

	public String getIdSistAdmi_txt() {
		return idSistAdmi_txt;
	}

	public void setIdSistAdmi_txt(String idSistAdmi_txt) {
		this.idSistAdmi_txt = idSistAdmi_txt;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

}